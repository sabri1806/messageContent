package view;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;

import controller.ImageController;
import controller.PostController;
import controller.UserController;
import dto.UserPostDto;
import model.Comment;
import model.Image;
import model.Post;

@ManagedBean
@SessionScoped
public class HomeMb {

	@Inject
	private PostController  postCntr;

	@Inject
	private ImageController imgCntl;
	
	@Inject
	private UserController  userController;

	private int id;
	private String message;
	private String postErrorMsg;
	private String currentComment;
	private String commentErrorMsg;
	private Part image;


	public String savePost() {
		try {
			Image img = null;
			if(image != null && image.getSize() > 0 && image.getContentType().startsWith("image/")){
				img = imgCntl.upload(image);
			}

			Post post = new Post(new Date(), this.getMessage(), img);
			userController.getCurrentUser().addPost(post);
			userController.save(userController.getCurrentUser());
		} catch (IOException e){
			e.printStackTrace();
		}

		//This is to reset the input post
		this.setMessage("");
		return "";
	}



	public void validatePost(){
		if (this.getMessage().length()<2){
			this.setPostErrorMsg("You can create a post here ");
		}else {
			this.setPostErrorMsg("");
		}
	}

	public boolean validateComment(){
		if (this.getCurrentComment().length()<1){
			this.setCommentErrorMsg("Enter please a comment");
			return false;
		}else {
			this.setCommentErrorMsg("");
			return true;
		}
	}


	public void createComment(UserPostDto postDto){
		if(!validateComment()){
			return;
		}
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

	public List<UserPostDto> getAllMyPost(){
		return postCntr.getAllMyPost(userController.getCurrentUser());
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

	public Part getImage() {
		return image;
	}

	public void setImage(Part image) {
		this.image = image;
	}

	public String getCommentErrorMsg() {
		return commentErrorMsg;
	}

	public void setCommentErrorMsg(String commentErrorMsg) {
		this.commentErrorMsg = commentErrorMsg;
	}
}
