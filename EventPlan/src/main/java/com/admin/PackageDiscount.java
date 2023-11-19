package com.admin;

public class PackageDiscount extends PackageDetails {
	// variable declare
	private double discount;
	// Default constructor
	public PackageDiscount() {
		super();
	}
	// Parameterized constructor to initialize package details
	public PackageDiscount(String packageName, String venue, String packagePrice, String foodPerPersonPrice,
			String foodDescription, String decorationPackage, String decorationDescription, String entertainment,
			String photographers, String status, String image, double discount) {
		super(packageName, venue, packagePrice, foodPerPersonPrice, foodDescription, decorationPackage, decorationDescription,
				entertainment, photographers, status, image);
		this.discount = discount;
	}
	// getters
	public double getDiscount() {
		return discount;
	}
	// setters
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public void discount(double discount) {
		double packagePrice = 0;
		
		if(packagePrice > 100000) {
			discount = packagePrice * 20/100;
		}
	}
}
