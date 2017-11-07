package view;

import java.util.Date;
import java.util.List;
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
	
	public String savePost() {
		System.out.println(this.message);

		Post post = new Post(new Date(), this.getMessage());
		userController.getCurrentUser().addPost(post);
		userController.save(userController.getCurrentUser());
		
		return "";
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
