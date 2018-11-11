package exus.restapi.rest_api_user.domain;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String exception) {
		super(exception);
	}

}
