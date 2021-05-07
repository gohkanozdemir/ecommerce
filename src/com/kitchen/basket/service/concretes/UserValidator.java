package com.kitchen.basket.service.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kitchen.basket.core.crosscuttingconcerns.validation.ValidationFailure;
import com.kitchen.basket.core.crosscuttingconcerns.validation.ValidationResult;
import com.kitchen.basket.model.User;
import com.kitchen.basket.service.abstracts.UserValidatorService;

public class UserValidator implements UserValidatorService {
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern
			.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,40}$";
	// ^ # start-of-string
	// (?=.*[0-9]) # a digit must occur at least once
	// (?=.*[a-z]) # a lower case letter must occur at least once
	// (?=.*[A-Z]) # an upper case letter must occur at least once
	// (?=.*[@#$%^&+=]) # a special character must occur at least once
	// (?=\S+$) # no whitespace allowed in the entire string
	// .{6,40} # anything, at least six max 40
	// $ # end-of-string
	private List<ValidationFailure> failures;
	private ValidationResult result;

	/**
	 * @param failure
	 * @param result
	 */
	public UserValidator() {
		this.failures = new ArrayList<ValidationFailure>();
		result = new ValidationResult();
	}

	@Override
	public ValidationResult validate(User user) {
		validatePassword(user.getPassword(),6);
		validateEmail(user.getEmail());
		validateFieldLength(user.getFirstName(),2);
		validateFieldLength(user.getLastName(),2);
		this.result.setErrors(failures);
		return this.result;
	}

	private boolean validatePassword(String password, int minLength) {
		if (password.length() < minLength) {
			String message = "Password en az " + minLength + " karakter olmalidir.";
			System.out.println(message);
			this.failures.add(new ValidationFailure("password", message));
			return false;
		}
		boolean result = Pattern.matches(PASSWORD_PATTERN, password);
		if (!result) {
			String message = "En az bir kucuk harf, en az bir buyuk harf, en az 1 rakam ve [@#$%^&+=] ozel karekterlerden olusmali.";
			System.out.println(message);
			this.failures.add(new ValidationFailure("password", message));
			return false;
		}
		return result;
	}

	private boolean validateEmail(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		if (!matcher.find()) {
			String message = "gecersiz bir e-posta";
			System.out.println(message);
			this.failures.add(new ValidationFailure("email", message));
			return false;
		}
		return true;
	}

	private boolean validateFieldLength(String field, int minLength) {
		boolean result = (field.length() >= minLength) ? true : false;
		if (!result) {
			String message = "Girilen deger en az " + minLength + " karakter olamli";
			System.out.println(message);
			this.failures.add(new ValidationFailure("field", message));
		}
		return result;
	}

}
