package entities;

import entities.User;

public class DefaultUser implements User {
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private static int userCount=0;
	{
		id=++userCount;
	}

	


	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return this.firstName;
	}
	
	public  DefaultUser(String firstName,String lastName,String password,String email) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.password=password;
		this.email=email;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return this.lastName;
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setPassword(String newPassword) {
		// TODO Auto-generated method stub
		if(newPassword==null) {
			return ;}
		this.password= newPassword;

	}

	@Override
	public void setEmail(String newEmail) {
		// TODO Auto-generated method stub
		if(newEmail==null) {
			return;
		}
		this.email= newEmail;

	}
	@Override
	public String toString() {
		return "DefaultUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", email=" + email + "]";
	}

	void clearState() {
		userCount=0;
	}

}
