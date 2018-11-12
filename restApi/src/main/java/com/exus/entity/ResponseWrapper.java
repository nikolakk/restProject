package com.exus.entity;

import java.util.List;

public class ResponseWrapper {
	
	User user;
	
	String errorMessage;
	
	String successMessage;

	public ResponseWrapper(){
		
	}

	public ResponseWrapper( User user, String errorMessage, String successMessage) {
		
		
		this.user = user;
		this.errorMessage = errorMessage;
		this.successMessage = successMessage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	

}
