package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
//... imports class definition...
    
    // Inside class:
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    public AdminUser(Integer employeeID, String role) {
    	super(employeeID);
    	this.role = role;
    	securityIncidents = new ArrayList<String>();
    }
    public boolean assignPin(int pin) {
    	if (pin < 100000)
    		return false;
    	this.pin = pin;
    	return true;
    }
    public boolean accessAuthorized(Integer id) {
    	if (this.id == id) 
    		return true;
    	authIncident();
    	return false;
    }
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    // TO DO: Setters & Getters
    public ArrayList<String> reportSecurityIncidents() {
    	return securityIncidents;
    }
    public void setRole(String role) {
    	this.role = role;
    }
    public String getRole() {
    	return this.role;
    }
}
