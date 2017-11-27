package model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String mail;
	private String username;
	private String password;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Image image;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_user")
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

	public User(String mail, String username, String password, Image img) {
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.image = img;
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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
