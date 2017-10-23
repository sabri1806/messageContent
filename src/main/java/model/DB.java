package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Singleton;
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
		
		posts.add(new Post(1, "p",  new Date(), "este es mi primer post que emocion! :P ",1));
		posts.add(new Post(2, "p", new Date(), "otro post que escribi recien ",1));
		posts.add(new Post(3, "a", new Date(), "sigo escribiendo ",2));
		posts.add(new Post(4, "a", new Date(), "esto es un monton de posts ya",2));
	}
	
	public List <Post>getPosts(){
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
