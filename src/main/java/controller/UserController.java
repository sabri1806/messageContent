package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dto.UserPostDto;
import model.DB;
import model.User;

@Stateless
public class UserController {

	@Inject
	private DB db;
	private User currentUser;
	
	
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public User getAuthUser(String username,String password){
		for(User user : db.getUsers()){
			if (user.getUsername().equals(username) 
			 && user.getPassword().equals(password)){
					return user;
			}
		}
		return null;
	}
	
	public User validateUser(String username, String password){
		
		for(User user : db.getUsers()){
			if (user.getUsername().equals(username) && user.getPassword().equals(password)){
					return user;
			}
		}
		return null;
	}
	
	public boolean verifyIfExist(String username) {
		
		
		for (User user : db.getUsers()) {
		if (user.getUsername().equals(username)){
			return true;
		}
		}
		return false;
		
	}
	public void register(User user){
		if(verifyIfExist(user.getUsername())){
			throw new RuntimeException("User already exists");
		}
		user.setId(db.nextUserId());
		db.getUsers().add(user);
	}
	
	public List<User> getAllUsers() {
		return db.getUsers();
	}
	
	
}
