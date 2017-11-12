package view;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import controller.UserController;
import model.User;

import java.io.Serializable;

@ManagedBean
public class RegisterMb implements Serializable {

	@Inject
	private UserController userCntr;

	private int userId;
	private String username;
	private String password;
	private String mail;
	private String usernameErrorMsg;

	
	public String register(){
		User user = new User(mail, username, password);
		//este lo hacia con el singleton
		//userCntr.register(user);
		System.out.println("registrando usuario");
		userCntr.create(user);
		//mje de registrado en forma correcta
		return "login";
	}

	public void validateUsername(){
		if (this.username.length()> 3){
			this.setUsernameErrorMsg("error: muy largo");
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
}
