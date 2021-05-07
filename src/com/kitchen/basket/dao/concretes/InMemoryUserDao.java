package com.kitchen.basket.dao.concretes;

import java.util.ArrayList;
import java.util.List;

import com.kitchen.basket.dao.abstracts.UserDao;
import com.kitchen.basket.model.User;

public class InMemoryUserDao implements UserDao{

	private List<User> userList = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		user.setStatus(false);    // dogrulama sonrasi update gorecek
		this.userList.add(user);
		System.out.println(user.getFirstName() + " sisteme kaydedildi.");
	}

	@Override
	public void update(User user) {
		User userToUpdate = this.get(user.getId());
		
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		System.out.println(user.getFirstName() + " guncellendi.");
	}

	@Override
	public void delete(int userId) {
		User userToDelete = this.get(userId);
		this.userList.remove(userToDelete);
		System.out.println(userToDelete.getFirstName() + " sistemden silindi.");		
	}

	@Override
	public User get(int id) {
		for (User user : userList) {
			if(user.getId() == id)
				return user;
		}
		return null;
	}

	@Override
	public User getByEmail(String email) {
		for (User user : userList) {
			if(user.getEmail() == email)
				return user;
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return userList;
	}

}
