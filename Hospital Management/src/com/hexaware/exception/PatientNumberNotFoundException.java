package com.hexaware.exception;

public class PatientNumberNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientNumberNotFoundException() {
		System.out.println("Patient Id not Found :(");
	}

	
}
