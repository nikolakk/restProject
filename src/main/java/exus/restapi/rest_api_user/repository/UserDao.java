package exus.restapi.rest_api_user.repository;

import exus.restapi.rest_api_user.domain.User;

public interface UserDao {
    
	void saveUser(User user);
        
    User getUserByEmail(String email);
    
    User getUserByIpAddress(String ipAddress);


}
