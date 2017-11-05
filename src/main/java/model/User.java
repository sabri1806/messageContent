package model;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private int id;
	private String mail;
	private String username;
	private String password;
	private List<Post> posts = new ArrayList<Post>();
	
	
	
	public List<Post> getPosts() {
		return posts;
	}

	public void addPost(Post post) {
		this.posts.add(post);
	}
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public User(int id, String mail, String username, String password) {
		super();
		this.id = id;
		this.mail = mail;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	
	public String getMail() {
		return mail;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
