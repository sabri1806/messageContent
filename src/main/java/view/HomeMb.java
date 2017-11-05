package view;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import controller.PostController;
import controller.UserController;
import dto.UserPostDto;
import model.Post;

@Named
public class HomeMb {

	@Inject
	private PostController  postCntr;
	
	@Inject
	private UserController  userController;
	private int id;
	private String message;
	
	public void savePost() {
		int nextId = postCntr.getAllPost().size()+1;
		System.out.println(this.message);
		System.out.println(nextId);

		Post post = new Post(nextId, new Date(), this.getMessage());
		userController.getCurrentUser().addPost(post);
	}
	

	public int getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<UserPostDto> getPosts(){
		System.out.println("estoy en get posts de homemb");
		return postCntr.getAllPost();
	}
	
	
	
}
