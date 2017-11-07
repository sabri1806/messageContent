package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.DB;
import model.Post;
import model.User;

@Stateless
public class UserController {

	@Inject
	private DB db;
	private User currentUser;

	@PersistenceContext
	private EntityManager entityManager;

	public void create(User user) {
		System.out.println("persistiendo user");
		System.out.println(user.getUsername());
		entityManager.persist(user);
	}
	
	public void save(User user) {
		System.out.println("post del usuario "+user.getPosts());
		entityManager.merge(user);
		entityManager.flush();
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public User getAuthUser(String username, String password) {
		
		String hql = "Select u from User u where u.username = :username";
		TypedQuery<User> q = entityManager.createQuery(hql, User.class);
		q.setParameter("username", username);

		List<User> u = q.getResultList();
		
		for(User user : u) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				System.out.println("el user existe : " + user);
				System.out.println("sus post son: " + user.getPosts());
				return user;
			}
			System.out.println("pase por getAuthuser"+ "username: "+username +"user: " + user);
		}
		System.out.println("pase por getAuthuser pero no obtuve el user"+ "USERNAME: "+username);
		return null;
	}

	public User validateUser(String username, String password) {
		//aca tengo que reemplazar obtener user por entity manager en lugar de la clase db para validarlo
		for (User user : db.getUsers()) {
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
			System.out.println(user.getUsername() + "estoy pasando por verify if exist");
		}
		System.out.println("estoy pasando por verify if exist ?!");
		return false;
	}

	public List<User> getAllUsers() {
		return db.getUsers();
	}

}
