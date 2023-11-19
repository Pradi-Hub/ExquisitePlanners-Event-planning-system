package com.IT22603418.IT22603418_javaclasses;

import java.util.List;

public interface IT22603418_Reservation {
	public boolean insertReservation(String fullname, String phone, String email, String date, String time,
            String location, String Package, String guestcount, String eventType, String d1, String d2, String d3, String photographers, String e1, String e2, String e3,String splrequest);
	public boolean updateReservation(int Resid, String fullname, String phone, String email, String date, String time,
            String location, String Package, String guestcount, String eventType, String splrequest);
	public boolean updateServices(int Resid, String d1, String d2, String d3, String photographers, String e1, String e2, String e3);
	public boolean deleteReservation(int Resid);
	public int getResid(String email);
	public List<IT22603418_ReservationDetails> validate(int Resid);
	public List<IT22603418_Services> iT22603418_Services(int Resid);
}
