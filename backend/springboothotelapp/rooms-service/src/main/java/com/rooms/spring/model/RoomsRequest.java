package com.rooms.spring.model;

public class RoomsRequest {
	private String id;
	private String name;
	private String imageurls[];
	private long rentperday;
	private String type;
	private int maxcount;
	private long phonenumber;
	private String currentbookings[];
	private String description;
	
	
	public RoomsRequest() {
		super();
	}


	public RoomsRequest(String name, String[] imageurls, long rentperday, String type, int maxcount, long phonenumber,
			String[] currentbookings, String description) {
		super();
		this.name = name;
		this.imageurls = imageurls;
		this.rentperday = rentperday;
		this.type = type;
		this.maxcount = maxcount;
		this.phonenumber = phonenumber;
		this.currentbookings = currentbookings;
		this.description = description;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String[] getImageurls() {
		return imageurls;
	}


	public void setImageurls(String[] imageurls) {
		this.imageurls = imageurls;
	}


	public long getRentperday() {
		return rentperday;
	}


	public void setRentperday(long rentperday) {
		this.rentperday = rentperday;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getMaxcount() {
		return maxcount;
	}


	public void setMaxcount(int maxcount) {
		this.maxcount = maxcount;
	}


	public long getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}


	public String[] getCurrentbookings() {
		return currentbookings;
	}


	public void setCurrentbookings(String[] currentbookings) {
		this.currentbookings = currentbookings;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
