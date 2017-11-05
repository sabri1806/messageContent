package manageBean;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

import model.DB;
import model.Post;
import model.User;

@ManagedBean(value = "myMb")
@SessionScoped
public class MyMb {

	private DB db = new DB();

	
	private int id;
	private String mail;
	private String userName;
	private String passWord;
	private int idPost;
	private String message;
	
	public void add() {

	}
	
	public List<User> getUser(){
		return db.getUsers();
	}

	public int getId() {
		return id;
	}

	public String getMail() {
		return mail;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
