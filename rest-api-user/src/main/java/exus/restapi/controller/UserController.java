package exus.restapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import exus.restapi.domain.User;
import exus.restapi.service.UserService;

@RestController
@EnableAutoConfiguration
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    /** @ResponseBody is added to solve "There was an unexpected error (type=Internal Server Error, status=500).
    No converter found for return value of type: class exus.restapi.rest_api_user.domain.User"
    
    */
    @RequestMapping(value="/getUser", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> getUserByEmail(
                @RequestParam(value = "email", required = false) String email,
                @RequestParam(value = "ip_address", required = false) String ipAddress) {
    	
    			User user = new User();
    			if (email!=null)
    				user = userService.getUserByEmail(email);
    			else if (ipAddress!=null)
    				user = userService.getUserByIpAddress(ipAddress);
    			return new ResponseEntity<User>(user, HttpStatus.OK);
    	}
    
    
    
    
}
