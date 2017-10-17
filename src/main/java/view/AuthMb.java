package view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import controller.PostController;
import controller.UserController;
import model.User;
import model.Post;

@Named
@SessionScoped
public class AuthMb implements Serializable{
	
	private static final long serialVersionUID = 791515424619865689L;

	private String username;
	private String password;
	private User currentUser;	
	@Inject
	private PostController  postCntr;
	@Inject
	private UserController userCntr;
	
	public boolean isLogged(){
		return currentUser != null;
	}
	public List<Post> getUserPost(){
		System.out.println("buscando post");
		System.out.println(currentUser.getId());
		return postCntr.getUserPost(currentUser);
	}
	public String loggin() {
		currentUser = userCntr.getAuthUser(username, password);
		System.out.println(currentUser);

		username = null;
		password = null;
		if (isLogged())
			return "home?faces-redirect=true";
		else
			return null;
	}
	
	public String logout(){
		currentUser = null;
		return "index";
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
