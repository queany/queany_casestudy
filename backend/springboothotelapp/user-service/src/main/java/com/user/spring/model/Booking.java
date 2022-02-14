package com.user.spring.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="bookings")
public class Booking {

	@Id
	private String id;
	private String transactionid;
	private String username;
	private String roomid;
	private String fromdate;
	private String todate;
	private int totaldays;
	private float totalamount;
	private String status;
	
	
	
	public Booking() {
		
	}
	public Booking(String transactionid, String username, String roomid, String fromdate, String todate, int totaldays,
			float totalamount,String status) {
		super();
		this.username = username;
		this.roomid = roomid;
		this.fromdate = fromdate;
		this.todate = todate;
		this.totaldays = totaldays;
		this.totalamount = totalamount;
		this.status=status;
		this.transactionid=transactionid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public int getTotaldays() {
		return totaldays;
	}
	public void setTotaldays(int totaldays) {
		this.totaldays = totaldays;
	}
	public float getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(float totalamount) {
		this.totalamount = totalamount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	
	
	
	
}
