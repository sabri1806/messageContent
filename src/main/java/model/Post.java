package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
	
	private int id;
	private Date dateMessage;
	private String message;
	
	
	public Post(int id,Date dateMessage, String message) {
		System.out.println("creando post "+ message);
		this.id = id;
		this.dateMessage = dateMessage;
		this.message = message;
		
	}

	public int getId() {
		return id;
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

	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
