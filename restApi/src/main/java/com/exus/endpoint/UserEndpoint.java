package com.exus.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.exus.entity.ResponseWrapper;
import com.exus.entity.User;
import com.exus.service.UserService;

@Component
@Path("/")
public class UserEndpoint {
	
	private static final Logger logger = LoggerFactory.getLogger(UserEndpoint.class);
	
	@Autowired
	private UserService userService;


	@GET
	@Path("/getUser")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<ResponseWrapper> getUser(@QueryParam(value = "email") String email,
			@QueryParam(value = "ip_address") String ipAddress) {
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		User user = null;
		if (email != null)
			user = userService.getUserByEmail(email);
		else if (ipAddress != null)
			user = userService.getUserByIpAddress(ipAddress);
		
		if (user!=null){
			logger.info("User found.");
			responseWrapper.setUser(user);
			responseWrapper.setSuccessMessage("User is found");
			return new ResponseEntity<ResponseWrapper>(responseWrapper,HttpStatus.OK);
		}else { 
			logger.info("User not found.");
			responseWrapper.setErrorMessage("User not found.");
			return new ResponseEntity<ResponseWrapper>(responseWrapper,HttpStatus.NOT_FOUND);
		}
	}

	@POST
	@Path("/saveUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public   ResponseEntity<ResponseWrapper> addArticle(User user) {
		
		ResponseWrapper responseWrapper = new ResponseWrapper();
		boolean isAdded = userService.saveUser(user);
		if (!isAdded) {
			logger.info("User already exists.");
			responseWrapper.setErrorMessage("User already exists.");
			return new ResponseEntity<ResponseWrapper>(responseWrapper,HttpStatus.CONFLICT);
		}
		logger.info("User created.");
		responseWrapper.setSuccessMessage("User created.");
		responseWrapper.setUser(user);
		return new ResponseEntity<ResponseWrapper>(responseWrapper,HttpStatus.CREATED);
	}

}