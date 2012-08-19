/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zw.co.mitech.mtutor.session;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import zw.co.mitech.mtutor.entities.Quiz;
import zw.co.mitech.mtutor.entities.User;

/**
 *
 * @author douglas
 */
@Repository("userDao")
@Transactional
public class UserFacade extends AbstractFacade<User> {
   
	@PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

	public List<User> getUsers() {
		
		return findAll();
	}

	public User findUserByUsername(String username) {
		String ql = "Select u FROM User u WHERE u.username =:username";
		Query query = getEntityManager().createQuery(ql);
		query.setParameter("username", username);
		query.setMaxResults(1);
		try {
			User user = (User) query.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	public User findUserByOwnerId(String ownerId) {
		String ql = "Select u FROM User u WHERE u.ownerId =:ownerId";
		Query query = getEntityManager().createQuery(ql);
		query.setParameter("ownerId", ownerId);
		query.setMaxResults(1);
		try {
			User user = (User) query.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}
    
    
}
