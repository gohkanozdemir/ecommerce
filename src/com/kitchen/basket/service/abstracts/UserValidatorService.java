package com.kitchen.basket.service.abstracts;

import java.util.List;

import com.kitchen.basket.core.crosscuttingconcerns.validation.ValidationResult;
import com.kitchen.basket.model.User;

public interface UserValidatorService {
	ValidationResult validate(User user);
}
