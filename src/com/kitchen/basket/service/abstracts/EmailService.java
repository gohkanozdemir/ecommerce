package com.kitchen.basket.service.abstracts;


public interface EmailService {
	void send(String to);
	void sendInfo(String message,String to);
	boolean dogrula(String dogrulamaKodu);
}
