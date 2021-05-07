package com.kitchen.basket;

import com.kitchen.basket.core.adapters.ipml.AuthServiceAdapter;
import com.kitchen.basket.dao.abstracts.UserDao;
import com.kitchen.basket.dao.concretes.InMemoryUserDao;
import com.kitchen.basket.service.abstracts.EmailService;
import com.kitchen.basket.service.abstracts.UserService;
import com.kitchen.basket.service.concretes.AuthServiceImpl;
import com.kitchen.basket.service.concretes.EmailServiceImpl;
import com.kitchen.basket.service.concretes.UserServiceImpl;

public class AppMain {

	public static void main(String[] args) {
		UserDao userDao = new InMemoryUserDao();
		EmailService emailService = new EmailServiceImpl();
		UserService userService = new UserServiceImpl(userDao, emailService);
		AuthServiceImpl auth = new AuthServiceImpl(userService, emailService, new AuthServiceAdapter());
		
		auth.register(1, "123dff@mail.com", "123456cA@", "Ahmet", "Yilmaz"); // basarili
		auth.register(2, "123dff@mail.com", "123456cA", "Ahmet", "Yilmaz"); // hatali sifre
		auth.register(3, "123dffmail.com", "123456cA@", "Ahmet", "Yilmaz"); // gecersiz e-posta
		auth.register(4, "123dff@mail.com", "6789cA@", "A", "Y"); // isim ve soyisim en az 2 karakter
		
		auth.login("123dff@mail.com", "123456cA@"); // Dogrulama oncesi hata alacaktir
		userService.dogrula(1, "12345"); // hatali dogrulama kodu
		userService.dogrula(1, "123456"); // dorulama basarili
		auth.login("123dff@mail.com", "123456cA"); // Dogrulama sonrasi hata sifre yanlis
		auth.login("123dff@mail.com", "123456cA@"); // Dogrulama sonrasi basarili
		auth.login("", ""); // basarisiz e-posta parola zorunlu
		
		auth.register(5, "123ggg@mail.com", "6789cA@", "Ahmet", "Yilmaz"); // basarili
		auth.login("123dff@mail.com", "123456cA@"); // Dogrulama sonrasi basarili
		auth.register(6, "123ggg@mail.com", "6789cA@", "Ahmet", "Yilmaz"); // basarisiz e-posta mevcut

	}

}
