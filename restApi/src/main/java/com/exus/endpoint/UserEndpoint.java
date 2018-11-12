package com.exus.endpoint;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

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
	public ResponseEntity<User> getUser(@QueryParam(value = "email") String email,
			@QueryParam(value = "ip_address") String ipAddress) {
		User user = null;
		if (email != null)
			user = userService.getUserByEmail(email);
		else if (ipAddress != null)
			user = userService.getUserByIpAddress(ipAddress);
		
		if (user!=null){
			logger.info("User found.");
			return new ResponseEntity<User>(user, HttpStatus.FOUND);
		}else { 
			logger.info("User not found.");
			return new ResponseEntity<User>(user, HttpStatus.NO_CONTENT);
		}
	}

	@POST
	@Path("/saveUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public  ResponseEntity<Object> addArticle(User user) {
		boolean isAdded = userService.saveUser(user);
		if (!isAdded) {
			logger.info("User already exists.");
			return new  ResponseEntity<Object>(HttpStatus.CONFLICT);
		}
		logger.info("User created.");
		return new  ResponseEntity<Object>(HttpStatus.CREATED);
	}

}