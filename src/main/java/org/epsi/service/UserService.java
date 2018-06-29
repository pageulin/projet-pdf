package org.epsi.service;

import java.util.List;

import org.epsi.dao.IUserDao;
import org.epsi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Transactional(readOnly=true)
	public List<User> getUsers()
	{
		return userDao.getUsers();
	}
	
}
