package userManagement.model;

/* *
 * Class to define a User
 * A user is defined by:
 * 	- id
 * 	- name
 * 	- email
 * 	- country
 * */

public class User {

	private int id;
	private String name;
	private String email;
	private String country;
	
	//constructor
	public User(String name, String email, String country) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
	}
	
	// getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
