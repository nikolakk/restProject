package com.exus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exus.entity.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void saveUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public User getUserByEmail(String email) {
		Query query = entityManager.createQuery("SELECT user FROM User user WHERE user.email= :email");

		query.setParameter("email", email);
		query.setMaxResults(1);

		User user = (User) query.getSingleResult();

		return user;

	}

	@Override
	public User getUserByIpAddress(String ipAddress) {

		Query query = entityManager.createQuery("SELECT user FROM User user WHERE user.ipAddress= :ipAddress");

		query.setParameter("ipAddress", ipAddress);
		query.setMaxResults(1);

		User user = (User) query.getSingleResult();

		return user;

	}

	@Override
	public boolean checkIfUserExists(User user) {

		Query query = entityManager.createQuery("SELECT user FROM User user WHERE user.id= :id");

		query.setParameter("id", user.getId());
		query.setMaxResults(1);

		List<User> users = query.getResultList();
		if (!users.isEmpty())

			return true;
		else
			return false;
	}

}
