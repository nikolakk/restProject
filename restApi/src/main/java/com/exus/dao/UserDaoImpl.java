package com.exus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exus.endpoint.UserEndpoint;
import com.exus.entity.User;
import com.exus.entity.UserNotFoundException;


 
@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);


	@Override
	public void saveUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public User getUserByEmail(String email) {
		
		User user = null;
		try{
			Query query = entityManager.createQuery("SELECT user FROM User user WHERE user.email= :email");
	
			query.setParameter("email", email);
			query.setMaxResults(1);
	
			user = (User) query.getSingleResult();
	
			
			if (user==null)
				logger.info("user with email " + email+"not found in database");
			
		} catch(Exception e){
			logger.info(e.getMessage());
		}
		return user;

	}

	@Override
	public User getUserByIpAddress(String ipAddress) {

		User user = null;
		
		try{
			Query query = entityManager.createQuery("SELECT user FROM User user WHERE user.ipAddress= :ipAddress");
	
			query.setParameter("ipAddress", ipAddress);
			query.setMaxResults(1);
	
			user = (User) query.getSingleResult();

			if (user==null)
				logger.info("user with ipAddress " + ipAddress+"not found in database");
			
		} catch(Exception e){
			logger.info(e.getMessage());

		}
		
		return user;

	}

	@Override
	public boolean checkIfUserExists(User user) {
		try{
		Query query = entityManager.createQuery("SELECT user FROM User user WHERE user.id= :id");

		query.setParameter("id", user.getId());
		query.setMaxResults(1);

		List<User> users = query.getResultList();
		if (!users.isEmpty())

			return true;
		else
			return false;
		
		} catch(Exception e){
			logger.info(e.getMessage());
			return false;
		}
	}

}
