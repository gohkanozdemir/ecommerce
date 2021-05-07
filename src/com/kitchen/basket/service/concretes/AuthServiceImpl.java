package com.kitchen.basket.service.concretes;

import com.kitchen.basket.core.adapters.AuthService;
import com.kitchen.basket.model.User;
import com.kitchen.basket.service.abstracts.EmailService;
import com.kitchen.basket.service.abstracts.UserService;
import com.kitchen.basket.service.abstracts.UserValidatorService;

public class AuthServiceImpl {
	private UserService userService;
	private EmailService emailService;
	private UserValidatorService userValidator;
	private AuthService adapter;

	public AuthServiceImpl(UserService userService, EmailService emailService, AuthService adapter) {
		this.userService = userService;
		this.emailService = emailService;
		this.adapter = adapter;
	}

	public void register(int id, String email, String password, String firstName, String lastName) {
		User userToRegister = new User(id, firstName, lastName, email, password, false);
		boolean required = checkFieldsRequired(email,password);
		if(!required) {
			System.out.println("email ve password bos olamaz");
			return;
		}
		this.userValidator = new UserValidator();	
		var resultValid = this.userValidator.validate(userToRegister);
		if (!resultValid.isValid()) {
			System.out.println("Validate isleminden gecemedi");
			return;
		}
		if (!checkIfUserExists(userToRegister.getEmail())) {
			System.out.println("Ayni email var.");
			return;
		}

		boolean result = this.adapter.register(userToRegister.getId(), userToRegister.getEmail(),
				userToRegister.getPassword(), userToRegister.getFirstName(), userToRegister.getLastName());
		if (!result)
			return;

		System.out.println("sisteme kaydiniz Google ile yapildi");
		this.userService.add(userToRegister);
		this.emailService.send(userToRegister.getEmail()); // dogrulama kodu yolla
	}

	public void login(String email, String password) {
		
		boolean required = checkFieldsRequired(email,password);
		if(!required) {
			System.out.println("email ve password bos olamaz");
			return;
		}
		User userToLogin = this.userService.getByEmail(email);
		if (!(checkUserStatus(userToLogin))) {
			System.out.println("dogrulama yapilmamis.");
			return;
		}
		if ((userToLogin.getPassword() != password)) {
			System.out.println("sifre hatali");
			return;
		}

		boolean result = this.adapter.login(email, password);
		if (!result) {
			this.emailService.sendInfo("sisteme giris yapilamadi. Email veya password hatali.", userToLogin.getEmail());
		}
	}

	private boolean checkIfUserExists(String email) {
		return this.userService.getByEmail(email) == null;
	}

	private boolean checkUserStatus(User user) {
		return user.getStatus();
	}
	
	private boolean checkFieldsRequired(String email,String password) {
		if(email.length()<=0 || password.length() <=0) {
			return false;
		}
		return true;
	}
}
