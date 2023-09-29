package com.ust.foodorderingapp.exception;

public class ItemNotFoundException extends RuntimeException {
	public ItemNotFoundException (String message) {
		super(message);
	}

}
