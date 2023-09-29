package com.ust.springapp;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
	
	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		Laptop laptop =context.getBean(Laptop.class);//to call obj from ioc container
		Scanner scan =context.getBean(Scanner.class);
//		System.out.println("enter your name:");
//		scan.nextLine();
		laptop.browseInternet();
	}

	

}
