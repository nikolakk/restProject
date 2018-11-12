package exus.restapi.repository;

import exus.restapi.domain.User;

public interface UserDao {
    
	void saveUser(User user);
        
    User getUserByEmail(String email);
    
    User getUserByIpAddress(String ipAddress);


}
