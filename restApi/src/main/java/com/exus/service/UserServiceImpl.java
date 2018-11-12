package com.exus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exus.dao.UserDao;
import com.exus.entity.User;
@Service
public class UserServiceImpl implements UserService {
	
	 @Autowired
	    private UserDao userDao;

	    @Override
	    public synchronized boolean saveUser(User user) {
	    	if (userDao.checkIfUserExists(user)) {
	     	   return false;
	        } else {
	        	userDao.saveUser(user);
	     	   return true;
	        }
	    	
	    }

		

		@Override
		public User getUserByEmail(String email) {
			return userDao.getUserByEmail(email);
		}

		@Override
		public User getUserByIpAddress(String ipAddress) {
			return userDao.getUserByIpAddress(ipAddress);
		}
	
}
