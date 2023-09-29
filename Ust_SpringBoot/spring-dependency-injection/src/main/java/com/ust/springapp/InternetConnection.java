package com.ust.springapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InternetConnection {
	
	@Value("${connection-type}")//AUTOWIRED IS USED FOR REFERENCE OR OBJECTS 
	private String connectionType;
	
	 public String getConnectionType() {
		return connectionType;
	}
	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}
	public InternetConnection() {
		 System.out.println("Internet Connection object created");
		 
	 }
	public void browse() {
		System.out.println("Connection type="+connectionType);
		System.out.println("Browsing internet....");
	}

}
