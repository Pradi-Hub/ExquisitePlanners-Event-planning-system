package com.admin;

import java.util.List;

import com.user.User;

public interface PackageInterface {

	public boolean addPackages(PackageDetails p);
	
	public List<PackageDetails> getPackages();
	
	public PackageDetails getPackageID(int id);
	
	public boolean updatePackages(PackageDetails p);
	
	public boolean deletePackages(int id);
	
	public List<PackageDetails> displayPackages();
	
	public List<User> getUsers();
}
