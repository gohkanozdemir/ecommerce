package com.kitchen.basket.core.adapters;

public interface AuthService {
	boolean register(int id, String email,String password,String firstName,String lastName);
	boolean login(String email, String password);
}
