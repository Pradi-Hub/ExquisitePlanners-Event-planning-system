package s_supplier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class s_supplierDBModel implements s_supplierDBModelInterface {

	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static boolean isSuccess;
	
	//order details validation method
	public static List<s_order> validate(String orderId) {  

		ArrayList<s_order> order = new ArrayList<>(); // storing the order details to the arraylist

		// validate
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from supplier_orders where orderId = '" + orderId + "'";
			// to run sql
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				int supplierId = rs.getInt(2);
				String Id = rs.getString(1);
				String orders = rs.getString(3);

				s_order o1 = new s_order(orders, orderId, supplierId);
				order.add(o1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return order;
	}
	
	//All quotes view method
	public static List<s_quote> ViewAllQuotes(String qid) {
		ArrayList<s_quote> s_quoteLists = new ArrayList<>(); // Initialize the list to store quotes

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from supplier_quotation";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				int qty = rs.getInt(3);
				double uprice = rs.getDouble(4);
				double iprice = rs.getDouble(5);

				s_quote q1 = new s_quote(id, name, qty, uprice, iprice);
				s_quoteLists.add(q1);
			}
			
			
			 // Retrieve total from the 'total_table'
	        String sql2 = "SELECT total FROM supplier_total WHERE qNo = '"+qid+"'";
	        rs = stmt.executeQuery(sql2);
	       

	        if (rs.next()) {
	            double total = rs.getDouble(2);

	            // Create a separate s_quote for the total (if needed)
	            s_quoteTotal totalQuote = new s_quoteTotal(total);

	            // Add the total to the list (if needed)
	            s_quoteLists.add(totalQuote);
	        }

		} catch (Exception e) {
			e.printStackTrace();
		}

		return s_quoteLists;
	}
	
	//quotations insertion method
	public boolean insertQuoteList(List<s_quote> s_quoteList, String quote_no, double totalPrice) {
		boolean isSuccess = true; // Initialize to true

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			// Loop to construct and execute SQL statements
			for (s_quote squote : s_quoteList) {
				String sql = "Insert into supplier_quotation(quoteId, itemName, quantity, unitPrice, itemPrice) "
						+ " values ('" + quote_no + "', '" + squote.getItemName() + "', '" + squote.getQuantity()
						+ "', '" + squote.getUnitPrice() + "', '" + squote.getItemPrice() + "')";

				int rs = stmt.executeUpdate(sql);

				// Check if the current iteration fails and set isSuccess accordingly
				if (rs <= 0) {
					isSuccess = false;
				}
			}

			// After the loop, insert the total price
			String sql1 = "Insert into supplier_total values ('" + quote_no + "', '" + totalPrice + "')";
			int rs1 = stmt.executeUpdate(sql1);

			// Check if the total price insertion fails and set isSuccess accordingly
			if (rs1 <= 0) {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			isSuccess = false; // Set to false in case of an exception
		} finally {
		}
		return isSuccess;
	}
	
	//quotations deletion method
	public boolean deleteQuote(String qid) {

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "Delete from supplier_quotation where quoteId = '" + qid + "'";
			String sql1 = "Delete from supplier_total where qNo = '" + qid + "'";

			int rs = stmt.executeUpdate(sql);
			int rs1 = stmt.executeUpdate(sql1);

			if (rs > 0 && rs1 > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}
	
	//quotation edit form view method
	public static List<s_quote> viewEditform(String qid1) {
		ArrayList<s_quote> viewquote = new ArrayList<>(); // Initialize the list to store quotes

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from supplier_quotation where quoteId = '" + qid1 + "'";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				int qty = rs.getInt(3);
				double uprice = rs.getDouble(4);
				double iprice = rs.getDouble(5);

				s_quote q1 = new s_quote(id, name, qty, uprice, iprice);
				viewquote.add(q1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return viewquote;
	}
	
	//quotation update method
	public boolean updateQuote(List<s_quote> s_quoteList, String qid, double totalPrice) {

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			int rs = 0;
			int rsTotal = 0;
			for (s_quote squote : s_quoteList) {

				String sql = " UPDATE supplier_quotation SET quantity = " + squote.getQuantity() + " , unitPrice = "
						+ squote.getUnitPrice() + " , itemPrice = " + squote.getItemPrice() + " WHERE quoteId = '"
						+ squote.getQuoteId() + "' AND itemName = '" + squote.getItemName() + "'";

				rs = stmt.executeUpdate(sql);

				rsTotal += rs;

			}
		

			if (rsTotal == s_quoteList.size()) { // Check if all statements were successful
				isSuccess = true;
			} else {
				isSuccess = false;
			}

			if (rsTotal > 1) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

			String sql1 = "update supplier_total set total = "+totalPrice+" where qNo = '"+qid+"'";
			int rs1 = stmt.executeUpdate(sql1);
			if(rs1 <0) {
			isSuccess = false;
			 }else {
			 isSuccess = true;
			 }
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

}
