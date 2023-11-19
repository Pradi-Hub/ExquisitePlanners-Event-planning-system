package com.admin;

//Class representing package details
public class PackageDetails {
	// Declaring private fields for package details
	private int packageID;
	private String packageName;
	private String venue;
	private String PackagePrice;
	private String foodPerPersonPrice;
	private String foodDescription;
	private String decorationPackage;
	private String decorationDescription;
	private String entertainment;
	private String photographers;
	private String status;
	private String image;
	// Default constructor
	public PackageDetails() {
		super();
	}
	// Parameterized constructor to initialize package details
	public PackageDetails(String packageName, String venue, String packagePrice,
			String foodPerPersonPrice, String foodDescription, String decorationPackage, String decorationDescription,
			String entertainment, String photographers, String status, String image) {
		super();
		this.packageName = packageName;
		this.venue = venue;
		this.PackagePrice = packagePrice;
		this.foodPerPersonPrice = foodPerPersonPrice;
		this.foodDescription = foodDescription;
		this.decorationPackage = decorationPackage;
		this.decorationDescription = decorationDescription;
		this.entertainment = entertainment;
		this.photographers = photographers;
		this.status = status;
		this.image = image;
	}
	// Getters for package details
	public int getPackageID() {
		return packageID;
	}

	public String getPackageName() {
		return packageName;
	}

	public String getVenue() {
		return venue;
	}

	public String getPackagePrice() {
		return PackagePrice;
	}

	public String getFoodPerPersonPrice() {
		return foodPerPersonPrice;
	}

	public String getFoodDescription() {
		return foodDescription;
	}

	public String getDecorationPackage() {
		return decorationPackage;
	}

	public String getDecorationDescription() {
		return decorationDescription;
	}

	public String getEntertainment() {
		return entertainment;
	}

	public String getPhotographers() {
		return photographers;
	}
	
	public String getStatus() {
		return status;
	}

	public String getImage() {
		return image;
	}
	// Setters for package details
	public void setPackageID(int packageID) {
		this.packageID = packageID;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public void setPackagePrice(String packagePrice) {
		PackagePrice = packagePrice;
	}

	public void setFoodPerPersonPrice(String foodPerPersonPrice) {
		this.foodPerPersonPrice = foodPerPersonPrice;
	}

	public void setFoodDescription(String foodDescription) {
		this.foodDescription = foodDescription;
	}

	public void setDecorationPackage(String decorationPackage) {
		this.decorationPackage = decorationPackage;
	}

	public void setDecorationDescription(String decorationDescription) {
		this.decorationDescription = decorationDescription;
	}

	public void setEntertainment(String entertainment) {
		this.entertainment = entertainment;
	}

	public void setPhotographers(String photographers) {
		this.photographers = photographers;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public void setImage(String image) {
		this.image = image;
	}
	// Overriding toString() method
	@Override
	public String toString() {
		return "PackageDetails [packageID=" + packageID + ", packageName=" + packageName + ", venue=" + venue
				+ ", PackagePrice=" + PackagePrice + ", foodPerPersonPrice=" + foodPerPersonPrice + ", foodDescription="
				+ foodDescription + ", decorationPackage=" + decorationPackage + ", decorationDescription="
				+ decorationDescription + ", entertainment=" + entertainment + ", photographers=" + photographers
				+ ", status=" + status + ", image=" + image + "]";
	}

}
