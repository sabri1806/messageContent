package dto;


import model.Comment;

import java.util.ArrayList;
import java.util.List;

public class UserPostDto {
	
	//userName
	//date
	//message
	private int id;
	private String userName;
	private String date;
	private String message;
	private List<Comment> comments = new ArrayList<>();
	
	public UserPostDto(int id,String userName,String date, String message, List comments) {
		this.id = id;
		this.userName = userName;
		this.date = date;
		this.message = message;
		this.comments = comments;
	}

	public String getUserName() {
		return userName;
	}

	public String getDate() {
		return date;
	}

	public String getMessage() {
		return message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
