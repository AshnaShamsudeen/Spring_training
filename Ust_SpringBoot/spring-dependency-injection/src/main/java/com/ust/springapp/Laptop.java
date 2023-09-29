package com.ust.springapp;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class Laptop {
	
	public Laptop() {
		System.out.println("Laptop Connected");
	}
	//@Autowired  //field injection
		Scanner scan;
		 
	@Value("${brand-name}")
	private String brand;
	@Value("${model-type}")
	private String model;
	@Value("${ram-gb}")
	private int ram;
		
	//Dependency Injection
	//@Autowired
	//@Qualifier("connection1")
		private InternetConnection connection;
		@Autowired //constructor injection
	public Laptop(Scanner scan, InternetConnection connection) {
		this.scan = scan;
		
		this.connection = connection;
	}
	
//	public Scanner getScan() {
//			return scan;
//		}
//
//		public void setScan(Scanner scan) {
//			System.out.println("injected by setter");
//			this.scan = scan;
//		}
//
//		public InternetConnection getConnection() {
//			return connection;
//		}
//		@Autowired
//		public void setConnection(InternetConnection connection) {
//			System.out.println("injected by constructor");
//			this.connection = connection;
			
	//	}

	public void browseInternet() {
//		System.out.println("enter url: ");
//		scan.nextLine();
		System.out.println("Trying to connect..");
		connection.browse();
		System.out.println("brand-name:" +brand);
		System.out.println("model-type:"+model);
		System.out.println("ram:"+ram);
		
		
	}

}
