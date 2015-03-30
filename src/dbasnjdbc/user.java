package dbasnjdbc;

public class user {
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private String dateofbirth;
	
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}

	public user(String username, String password, String first_name,
			String last_name, String email, String dateofbirth) {
		super();
		
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.dateofbirth = dateofbirth;
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

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public String getDateOfBirth() {
		return dateofbirth;
	}

	public void setDateOfBirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

