package view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import controller.PostController;
import model.Post;
import model.User;

@Named
@SessionScoped
public class HomeMb implements Serializable {

	private static final long serialVersionUID = 791515424619865689L;
	

	
	private int id;
	private String message;
	

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
	
	
	
}
