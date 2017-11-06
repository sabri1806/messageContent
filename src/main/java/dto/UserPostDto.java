package dto;


public class UserPostDto {
	
	//userName
	//date
	//message
	private String userName;
	private String date;
	private String message;
	
	public UserPostDto(String userName,String date, String message) {
		this.userName = userName;
		this.date = date;
		this.message = message;
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
	
	
	

}
