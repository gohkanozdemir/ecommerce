package com.kitchen.basket.service.concretes;

import com.kitchen.basket.service.abstracts.EmailService;

public class EmailServiceImpl implements EmailService{
	private static final String SENDER_MAIL="info@mutfaksepeti.com";

	@Override
	public void send(String to) {
		System.out.println("Dogrualma e-postasi  : "  + to + " adresine gönderildi.");
	}

	@Override
	public boolean dogrula(String dogrulamaKodu) {
		if(dogrulamaKodu == "123456") {
			return true;
		}
		System.out.println("Dogrualma kodu yanlis.");
		return false;
	}

	@Override
	public void sendInfo(String message, String to) {
		System.out.println("Bilgilendirme maili  : "  + to + " adresine gönderildi.");
	}

}
