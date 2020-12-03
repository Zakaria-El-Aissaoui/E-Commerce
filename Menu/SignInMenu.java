package Menu;

import java.util.Scanner;

import Configs.ApplicationContext;
import entities.User;
import services.DefaultUserManagementService;
import services.UserManagementService;

public class SignInMenu implements Menu {
	private ApplicationContext context;
	private UserManagementService userManagementService;
	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		printMenuHeader();
		Scanner sc =new Scanner(System.in);
		System.out.print("Please, enter your email: ");
		String userEmail = sc.next();

		System.out.print("Please, enter your password: ");
		String userPassword = sc.next();
		User user = userManagementService.getUserByEmail(userEmail);
		if (user != null && user.getPassword().equals(userPassword)) {
			System.out.printf("Glad to see you back %s %s", user.getFirstName(),
					user.getLastName() + System.lineSeparator());
			context.setLoggedInUser(user);
		} else {
			System.out.println("Unfortunately, such login and password doesn’t exist");
		}
		((Menu) context.getMainMenu()).start();


	}

	@Override
	public void printMenuHeader() {
		// TODO Auto-generated method stub
		System.out.println("***** Sign In *****");		


	}

}
