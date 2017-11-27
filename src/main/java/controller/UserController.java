package controller;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.DB;
import model.User;

@Stateless
public class UserController {

	@Inject
	private DB db;
	private User currentUser;

	@PersistenceContext
	private EntityManager entityManager;

	public void create(User user) {
		entityManager.merge(user);
	}
	
	public void save(User user) {
		entityManager.merge(user);
		entityManager.flush();
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public  User getFreshUser(int id) {
		String hql = "Select u from User u where u.id = :id";
		TypedQuery<User> q = entityManager.createQuery(hql, User.class);
		q.setParameter("id", id);

		return q.getResultList().get(0);
	}

	public User getAuthUser(String username, String password) {
		
		String hql = "Select u from User u where u.username = :username";
		TypedQuery<User> q = entityManager.createQuery(hql, User.class);
		q.setParameter("username", username);

		List<User> u = q.getResultList();
		
		for(User user : u) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}

		return null;
	}


	public boolean verifyIfExist(String username) {

		String hql = "Select u from User u where u.username = :username";
		TypedQuery<User> q = entityManager.createQuery(hql, User.class);
		q.setParameter("username", username);

		List<User> u = q.getResultList();

		for (User user : u) {
			if (user.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

}
