package finalProject3311;

public class newAccFormat {
	String username;
	String email;
	String password;
	
	
	public newAccFormat(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public String toString() {
		return  username + ", " + email +","+password;
	}
}
