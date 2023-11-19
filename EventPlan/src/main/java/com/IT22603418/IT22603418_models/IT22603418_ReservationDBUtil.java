package com.IT22603418.IT22603418_models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.IT22603418.IT22603418_DBconnection.IT22603418_DBConnect;
import com.IT22603418.IT22603418_javaclasses.IT22603418_Reservation;
import com.IT22603418.IT22603418_javaclasses.IT22603418_ReservationDetails;
import com.IT22603418.IT22603418_javaclasses.IT22603418_ReserveLogger;
import com.IT22603418.IT22603418_javaclasses.IT22603418_Services;

public class IT22603418_ReservationDBUtil implements IT22603418_Reservation {
    private static boolean isSuccess;
    private static Connection con = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    //create logger object
    IT22603418_ReserveLogger logger = IT22603418_ReserveLogger.getInstance();	
    
    //get resId from email
    public int getResid(String email) {
        int Resid = 0;

        try {
            con = IT22603418_DBConnect.getConnection();
            String sql = "SELECT Resid FROM eventreservation WHERE email=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Resid = rs.getInt(1);
            }
        } catch (Exception e) {
        	logger.logExceptionWarning("An error exception (getResid):", e);
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return Resid;
    }
    //insert into ReservationDetails class list
    public List<IT22603418_ReservationDetails> validate(int Resid){
		
		ArrayList<IT22603418_ReservationDetails> res = new ArrayList<>();
		
		try {
			con = IT22603418_DBConnect.getConnection();
			String sql = "select* from eventreservation where Resid = ?";
			pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, Resid);
	        rs = pstmt.executeQuery();
			
			while (rs.next()) {
	            int ResidFromDB = rs.getInt("Resid");
	            String fullname = rs.getString("fullname");
	            String phone = rs.getString("phone");
	            String email = rs.getString("email");
	            LocalDate date = LocalDate.parse(rs.getString("date"));
	            LocalTime time = LocalTime.parse(rs.getString("time"));
	            String location = rs.getString("location");
	            String Package = rs.getString("Package");
	            int guestcount = rs.getInt("guestcount");
	            String eventType = rs.getString("eventType");
	            String Splrequest = rs.getString("splrequest");

	            IT22603418_ReservationDetails r = new IT22603418_ReservationDetails(ResidFromDB, fullname, phone, email, date, time, location, Package, guestcount, eventType, Splrequest);
	            res.add(r);
	        }
			
		}
		catch(Exception e){
			logger.logExceptionWarning("An error exception (validate):", e);
			e.printStackTrace();	
		}

		return res;
	}
    //insert into Services class list  
    public List<IT22603418_Services> iT22603418_Services(int Resid) {
    	ArrayList<IT22603418_Services> ser = new ArrayList<>();
		
		try {
			con = IT22603418_DBConnect.getConnection();
			String sql = "select* from additionalservices where Resid = ?";
			pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, Resid);
	        rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int Sid = rs.getInt("Sid");
	            int ResidFromDB = rs.getInt("Resid");
	            String DJ_Music = rs.getString("DJ_Music");
	            String Games_Activities = rs.getString("Games_Activities");
	            String PhotoBooth = rs.getString("PhotoBooth");
	            String Photographer = rs.getString("Photographer");
	            String FloralDeco = rs.getString("FloralDeco");
	            String CenterpiecesDeco = rs.getString("CenterpiecesDeco");
	            String BalloonDeco = rs.getString("BalloonDeco");

	            IT22603418_Services s = new IT22603418_Services(Sid, ResidFromDB, DJ_Music, Games_Activities, PhotoBooth, Photographer, FloralDeco, CenterpiecesDeco, BalloonDeco);
	            ser.add(s);
	        }
			
		}
		catch(Exception e){
			logger.logExceptionWarning("An error exception (services):", e);
			e.printStackTrace();	
		}

		return ser;
	}
    //insert to reservation and service table
    public boolean insertReservation(String fullname, String phone, String email, String date, String time,
            String location, String Package, String guestcount, String eventType, String d1, String d2, String d3, String photographers, String e1, String e2, String e3,String splrequest) {
        try {
            con = IT22603418_DBConnect.getConnection();
            String sql1 = "INSERT INTO EventReservation (fullname, phone, email, date, time,"
                    + " location, Package, guestcount, eventType, splrequest) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Create a PreparedStatement with RETURN_GENERATED_KEYS option
            pstmt = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, fullname);
            pstmt.setString(2, phone);
            pstmt.setString(3, email);
            pstmt.setString(4, date);
            pstmt.setString(5, time);
            pstmt.setString(6, location);
            pstmt.setString(7, Package);
            pstmt.setString(8, guestcount);
            pstmt.setString(9, eventType);
            pstmt.setString(10, splrequest);

            int rs1 = pstmt.executeUpdate();

            if (rs1 > 0) {
                // Retrieve the generated keys
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int reservationId = rs.getInt(1);

                    // Insert data into AdditionalServices table using the obtained reservation ID
                    String sql2 = "INSERT INTO AdditionalServices (Resid, DJ_Music, Games_Activities, PhotoBooth, Photographer, FloralDeco, CenterpiecesDeco, BalloonDeco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    pstmt = con.prepareStatement(sql2);
                    pstmt.setInt(1, reservationId);
                    pstmt.setString(2, e1);
                    pstmt.setString(3, e2);
                    pstmt.setString(4, e3);
                    pstmt.setString(5, photographers);
                    pstmt.setString(6, d1);
                    pstmt.setString(7, d2);
                    pstmt.setString(8, d3);
                    
                    int rowsAffected = pstmt.executeUpdate();
                    
	
	                if (rowsAffected > 0) {
	                        isSuccess = true;
	                    }
                    }
            } else {
                isSuccess = false;
            }
        } catch (Exception e) {
        	logger.logExceptionWarning("An error exception (insertReservation):", e);
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }
    //update reservation table
    public boolean updateReservation(int Resid, String fullname, String phone, String email, String date, String time,
            String location, String Package, String guestcount, String eventType, String splrequest) {
    	
    	try {
    		con = IT22603418_DBConnect.getConnection();
            String sql = "UPDATE EventReservation SET fullname=?, phone=?, email=?, date=?, time=?, location=?, Package=?, guestcount=?, eventType=?, splrequest=? WHERE Resid=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, fullname);
            pstmt.setString(2, phone);
            pstmt.setString(3, email);
            pstmt.setString(4, date);
            pstmt.setString(5, time);
            pstmt.setString(6, location);
            pstmt.setString(7, Package);
            pstmt.setString(8, guestcount);
            pstmt.setString(9, eventType);
            pstmt.setString(10, splrequest);
            pstmt.setInt(11, Resid);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
        	logger.logExceptionWarning("An error exception (updateReservation):", e);
            e.printStackTrace();
        } 
    	
    	return isSuccess; 
    	
    }   
    //update services table
    public boolean updateServices(int Resid, String d1, String d2, String d3, String photographers, String e1, String e2, String e3) {
    	
    	try {
    		con = IT22603418_DBConnect.getConnection();
    		 // Insert data into AdditionalServices table using the obtained reservation ID
    	    String sql2 = "UPDATE AdditionalServices SET DJ_Music=?, Games_Activities=?, PhotoBooth=?, Photographer=?, FloralDeco=?, CenterpiecesDeco=?, BalloonDeco=? WHERE Resid=?";
    	    pstmt = con.prepareStatement(sql2);
    	    pstmt.setString(1, e1);
    	    pstmt.setString(2, e2);
    	    pstmt.setString(3, e3);
    	    pstmt.setString(4, photographers);
    	    pstmt.setString(5, d1);
    	    pstmt.setString(6, d2);
    	    pstmt.setString(7, d3);
    	    pstmt.setInt(8, Resid);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
        	logger.logExceptionWarning("An error exception (updateServices):", e);
            e.printStackTrace();
        } 
    	
    	return isSuccess; 
    	
    }    
    //delete reservation
    public boolean deleteReservation(int Resid) {
    	
    	try {
    		con = IT22603418_DBConnect.getConnection();
            String sql = "DELETE FROM EventReservation WHERE Resid=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, Resid);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                isSuccess = true;
            }else {
            	isSuccess = false;
            }
        } catch (Exception e) {
			logger.logExceptionWarning("An error exception (deleteReservtion):", e);
            e.printStackTrace();
        } 
    	
    	return isSuccess; 
    	
    }
    
}
