package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;



@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date date;
	private String message;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	private Image image;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_post")
	private List<Comment> comments = new ArrayList<>();
	
	public Post(Date dateMessage, String message, Image image) {
		System.out.println("creando post "+ message);
		this.date = dateMessage;
		this.message = message;
		this.image = image;
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


	public List<Comment> getComments() {
		if(this.comments == null ){
			this.comments= new ArrayList<>();
		}
		return comments;
	}

	/*public String getCommentsStr() {
		String result = "";
		for (Comment c: this.getComments()){
			result += "-" + c.getComment();
		}
		return result;
	}*/

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
}
