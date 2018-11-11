package exus.restapi.rest_api_user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exus.restapi.rest_api_user.domain.User;
import exus.restapi.rest_api_user.repository.UserDao;
import exus.restapi.rest_api_user.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser(User apiRequest) {
    	userDao.saveUser(apiRequest);
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
