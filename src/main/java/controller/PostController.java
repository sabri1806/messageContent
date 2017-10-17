package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import model.DB;
import model.Post;
import model.User;

@Stateless
public class PostController {

	@Inject
	private DB db;
	
//	create(User user,String content)
		//	Crea un post en la base de datos
		//	Le asigna la fecha actual
		//	Le asigna un id automático.
	
//	all():List<Post>
		//	Devuelve todos los post
	
//	by(User user): List<Post>
		//	Devuelve todos los post de un usuario

	public void getPost(String username, String message) {
		
	}
	
	public List<Post> getAllPost(){
		return db.getPosts();
	}
	
	public List<Post> getUserPost(User user){
		List<Post> userPost = new ArrayList<>();
		for(Post p : getAllPost() ) {
			if(p.getUserId()== user.getId()) {
				userPost.add(p);
			}
			
		}
		return userPost;
	}
}
