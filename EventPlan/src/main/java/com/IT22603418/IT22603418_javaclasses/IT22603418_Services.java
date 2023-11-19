package com.IT22603418.IT22603418_javaclasses;

public class IT22603418_Services extends IT22603418_ReservationDetails{
	private int Sid;
	private String DJ_Music;
	private String Games_Activities;
	private String PhotoBooth;
	private String Photographer;
	private String FloralDeco;
	private String CenterpiecesDeco;
	private String BalloonDeco;
	
	//constructor
	public IT22603418_Services(int sid, int resid, String dJ_Music, String games_Activities, String photoBooth,
			String Photographer, String floralDeco, String centerpiecesDeco, String balloonDeco) {
		super(resid, "", "", "", null, null, "", "", 0, "", "");
		Sid = sid;
		DJ_Music = dJ_Music;
		Games_Activities = games_Activities;
		PhotoBooth = photoBooth;
		this.Photographer = Photographer;
		FloralDeco = floralDeco;
		CenterpiecesDeco = centerpiecesDeco;
		BalloonDeco = balloonDeco;
	}
	//getters
	public int getSid() {
		return Sid;
	}

	public String getDJ_Music() {
		return DJ_Music;
	}

	public String getGames_Activities() {
		return Games_Activities;
	}

	public String getPhotoBooth() {
		return PhotoBooth;
	}

	public String getPhotographer() {
		return Photographer;
	}

	public String getFloralDeco() {
		return FloralDeco;
	}

	public String getCenterpiecesDeco() {
		return CenterpiecesDeco;
	}

	public String getBalloonDeco() {
		return BalloonDeco;
	}
	
}
