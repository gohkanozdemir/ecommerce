package com.kitchen.basket.dao.abstracts;

import java.util.List;

import com.kitchen.basket.model.User;

public interface UserDao {
	
	void add(User user);

	void update(User user);

	void delete(int userId);

	User get(int id);

	User getByEmail(String email);

	List<User> getAll();
}
