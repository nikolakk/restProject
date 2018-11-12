package exus.restapi.service;

import java.util.List;

import exus.restapi.domain.User;

public interface UserService {
   
	
	void saveUser(User apiRequest);
   
    User getUserByEmail(String email);
    
    User getUserByIpAddress(String ipAddress);

}
