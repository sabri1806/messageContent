package view;

import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import controller.PostController;
import controller.UserController;
import dto.UserPostDto;
import model.Comment;
import model.Post;

@ManagedBean
@SessionScoped
public class HomeMb {

	@Inject
	private PostController  postCntr;
	
	@Inject
	private UserController  userController;
	private int id;
	private String message;
	private String postErrorMsg;
	private String currentComment;


	public String savePost() {

		Post post = new Post(new Date(), this.getMessage());
		userController.getCurrentUser().addPost(post);
		userController.save(userController.getCurrentUser());

		//This is to reset the input post
		this.setMessage("");
		return "";
	}

	public void validatePost(){
		if (this.getMessage().length()<2){
			this.setPostErrorMsg("You can create a post here");
		}else {
			this.setPostErrorMsg("");
		}
	}

	public void createComment(UserPostDto postDto){
		Post p = postCntr.getPostById(postDto.getId());
		p.getComments().add(new Comment(this.currentComment));
		postCntr.save(p);
		this.setCurrentComment("");

	}

	public void deletePost(UserPostDto userPostDto) {
		postCntr.deletePost(userPostDto.getId());
		FacesMessage facesMessage = new FacesMessage("The post was deleted successfully!!");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

		int userId = userController.getCurrentUser().getId();
		userController.setCurrentUser(userController.getFreshUser(userId));
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

	public String getCurrentComment() {
		return currentComment;
	}

	public void setCurrentComment(String currentComment) {
		this.currentComment = currentComment;
	}
}
