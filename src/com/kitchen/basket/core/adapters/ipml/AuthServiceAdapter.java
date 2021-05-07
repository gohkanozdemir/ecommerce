package com.kitchen.basket.core.adapters.ipml;

import com.kitchen.basket.core.adapters.AuthService;
import com.kitchen.basket.googleauth.GoogleAuthService;

public class AuthServiceAdapter implements AuthService{

	@Override
	public boolean register(int id, String email, String password, String firstName, String lastName) {
		GoogleAuthService service = new GoogleAuthService();
		boolean result = service.register(id, email, password, firstName, lastName);
		if (result) {
			System.out.println("Google register yapildi.");
		} else {
			System.out.println("Google register islemi sirasinda hata alindi.");
		}
		return result;
	}

	@Override
	public boolean login(String email, String password) {
		GoogleAuthService service = new GoogleAuthService();
		boolean result = service.login(email, password);
		if (result) {
			System.out.println("Google ile giris yapildi");
		} else {
			System.out.println("Google giris islemi sirasinda hata alindi.");
		}
		return result;
	}

}
