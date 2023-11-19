package com.IT22602978Events.EventModels;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.IT22602978Events.DBConnection.DBconnectionT;
import com.IT22602978Events.EventClass.getInformation;

import java.sql.Connection;

import java.sql.PreparedStatement;


public  class EventinsertDB implements EventInterface {
	private static Connection con =null;
	private static Statement stmt =null;
	private static ResultSet resultSet=null;
	private static int rs;
	
	@Override
	public String insertEvent(String Cxname, String phonenum, String email, String dateTimeString, String eventtype, String packagetype, String specialrqst) {
	    String message = null;

	    try {
	        con = DBconnectionT.getconnection();

	        // Check if the phone number or email is already in use
	        String checkQuery = "SELECT * FROM reservations WHERE phonenum = ? OR email = ?";
	        PreparedStatement checkStatement = con.prepareStatement(checkQuery);
	        checkStatement.setString(1, phonenum);
	        checkStatement.setString(2, email);
	        ResultSet resultSet = checkStatement.executeQuery();

	        if (resultSet.next()) {
	            if (resultSet.getString("phonenum").equals(phonenum)) {
	                message = "Phone number already in use.";
	            } else if (resultSet.getString("email").equals(email)) {
	                message = "Email already in use.";
	            }
	        } else {
	            // Insert the new record into the database
	            String insertQuery = "INSERT INTO reservations (fullname, phonenum, email, datetime, eventtype, packagetype, specialrqst) VALUES (?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement insertStatement = con.prepareStatement(insertQuery,Statement.RETURN_GENERATED_KEYS);
	            insertStatement.setString(1, Cxname);
	            insertStatement.setString(2, phonenum);
	            insertStatement.setString(3, email);
	            insertStatement.setString(4, dateTimeString);
	            insertStatement.setString(5, eventtype);
	            insertStatement.setString(6, packagetype);
	            insertStatement.setString(7, specialrqst);
	            int rs = insertStatement.executeUpdate();

	            if (rs > 0) {
	                message = "Event inserted successfully.";
	            } else {
	                message = "Event insertion failed.";
	            }
	        }

	        resultSet.close();
	        checkStatement.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	        message = "An error occurred: " + e.getMessage();
	    }

	    return message;
	}

	
	
	
	
	
	public static int generateReservationId(String phonenum, String email) throws SQLException {
	    int reservation_id = 0;

	    try {
	    	//create the connection
	        Connection con = DBconnectionT.getconnection();
	        //with creating prepared statement check the reservation id
	        PreparedStatement preparedStatement = con.prepareStatement("SELECT reservationsid FROM reservations WHERE phonenum = ? AND email = ?");
	        preparedStatement.setString(1, phonenum);
	        preparedStatement.setString(2, email);

	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	        	// if true integer value copy and pass
	            reservation_id = resultSet.getInt("reservationsid");
	        }

	        resultSet.close();
	        preparedStatement.close();
	        con.close();
	    } catch (SQLException e) {
	        
	        e.printStackTrace();
	        throw e;
	    }

	    return reservation_id;
	}
	@Override
	public String insertInfo() {
		
		return null;
	}
	//overload the insertinfo method
	public String insertInfo(String reserveId, String hotelid, String attendees, String halltype, String furthurdetails) {

	    String message = null;
	    String DateTime = null;

	    try {
	        con = DBconnectionT.getconnection();
	        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM hotel_infrom WHERE reserveId = ?");
	        preparedStatement.setString(1, reserveId);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            if (resultSet.getString("reserveId").equals(reserveId)) {
	                message = "Already hotel reservation is created";
	            }
	        } else {
	            String dateTimeQuery = "SELECT datetime FROM reservations WHERE reservationsid = ?";
	            preparedStatement = con.prepareStatement(dateTimeQuery);
	            preparedStatement.setString(1, reserveId);
	            ResultSet dateTimeResult = preparedStatement.executeQuery();

	            if (dateTimeResult.next()) {
	                DateTime = dateTimeResult.getString("dateTime");
	                // Insert the new record into the database
	                String insertQuery = "INSERT INTO hotel_infrom VALUES (0, ?, ?, ?, ?, ?, ?)";
	                preparedStatement = con.prepareStatement(insertQuery);
	                preparedStatement.setString(1, hotelid);
	                preparedStatement.setString(2, attendees);
	                preparedStatement.setString(3, halltype);
	                preparedStatement.setString(4, furthurdetails);
	                preparedStatement.setString(5, reserveId);
	                preparedStatement.setString(6, DateTime);
	                int rowsAffected = preparedStatement.executeUpdate();

	                if (rowsAffected > 0) {
	                    message = "Event inserted successfully.";
	                } else {
	                    message = "Event insertion failed.";
	                }
	            }
	        }

	        preparedStatement.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	        message = "An error occurred: " + e.getMessage();
	    }

	    return message;
	}

	@Override
	public  String insertInfo(String reserveId, String decorationid, String attendees, String eventtype, String furthurdetails,String eventtheme,String decorationstyle) {
		
		 String message = null;
		 String DateTime=null;
		
		   try {
		       
		         con = DBconnectionT.getconnection();
		         stmt = con.createStatement();

		        // Check if the phone number or email is already in use
		        String checkQuery = "SELECT * FROM decoration_info WHERE reserveId = '" + reserveId + "'";
		         resultSet = stmt.executeQuery(checkQuery);
		        
		        if (resultSet.next()) {
		            if (resultSet.getString("reservationId").equals(reserveId)) {
		                message = "Already Decorration  reservation is created";
		            } 
		        } else {
		        	String dateTime="SELECT datetime FROM reservations WHERE reservationsid='"+reserveId+"'";
		        	resultSet = stmt.executeQuery(dateTime);
		        	if(resultSet.next()){
		        		DateTime=resultSet.getString("dateTime");
		            // Insert the new record into the database
		            String insertQuery = "INSERT INTO decoration_info VALUES (0, '" +decorationid + "', '" + reserveId + "', '" + attendees + "', '" + eventtype + "', '" +eventtheme + "','" +decorationstyle + "','" +furthurdetails + "','" +DateTime + "')";
		             rs = stmt.executeUpdate(insertQuery);
		        	}
		            if (rs > 0) {
		                message = "Event inserted successfully.";
		            } else {
		                message = "Event insertion failed.";
		            }
		        }

		        stmt.close();
		        con.close();

		    } catch (Exception e) {
		        e.printStackTrace();
		        message = "An error occurred: " + e.getMessage();
		    }

		
		
		
		
		return message;
	}

	
	@Override
	public String insertInfo(String reserveId, String cateringid, String attendees, String eventtype, String furthurdetails, String eventtheme, String fooditem, String platetype) {

	    String message = null;
	    String DateTime = null;

	    try {
	        con = DBconnectionT.getconnection();

	        // Check if the catering reservation already exists
	        PreparedStatement checkStatement = con.prepareStatement("SELECT * FROM catering_info WHERE reserveId = ?");
	        checkStatement.setString(1, reserveId);
	        ResultSet resultSet = checkStatement.executeQuery();

	        if (resultSet.next()) {
	            message = "Catering reservation already exists";
	        } else {
	            // Check for the DateTime
	            String dateTimeQuery = "SELECT datetime FROM reservations WHERE reservationsid = ?";
	            PreparedStatement dateTimeStatement = con.prepareStatement(dateTimeQuery);
	            dateTimeStatement.setString(1, reserveId);
	            ResultSet dateTimeResult = dateTimeStatement.executeQuery();

	            if (dateTimeResult.next()) {
	                DateTime = dateTimeResult.getString("datetime");

	                // Insert the new record into the database
	                String insertQuery = "INSERT INTO catering_info VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	                PreparedStatement insertStatement = con.prepareStatement(insertQuery);
	                insertStatement.setString(1, cateringid);
	                insertStatement.setString(2, reserveId);
	                insertStatement.setString(3, attendees);
	                insertStatement.setString(4, eventtype);
	                insertStatement.setString(5, eventtheme);
	                insertStatement.setString(6, fooditem);
	                insertStatement.setString(7, platetype);
	                insertStatement.setString(8, furthurdetails);
	                insertStatement.setString(9, DateTime);

	                int rowsAffected = insertStatement.executeUpdate();

	                if (rowsAffected > 0) {
	                    message = "Event inserted successfully.";
	                } else {
	                    message = "Catering event insertion failed.";
	                }
	            }
	        }

	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	        message = "An error occurred: " + e.getMessage();
	    }

	    return message;
	}

	
	
	@Override
	public String insertInfo2(String reserveId, String phographid, String attendees, String packagetype, String furthurdetails, String eventtheme, String videographer) {

	    String message = null;
	    String DateTime = null;

	    try {
	        con = DBconnectionT.getconnection();

	        // Check if the photography reservation already exists
	        PreparedStatement checkStatement = con.prepareStatement("SELECT * FROM photography_info WHERE reserveId = ?");
	        checkStatement.setString(1, reserveId);
	        ResultSet resultSet = checkStatement.executeQuery();

	        if (resultSet.next()) {
	            message = "Photography reservation already exists";
	        } else {
	            // Check for the DateTime
	            String dateTimeQuery = "SELECT datetime FROM reservations WHERE reservationsid = ?";
	            PreparedStatement dateTimeStatement = con.prepareStatement(dateTimeQuery);
	            dateTimeStatement.setString(1, reserveId);
	            ResultSet dateTimeResult = dateTimeStatement.executeQuery();

	            if (dateTimeResult.next()) {
	                DateTime = dateTimeResult.getString("datetime");

	                // Insert the new record into the database
	                String insertQuery = "INSERT INTO photography_info VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?)";
	                PreparedStatement insertStatement = con.prepareStatement(insertQuery);
	                insertStatement.setString(1, phographid);
	                insertStatement.setString(2, reserveId);
	                insertStatement.setString(3, attendees);
	                insertStatement.setString(4, packagetype);
	                insertStatement.setString(5, eventtheme);
	                insertStatement.setString(6, videographer);
	                insertStatement.setString(7, furthurdetails);
	                insertStatement.setString(8, DateTime);

	                int rowsAffected = insertStatement.executeUpdate();

	                if (rowsAffected > 0) {
	                    message = "Event inserted successfully.";
	                } else {
	                    message = "Photography event insertion failed.";
	                }
	            }
	        }

	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	        message = "An error occurred: " + e.getMessage();
	    }

	    return message;
	}






	public static List<getInformation>Eventcheck(String reserveId) {
		ArrayList<getInformation>details=new ArrayList<>();
		
		try {
		       
	         con = DBconnectionT.getconnection();
	         stmt = con.createStatement();

	        // Check if the phone number or email is already in use
	        String checkQuery = "SELECT * FROM reservations WHERE reservationsid = '" + reserveId + "'";
	         resultSet = stmt.executeQuery(checkQuery);
	        
	        if (resultSet.next()) {
	            
	               int reservationsid=resultSet.getInt(1);
	               String fulllname=resultSet.getString(2);
	               String phonenum =resultSet.getString(3);
	               String email=resultSet.getString(4);
	               String datetime=resultSet.getString(5);
	               String eventtype=resultSet.getString(6);
	               String packagetype=resultSet.getString(7);
	               String specialrqst=resultSet.getString(8);
	               
	               getInformation info=new getInformation(reservationsid,fulllname,phonenum,email,datetime,eventtype,packagetype,specialrqst);
	               details.add(info);
	           
	               
	            
	        
	        }
	        

	        }catch (Exception e) {
	        e.printStackTrace();
	        
	    }
		
		
		return details;
	}
	





	public static  String  hotelcheck(String reserveId) {
		 String message = null;
		 try {
		       
	         con = DBconnectionT.getconnection();
	         stmt = con.createStatement();

	        // Check if the phone number or email is already in use
	        String checkQuery = "SELECT * FROM hotel_infrom WHERE reserveId = '" + reserveId + "'";
	         resultSet = stmt.executeQuery(checkQuery);
	        
	        if (resultSet.next()) {
	            
	                message = "Sent.";
	           
	               
	            
	        } else {
	        	message = "Not Sent.";
	           
	        }

	        stmt.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	        message = "An error occurred: " + e.getMessage();
	    }

		return message;
	}





	public static String  cateringcheck(String reserveId) {
		 String message = null;
		 try {
		       
	         con = DBconnectionT.getconnection();
	         stmt = con.createStatement();

	        // Check if the phone number or email is already in use
	        String checkQuery = "SELECT * FROM catering_info WHERE reserveId = '" + reserveId + "'";
	         resultSet = stmt.executeQuery(checkQuery);
	        
	        if (resultSet.next()) {
	            
	                message = "Sent.";
	           
	               
	            
	        } else {
	        	message = "Not Sent.";
	           
	        }

	        stmt.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	        message = "An error occurred: " + e.getMessage();
	    }

		return message;
	}





	public static String Decorationcheck(String reserveId) {
		 String message = null;
		 try {
		       
	         con = DBconnectionT.getconnection();
	         stmt = con.createStatement();

	        // Check if the phone number or email is already in use
	        String checkQuery = "SELECT * FROM decoration_info WHERE reserveId = '" + reserveId + "'";
	         resultSet = stmt.executeQuery(checkQuery);
	        
	        if (resultSet.next()) {
	            
	                message = "Sent.";
	           
	               
	            
	        } else {
	        	message = "Not Sent.";
	           
	        }

	        stmt.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	        message = "An error occurred: " + e.getMessage();
	    }

		return message;
	}





	public static String Photographycheck(String reserveId) {
		 String message = null;
		 try {
		       
	         con = DBconnectionT.getconnection();
	         stmt = con.createStatement();

	        // Check if the phone number or email is already in use
	        String checkQuery = "SELECT * FROM photography_info WHERE reserveId = '" + reserveId + "'";
	         resultSet = stmt.executeQuery(checkQuery);
	        
	        if (resultSet.next()) {
	            
	                message = "Sent.";
	           
	               
	            
	        } else {
	        	message = "Not Sent.";
	           
	        }

	        stmt.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	        message = "An error occurred: " + e.getMessage();
	    }

		return message;
	}

	public static List<getInformation>AllEventView(){
		List<getInformation>Alldetails=new ArrayList<>();
		
		try {
		       
	         con = DBconnectionT.getconnection();
	         stmt = con.createStatement();

	        // Check if the phone number or email is already in use
	        String checkQuery = "SELECT * FROM reservations";
	         resultSet = stmt.executeQuery(checkQuery);
	        
	        while (resultSet.next()) {
	            
	               int reservationsid=resultSet.getInt(1);
	               String fulllname=resultSet.getString(2);
	               String phonenum =resultSet.getString(3);
	               String email=resultSet.getString(4);
	               String datetime=resultSet.getString(5);
	               String eventtype=resultSet.getString(6);
	               String packagetype=resultSet.getString(7);
	               String specialrqst=resultSet.getString(8);
	               
	               getInformation info=new getInformation(reservationsid,fulllname,phonenum,email,datetime,eventtype,packagetype,specialrqst);
	               Alldetails.add(info);
	           
	               
	            
	        
	        }
	        

	        }catch (Exception e) {
	        e.printStackTrace();
	        
	    }
		
		
		return Alldetails;
	}

	@Override

	public String updateEvent(String cusId, String cusName, String cusPnumber, String cusEmail, String datetime) {
	    String message = null;

	    try {
	        con = DBconnectionT.getconnection();
	        stmt = con.createStatement();

	        String checkQuery = "SELECT * FROM reservations WHERE phonenum = '" + cusPnumber + "' OR email = '" + cusEmail + "'";
	        resultSet = stmt.executeQuery(checkQuery);

	        if (resultSet.next()) {
	            if (resultSet.getString("phonenum").equals(cusPnumber) || resultSet.getString("email").equals(cusEmail)) {
	                String checkQuery1 = "SELECT datetime FROM reservations WHERE reservationsid != '" + cusId + "' AND datetime = '" + datetime + "'";
	                resultSet = stmt.executeQuery(checkQuery1);

	                if (resultSet.next()) {
	                    message = "Already Reserved Please Enter Another Date.";
	                } else {
	                    String UpdateQuery1 = "Update reservations set fulllname = '" + cusName + "', datetime = '" + datetime + "' where reservationsid = '" + cusId + "'";
	                    int rs = stmt.executeUpdate(UpdateQuery1);

	                    if (rs > 0) {
	                        message = "Event inserted successfully.";
	                    } else {
	                        message = "Event insertion failed.";
	                    }

	                    // Check and update datetime in other tables if they exist
	                    String[] tableNames = {"catering_info", "decoration_info", "hotel_infrom", "photography_info"};
	                    for (String tableName : tableNames) {
	                        
	                            String checkQuery2 = "SELECT datetime FROM " + tableName + " WHERE reserveId = '" + cusId + "'";
	                            resultSet = stmt.executeQuery(checkQuery2);

	                            if (resultSet.next()) {
	                                String updateQuery2 = "UPDATE " + tableName + " SET datetime = '" + datetime + "' WHERE reserveId = '" + cusId + "'";
	                                int rs2 = stmt.executeUpdate(updateQuery2);
	                                if (rs2 <= 0) {
	                                    break;
	                                }
	                            }
	                        
	                    }
	                }
	            }
	        } else {
	            // Check if the phone number or email is already in use
	            String checkQuery1 = "SELECT datetime FROM reservations WHERE reservationsid != '" + cusId + "' AND datetime = '" + datetime + "'";
	            resultSet = stmt.executeQuery(checkQuery1);

	            if (resultSet.next()) {
	                message = "Already Reserved Please Enter Another Date.";
	            } else {
	                String UpdateQuery = "Update reservations set fulllname = '" + cusName + "', phonenum = '" + cusPnumber + "', email = '" + cusEmail + "', datetime = '" + datetime + "' where reservationsid = '" + cusId + "'";
	                int rs = stmt.executeUpdate(UpdateQuery);

	                if (rs > 0) {
	                    message = "Event inserted successfully.";
	                } else {
	                    message = "Event insertion failed.";
	                }

	                // Check and update datetime in other tables if they exist
	                String[] tableNames = {"catering_info", "decoration_info", "hotel_infrom", "photography_info"};
	                for (String tableName : tableNames) {
	                   
	                        String checkQuery2 = "SELECT datetime FROM " + tableName + " WHERE reserveId = '" + cusId + "'";
	                        resultSet = stmt.executeQuery(checkQuery2);

	                        if (resultSet.next()) {
	                            String updateQuery2 = "UPDATE " + tableName + " SET datetime = '" + datetime + "' WHERE reserveId = '" + cusId + "'";
	                            int rs2 = stmt.executeUpdate(updateQuery2);
	                            if (rs2 <= 0) {
	                                break;
	                            }
	                        }
	                    
	                }
	            }
	        }

	        stmt.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	        message = "An error occurred: " + e.getMessage();
	    }

	    return message;
	}

	






	@Override
	public boolean deletereservation(String cusId) {
		boolean isSuccess=false;
		try {
			con = DBconnectionT.getconnection();
	         stmt = con.createStatement();
			
	         String delete= "delete from reservations where reservationsid='"+cusId+"' ";
	         rs=stmt.executeUpdate(delete);
	         
	         if(rs>0) {
	        	 isSuccess=true;
	         }else {
	        	 isSuccess=false;
	         }
			
			
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return isSuccess;
	}





	
	
	





	





	

}
