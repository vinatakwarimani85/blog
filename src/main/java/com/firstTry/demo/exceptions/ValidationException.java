package com.firstTry.demo.exceptions;

public class ValidationException extends RuntimeException {
	
	String fieldName;

	public ValidationException(String fieldName) {
		
		super(String.format("Please Enter the valid %s",fieldName));
		System.out.println("hi vinayak");
		this.fieldName = fieldName;
	}
	

}
