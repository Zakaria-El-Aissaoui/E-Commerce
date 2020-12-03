package Menu;

import java.util.Scanner;
import entities.DefaultUser;
import entities.User;
import Configs.ApplicationContext;
import Menu.Menu;
import services.DefaultUserManagementService;
import services.UserManagementService;

public class SignUpMenu implements Menu {
	private UserManagementService userManagementService;
	private ApplicationContext context;
	
	{
		userManagementService = new DefaultUserManagementService();
		context =  ApplicationContext.getInstance();
	}
	
	
	

	@Override
	public void start() {
		// TODO Auto-generated method stub
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter your first name: ");
		String firstName = sc.next();
		System.out.print("Please, enter your last name: ");
		String lastName = sc.next();
		System.out.print("Please, enter your password: ");
		String password = sc.next();
		System.out.print("Please, enter your email: ");
		
		sc = new Scanner(System.in);
		String email = sc.nextLine();
		
		User user =new DefaultUser(firstName,lastName,password,email);
		String errorMessage=userManagementService.registerUser(user);
		if(errorMessage==null || errorMessage.isEmpty()) {
			context.setLoggedInUser(user);
			System.out.println("New user is created");
		
		}
		else {
			System.out.println(errorMessage);
		}
		
		
		
		

	}

	@Override
	public void printMenuHeader() {
		// TODO Auto-generated method stub
		System.out.println("***** SIGN UP *****");

	}

}
