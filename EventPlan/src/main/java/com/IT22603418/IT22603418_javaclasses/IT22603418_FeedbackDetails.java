package com.IT22603418.IT22603418_javaclasses;

public class IT22603418_FeedbackDetails {
	private int Fid;
	private String email;
	private int star;
	private String review;
	
	public IT22603418_FeedbackDetails(int Fid, String email, int star, String review) {
		this.Fid = Fid;
		this.email = email;
		this.star = star;
		this.review = review;
	}
	
	public int getFid() {
		return Fid;
	}

	public String getEmail() {
		return email;
	}

	public int getStar() {
		return star;
	}

	public String getReview() {
		return review;
	}

}
