package services;

import java.util.Arrays;

import Configs.ApplicationContext;
import entities.User;

public class DefaultUserManagementService implements UserManagementService {
	
	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";
	
	private static final int DEFAULT_USERS_CAPACITY = 10;
	
	private static DefaultUserManagementService instance;
	
	private User[] users;
	private int lastIndex;
	{
		users = new User[DEFAULT_USERS_CAPACITY];
	}

	public DefaultUserManagementService() {
	}
	public static DefaultUserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}

	public static void setInstance(DefaultUserManagementService instance) {
		DefaultUserManagementService.instance = instance;
		
		
	}

	@Override
	public String registerUser(User newuser) {
		// TODO Auto-generated method stub
		if(newuser.getEmail()==null || newuser.getEmail().isEmpty() ) {
			return EMPTY_EMAIL_ERROR_MESSAGE;
		}
		if(users!=null) {
		for(User user:users) {
			if(user!=null&&user.getEmail()==newuser.getEmail()) {
				return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
			}
		}}
		if(users.length<=lastIndex) {
			users=Arrays.copyOf(users, lastIndex<<1);
		}
		users[lastIndex++]=newuser;
		return NO_ERROR_MESSAGE;
		
		
	}

	@Override
	public User[] getUsers() {
		// TODO Auto-generated method stub
		int nonNullUser=0;
		for(User user:users) {
			if(user!=null) {
				nonNullUser++;
			}
		}
		User usersFiltred[]=new User[nonNullUser];
		int index=0;
		for(User user:users) {
			if(user!=null) {
				usersFiltred[index++]=user;
			}
		}
		
		return usersFiltred;
	}

	@Override
	public User getUserByEmail(String userEmail) {
		// TODO Auto-generated method stub
		for(User user:users) {
			if(user!=null&&user.getEmail()==userEmail) {
				return user;
			}
		}
		
		return null;
	}
	void clearServiceState() {
		lastIndex=0;
		users= new User[DEFAULT_USERS_CAPACITY];
	}

}
