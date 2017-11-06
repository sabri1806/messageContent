package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String mail;
	private String username;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_user")
	private List<Post> posts = new ArrayList<Post>();
	
	
	public List<Post> getPosts() {
		return posts;
	}

	public void addPost(Post post) {
		System.out.println("soy el id del user"+ this.id);
		this.posts.add(post);
		System.out.println("soy los post del user"+ post.getMessage());

	}
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public User(String mail, String username, String password) {
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
