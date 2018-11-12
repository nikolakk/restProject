package com.exus.service;

import com.exus.entity.User;

public interface UserService {

	boolean saveUser(User apiRequest);

	User getUserByEmail(String email);

	User getUserByIpAddress(String ipAddress);
}
