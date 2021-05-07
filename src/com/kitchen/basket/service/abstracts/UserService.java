package com.kitchen.basket.service.abstracts;

import java.util.List;

import com.kitchen.basket.model.User;

public interface UserService {

	void add(User user);

	void update(User user);

	void delete(int userId);

	void dogrula(int id, String kod);

	User get(int id);

	User getByEmail(String email);

	List<User> getAll();
}
