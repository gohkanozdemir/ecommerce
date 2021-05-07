package com.kitchen.basket.core.crosscuttingconcerns.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
	private List<ValidationFailure> errors;
	
	public ValidationResult() {
		this.errors = new ArrayList<ValidationFailure>();
	}

	/**
	 * @param errors
	 */
	public ValidationResult(List<ValidationFailure> errors) {
		this.errors = errors;
	}

	public boolean isValid() {
		return (errors.size()== 0) ? true : false ;
	}
	public List<ValidationFailure> getErrors() {
		return errors;
	}

	public void setErrors(List<ValidationFailure> errors) {
		this.errors = errors;
	}
	
	
}
