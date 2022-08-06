package com.caresoft.clinicapp;

public class User {
    protected Integer id;
    protected int pin;
    
    // TO DO: Getters and setters
	// Implement a constructor that takes an ID
    public User(Integer id) {
    	this.id = id;
    }
    
    public Integer getID() {
    	return id;
    }
    public int getPin() {
    	return pin;
    }
    public void setID(Integer id) {
    	this.id = id;
    }
    public void setPin(int pin) {
    	this.pin = pin;
    }
}

