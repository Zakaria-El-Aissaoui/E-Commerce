package Menu;

import Configs.ApplicationContext;
import entities.User;
import services.DefaultUserManagementService;
import services.UserManagementService;

public class CustomerListMenu implements Menu {
	private ApplicationContext context;
	private UserManagementService userManagementService;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		printMenuHeader();
		User[] users = userManagementService.getUsers();
		
		if (users==null) {
			System.out.println("Unfortunately, there are no customers.");
		} else {
			for (User user : users) {
				System.out.println(user);
			}
		}
		((Menu) context.getMainMenu()).start();
		

	}

	@Override
	public void printMenuHeader() {
		// TODO Auto-generated method stub
		System.out.println("***** USERS *****");		


	}

}
