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
	private String postErrorMsg;
	
	public String savePost() {

		Post post = new Post(new Date(), this.getMessage());
		userController.getCurrentUser().addPost(post);
		userController.save(userController.getCurrentUser());
		
		return "";
	}

	public void validatePost(){
		if (this.postErrorMsg == null){
			this.setPostErrorMsg(" Are you sure you do not want to write a post? :p");
		}
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
		return postCntr.getAllPost();
	}


	public String getPostErrorMsg() {
		return postErrorMsg;
	}

	public void setPostErrorMsg(String postErrorMsg) {
		this.postErrorMsg = postErrorMsg;
	}
}
