package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.user.User;

public class PackageInterfaceImplement implements PackageInterface {

	private Connection conn;

	public PackageInterfaceImplement(Connection conn) {
		super();
		this.conn = conn;
	}
	// Logic to add package details to the database
	@Override
	public boolean addPackages(PackageDetails p) {

		boolean f = false;

		try {
			String sql = "insert into packagedetails(packageName,venue,Packageprice,foodPerPersonPrice,foodDescription,decorationPackage,decorationDescription,entertainment,photographers,status,image) Values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getPackageName());
			ps.setString(2, p.getVenue());
			ps.setString(3, p.getPackagePrice());
			ps.setString(4, p.getFoodPerPersonPrice());
			ps.setString(5, p.getFoodDescription());
			ps.setString(6, p.getDecorationPackage());
			ps.setString(7, p.getDecorationDescription());
			ps.setString(8, p.getEntertainment());
			ps.setString(9, p.getPhotographers());
			ps.setString(10, p.getStatus());
			ps.setString(11, p.getImage());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	// Logic to retrieve all package details from the database
	@Override
	public List<PackageDetails> getPackages() {

		List<PackageDetails> list = new ArrayList<PackageDetails>();
		PackageDetails p = null;

		try {

			String sql = "select * from packagedetails";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				p = new PackageDetails();
				p.setPackageID(rs.getInt(1));
				p.setPackageName(rs.getString(2));
				p.setVenue(rs.getString(3));
				p.setPackagePrice(rs.getString(4));
				p.setFoodPerPersonPrice(rs.getString(5));
				p.setFoodDescription(rs.getString(6));
				p.setDecorationPackage(rs.getString(7));
				p.setDecorationDescription(rs.getString(8));
				p.setEntertainment(rs.getString(9));
				p.setPhotographers(rs.getString(10));
				p.setStatus(rs.getString(11));
				p.setImage(rs.getString(12));

				list.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	// Logic to retrieve package details by ID from the database
	@Override
	public PackageDetails getPackageID(int id) {

		PackageDetails p = null;

		try {
			String sql = "select * from packagedetails where packageID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				p = new PackageDetails();
				p.setPackageID(rs.getInt(1));
				p.setPackageName(rs.getString(2));
				p.setVenue(rs.getString(3));
				p.setPackagePrice(rs.getString(4));
				p.setFoodPerPersonPrice(rs.getString(5));
				p.setFoodDescription(rs.getString(6));
				p.setDecorationPackage(rs.getString(7));
				p.setDecorationDescription(rs.getString(8));
				p.setEntertainment(rs.getString(9));
				p.setPhotographers(rs.getString(10));
				p.setStatus(rs.getString(11));
				p.setImage(rs.getString(12));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}
	// Logic to update package details in the database
	@Override
	public boolean updatePackages(PackageDetails p) {

		boolean f = false;

		try {

			String sql = "update packagedetails set packageName = ?, venue = ?, Packageprice = ?, foodPerPersonPrice = ?, foodDescription = ?, decorationPackage = ?, decorationDescription = ?, entertainment = ?, photographers = ?, status = ? where packageID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, p.getPackageName());
			ps.setString(2, p.getVenue());
			ps.setString(3, p.getPackagePrice());
			ps.setString(4, p.getFoodPerPersonPrice());
			ps.setString(5, p.getFoodDescription());
			ps.setString(6, p.getDecorationPackage());
			ps.setString(7, p.getDecorationDescription());
			ps.setString(8, p.getEntertainment());
			ps.setString(9, p.getPhotographers());
			ps.setString(10, p.getStatus());
			ps.setInt(11, p.getPackageID());
			
			int i = ps.executeUpdate();
			
			if (i == 1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
	// Logic to delete package details from the database by ID
	@Override
	public boolean deletePackages(int id) {
		boolean f = false;
		
		try {
			
			String sql = "delete from packagedetails where packageID = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			
			if (i == 1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	// Logic to display active packages from the database
	@Override
	public List<PackageDetails> displayPackages() {
		
		List<PackageDetails> list = new ArrayList<PackageDetails>();
		PackageDetails p = null;
		
		try {
			String sql = "select * from packagedetails where status = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "active");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				p = new PackageDetails();
				p.setPackageID(rs.getInt(1));
				p.setPackageName(rs.getString(2));
				p.setVenue(rs.getString(3));
				p.setPackagePrice(rs.getString(4));
				p.setFoodPerPersonPrice(rs.getString(5));
				p.setFoodDescription(rs.getString(6));
				p.setDecorationPackage(rs.getString(7));
				p.setDecorationDescription(rs.getString(8));
				p.setEntertainment(rs.getString(9));
				p.setPhotographers(rs.getString(10));
				p.setStatus(rs.getString(11));
				p.setImage(rs.getString(12));
				
				list.add(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	// Logic to retrieve all users from the database
	@Override
	public List<User> getUsers() {
		
		List<User> list = new ArrayList<User>();
		User u = null;
		
		try {

			String sql = "select * from user";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setUsername(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setPhone(rs.getString(5));
				u.setNic(rs.getString(6));
				u.setAddress(rs.getString(7));

				list.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
