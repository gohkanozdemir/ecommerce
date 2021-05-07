package com.kitchen.basket.core.crosscuttingconcerns.validation;

public class ValidationFailure {
	private String propertyName;
	private String errorMessage;
	
	public ValidationFailure() {
		
	}

	/**
	 * @param propertyName
	 * @param errorMessage
	 */
	public ValidationFailure(String propertyName, String errorMessage) {
		this.propertyName = propertyName;
		this.errorMessage = errorMessage;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
