package exus.restapi.rest_api_user.service;

import java.util.List;

import exus.restapi.rest_api_user.domain.User;

public interface UserService {
   
	
	void saveUser(User apiRequest);
   
    User getUserByEmail(String email);
    
    User getUserByIpAddress(String ipAddress);

}
