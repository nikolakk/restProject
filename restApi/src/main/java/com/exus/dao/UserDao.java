package com.exus.dao;

import com.exus.entity.User;

public interface UserDao {

	void saveUser(User user);

	User getUserByEmail(String email);

	User getUserByIpAddress(String ipAddress);

	boolean checkIfUserExists(User user);
}
