package com.friedman.ninjagoldgame;

import java.util.Date;

public class Activity {
	private String location;
	private int gold;
	private Date date;

	public Activity(String location, int gold, Date date) {
		this.location = location;
		this.gold = gold;
		this.date = date;
	}
	
	public String getLocation() {
		return this.location;
	}
	public int getGold() {
		return this.gold;
	}
	public Date getDate() {
		return this.date;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
