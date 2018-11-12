package exus.restapi.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import exus.restapi.domain.User;
import exus.restapi.repository.UserDao;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

	@Override
	public User getUserByEmail(String email) {
		   Query query = entityManager.createNativeQuery("Select user.id,user.first_name,user.last_name,user.email,user.gender,user.ip_address From User user where user.email = ?",
                   User.class);
		   query.setParameter(1,email);
		   
		   
		   return (User)query.getResultList().get(0);
	}

	@Override
	public User getUserByIpAddress(String ipAddress) {
		  Query query = entityManager.createNativeQuery("Select user.id,user.first_name,user.last_name,user.email,user.gender,user.ip_address From User user where user.ip_address = ?",
                  User.class);
		   query.setParameter(1,ipAddress);
		   
		   
		   return (User)query.getResultList().get(0);
	}



}
