package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Singleton;

import dto.UserPostDto;
@Singleton
public class DB {
		
	private List<User> users = new ArrayList<>();
	private List<Post> posts = new ArrayList<>();
	
	public DB() {
		User user = new User(1,"p","p","p");
		user.setId(nextUserId());
		users.add(user);
		
		User user2 = new User(1,"a","a","a");
		user2.setId(nextUserId());
		users.add(user2);
		
		user.addPost(new Post(1, new Date(), "este es mi primer post que emocion! :P "));
		user.addPost(new Post(2, new Date(), "otro post que escribi recien "));
		user2.addPost(new Post(3, new Date(), "sigo escribiendo posts "));
		user2.addPost(new Post(4, new Date(), "estos ya son un monton de posts"));
	}
	private List <UserPostDto> userpostdto = new ArrayList<>();
	public List<Post> getPosts(){
		posts = new ArrayList<>();
		for (User user : users) {
			posts.addAll(user.getPosts());
			//userpostdto.add(new userpostdto(user.getUsername(), date, message));
		}
		
		System.out.println(posts);
		return posts;
	}
	public void addPost(Post ps) {
		posts.add(ps);
	}

	public List <User> getUsers(){
		return users;
	}

	public void addUser(User us) {
		users.add(us);
	}

	public int nextUserId(){
		return users.size()+1;
	}
	
	
}
