package com.kitchen.basket.googleauth;

public class GoogleAuthService {
	public boolean register(int id, String email, String password, String firstName, String lastName) {
		 System.out.println("Google service ile kayit alindi :" + email);
		 return true;
	}

	public boolean login(String email, String password) {
		 System.out.println("Google service ile dogrulama basarili. Sisteme giris yapildi.");
		 return true;
	}
}
