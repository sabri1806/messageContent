package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date date;
	private String message;
	
	public Post(Date dateMessage, String message) {
		System.out.println("creando post "+ message);
		this.date = dateMessage;
		this.message = message;	
	}
	
	public int getId() {
		return id;
	}

	public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return dateFormat.format(date) ;
	}

	public String getMessage() {
		return message;
	}

	public void setId(int idPost) {
		this.id = idPost;
	}

	public void setDate(Date dateMessage) {
		this.date = dateMessage;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
