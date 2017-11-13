package dto;


import java.util.List;

public class UserPostDto {
	
	//userName
	//date
	//message
	private int id;
	private String userName;
	private String date;
	private String message;
	private String comment;
	
	public UserPostDto(int id,String userName,String date, String message, String comments) {
		this.id = id;
		this.userName = userName;
		this.date = date;
		this.message = message;
		this.comment = comments;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
