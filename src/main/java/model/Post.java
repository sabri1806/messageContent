package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
	
	private int id;
	private String user;
	private Date dateMessage;
	private String message;
	private int userId;
	
	public Post(int id, String user,Date dateMessage, String message, int userId) {
		super();
		this.id = id;
		this.user = user;
		this.dateMessage = dateMessage;
		this.message = message;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public String getDateMessage() {
		
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

		return dateFormat.format(dateMessage) ;
	}

	public String getMessage() {
		return message;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getUserId() {
		return userId;
	}
	

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
