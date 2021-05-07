package com.kitchen.basket.dao.concretes;

import java.util.ArrayList;
import java.util.List;

import com.kitchen.basket.dao.abstracts.UserDao;
import com.kitchen.basket.model.User;

// Hibernate eklemesi yapildigi zaman guncellenecek
public class UserDaoIpml implements UserDao{
	
	@Override
	public void add(User user) {
		System.out.println(user.getFirstName() + " veritabanina kaydedildi.");
		
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName() + " guncellendi.");
		
	}

	@Override
	public void delete(int userId) {
		System.out.println(userId+ " nolu kayit silindi.");
		
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByEmail(String email) {
		return null;
	}

}
