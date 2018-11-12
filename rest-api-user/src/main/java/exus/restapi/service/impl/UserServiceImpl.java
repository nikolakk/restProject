package exus.restapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import exus.restapi.domain.User;
import exus.restapi.repository.UserDao;
import exus.restapi.service.UserService;

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
