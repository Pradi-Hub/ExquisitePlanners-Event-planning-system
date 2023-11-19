package com.IT22603418.IT22603418_models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.IT22603418.IT22603418_DBconnection.IT22603418_DBConnect;
import com.IT22603418.IT22603418_javaclasses.IT22603418_Contactinterface;
import com.IT22603418.IT22603418_javaclasses.IT22603418_FeedbackDetails;
import com.IT22603418.IT22603418_javaclasses.IT22603418_ReserveLogger;

public class IT22603418_ContactDBUtil implements IT22603418_Contactinterface{
	private static boolean isSuccess;
    private static Connection con = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

	IT22603418_ReserveLogger logger = IT22603418_ReserveLogger.getInstance();	

    public int getFid(String email) {
        int Fid = 0;

        try {
            con = IT22603418_DBConnect.getConnection();
            String sql = "SELECT Fid FROM Feedback WHERE email=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            if (rs.next()) {
            	Fid = rs.getInt(1);
            }
        } catch (Exception e) {
        	logger.logExceptionWarning("An error exception (getFid):", e);
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

        return Fid;
    }
    
    public List<IT22603418_FeedbackDetails> validateFeedback(int Fid){
		
		ArrayList<IT22603418_FeedbackDetails> feed = new ArrayList<>();
		
		try {
			con = IT22603418_DBConnect.getConnection();
			String sql = "select* from Feedback where Fid = ?";
			pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, Fid);
	        rs = pstmt.executeQuery();
			
			while (rs.next()) {
	            int FidFromDB = rs.getInt("Fid");
	            String email = rs.getString("email");
	            int star = rs.getInt("star");
	            String review = rs.getString("message");

	            IT22603418_FeedbackDetails f = new IT22603418_FeedbackDetails(FidFromDB, email, star, review);
	            feed.add(f);
	        }
			
		}
		catch(Exception e){
			logger.logExceptionWarning("An error exception (validateFeedback):", e);
			e.printStackTrace();	
		}

		return feed;
	}
    
    public boolean contactUsInsert(String name, String email, String message) {
    	try {
    		con = IT22603418_DBConnect.getConnection();
    		String sql = "INSERT INTO Contact (name, email, message) VALUES (?, ?, ?)";
    		pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    		pstmt.setString(1, name);
    		pstmt.setString(2, email);
    		pstmt.setString(3, message);
    		
    		int rs = pstmt.executeUpdate();
    		
    		if (rs > 0) {
    			isSuccess = true;
    		}else {
    			isSuccess = false;
    		}
    		
    	}
    	catch(Exception e){
    		logger.logExceptionWarning("An error exception (contactUsInsert):", e);
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
    
    public boolean FeedbackInsert(String email, int star, String review) {
    	try {
    		con = IT22603418_DBConnect.getConnection();
    		String sql = "INSERT INTO Feedback (email, star, message) VALUES (?, ?, ?)";
    		pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    		pstmt.setString(1, email);
    		pstmt.setInt(2, star);
    		pstmt.setString(3, review);
    		
    		int rs = pstmt.executeUpdate();
    		
    		if(rs >0) {
    			isSuccess = true;
    		}else {
    			isSuccess = false;
    		}
    	}
    	catch(Exception e) {
    		logger.logExceptionWarning("An error exception (FeedbackInsert):", e);
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }

    public List<IT22603418_FeedbackDetails> view(){
		
		ArrayList<IT22603418_FeedbackDetails> feed = new ArrayList<>();
		
		try {
			con = IT22603418_DBConnect.getConnection();
			String sql = "select* from Feedback";
			pstmt = con.prepareStatement(sql);
	        rs = pstmt.executeQuery();
			
			while (rs.next()) {
	            int Fid = rs.getInt("Fid");
	            String email = rs.getString("email");
	            int star = rs.getInt("star");
	            String message = rs.getString("message");

	            IT22603418_FeedbackDetails f = new IT22603418_FeedbackDetails(Fid, email, star, message);
	            feed.add(f);
	        }
			
		}
		catch(Exception e){
			logger.logExceptionWarning("An error exception (view):", e);
			e.printStackTrace();	
		}

		return feed;
	}
      
    public boolean FeedbackUpdate(int Fid, String email, int star, String review) {
    	try {
    		con = IT22603418_DBConnect.getConnection();
            String sql = "UPDATE Feedback SET email=?, star=?, message=? WHERE Fid=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setInt(2, star);
            pstmt.setString(3, review);
            pstmt.setInt(4, Fid);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
    		logger.logExceptionWarning("An error exception (FeedbackUpdate):", e);
            e.printStackTrace();
        } 
    	
    	return isSuccess; 
    }

    public boolean deleteFeedback(int Fid) {
    	try {
    		con = IT22603418_DBConnect.getConnection();
    		String sql = "DELETE FROM feedback WHERE Fid =?";
    		pstmt = con.prepareStatement(sql);
    		pstmt.setInt(1, Fid);
    		
    		int rs = pstmt.executeUpdate();
    		
    		if(rs > 0) {
    			isSuccess = true;
    		}else {
    			isSuccess = false;
    		}
    	}
    	catch(Exception e) {
    		logger.logExceptionWarning("An error exception (deleteFeedback):", e);
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
}
