package com.user;

public class User {
	// Properties of the User class
	private int id;
	private String name;
	private String username;
	private String email;
	private String phone;
	private String nic;
	private String address;
	private String password;
	// Default constructor
	public User() {
		super();
		
	}
	// Parameterized constructor
	public User(int id, String name, String username, String email, String phone, String nic, String address,
			String password) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.nic = nic;
		this.address = address;
		this.password = password;
	}
	// Setter methods for all properties
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	// Getter methods for all properties
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}
	
	public String getNic() {
		return nic;
	}

	public String getAddress() {
		return address;
	}

	public String getPassword() {
		return password;
	}
}