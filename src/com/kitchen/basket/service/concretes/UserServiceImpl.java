package com.kitchen.basket.service.concretes;

import java.util.List;

import com.kitchen.basket.dao.abstracts.UserDao;
import com.kitchen.basket.model.User;
import com.kitchen.basket.service.abstracts.EmailService;
import com.kitchen.basket.service.abstracts.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	private EmailService emailService;

	/**
	 * @param userDao
	 */
	// TODO DI yapilacak Spring ile @Autowired
	public UserServiceImpl(UserDao userDao, EmailService emailService) {
		this.userDao = userDao;
		this.emailService = emailService;
	}

	@Override
	public void add(User user) {
		this.userDao.add(user);		
	}

	@Override
	public void dogrula(int id, String kod) {
		User userToUpdate = this.userDao.get(id);
		if(this.emailService.dogrula(kod)) {
			System.out.println("dogrulama basarili. Hesabiniza gidebilirsiniz");
			userToUpdate.setStatus(true);
			this.userDao.update(userToUpdate);
		}else {
			System.out.println("dogrulama basarisiz. Tekrar konrol ediniz");
			this.emailService.sendInfo("dogrulama basarisiz. Tekrar konrol ediniz",(userToUpdate.getEmail()));
		}
			
	}
	@Override
	public void update(User user) {
		this.userDao.update(user);
		
	}

	@Override
	public void delete(int userId) {
		this.userDao.delete(userId);		
	}

	@Override
	public User get(int id) {
		return this.userDao.get(id);
	}

	@Override
	public List<User> getAll() {
		return this.userDao.getAll();
	}

	@Override
	public User getByEmail(String email) {
		return this.userDao.getByEmail(email);
	}
}
