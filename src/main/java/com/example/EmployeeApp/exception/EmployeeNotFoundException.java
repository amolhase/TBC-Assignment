package com.example.EmployeeApp.exception;

public class EmployeeNotFoundException extends RuntimeException{
	
	 public EmployeeNotFoundException(Integer id) {
	        super("Employee not found with ID: " + id);
	    }

}
