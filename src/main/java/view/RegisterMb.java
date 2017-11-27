package view;

import controller.ImageController;
import controller.UserController;
import model.Image;
import model.User;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.servlet.http.Part;


import java.io.IOException;
import java.io.Serializable;

@ManagedBean
public class RegisterMb implements Serializable {

	@Inject
	private UserController userCntr;

	@Inject
	private ImageController imgCntr;

	private int userId;
	private String username;
	private String password;
	private String mail;
	private String usernameErrorMsg;
	private String mailErrorMsg;
	private Part image;




	public String register(){
		try{
			Image img = null;

			if (image != null && image.getSize() > 0 && image.getContentType().startsWith("image/")){
				img = imgCntr.upload(image);
			}

			User user = new User(mail, username, password, img);
			userCntr.create(user);
			return "login";
		}catch (IOException e){
			e.printStackTrace();
		}

		return "login";
	}

	public void validateUsername(){
		if (this.username.length() < 4 || this.username.length()>= 8  ){
			this.setUsernameErrorMsg("You must enter an username between 4 and 8 characters");
		}
	}

	public void validateMail(){
		if (this.mail == null || !this.mail.endsWith("@mail.com") ) {
			this.setMailErrorMsg("Insert a valid mail please. Eg: pepe@mail.com");
		}
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsernameErrorMsg() {
		return usernameErrorMsg;
	}

	public void setUsernameErrorMsg(String usernameErrorMsg) {
		this.usernameErrorMsg = usernameErrorMsg;
	}

	public String getMailErrorMsg() {
		return mailErrorMsg;
	}

	public void setMailErrorMsg(String mailErrorMsg) {
		this.mailErrorMsg = mailErrorMsg;
	}

	public Part getImage() {
		return image;
	}

	public void setImage(Part image) {
		this.image = image;
	}
}
