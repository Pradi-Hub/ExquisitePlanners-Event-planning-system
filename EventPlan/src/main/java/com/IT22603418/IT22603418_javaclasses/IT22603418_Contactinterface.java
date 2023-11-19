package com.IT22603418.IT22603418_javaclasses;

import java.util.List;

public interface IT22603418_Contactinterface {
	public boolean contactUsInsert(String name, String email, String message);
	public boolean FeedbackInsert(String email, int star, String review);
	public boolean FeedbackUpdate(int Fid, String email, int star, String review);
	public boolean deleteFeedback(int Fid);
	public int getFid(String email);
	public List<IT22603418_FeedbackDetails> validateFeedback(int Fid);
	public List<IT22603418_FeedbackDetails> view();
}
