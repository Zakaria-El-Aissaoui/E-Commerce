package Menu;

import java.util.Scanner;

import Configs.ApplicationContext;

public class ChangePasswordMenu implements Menu {
	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		printMenuHeader();
		Scanner sc = new Scanner(System.in);
		String userInput = sc.next();
		context.getLoggedInUser().setPassword(userInput);
		System.out.println("Your password has been successfully changed");
		new MainMenu().start();

	}

	@Override
	public void printMenuHeader() {
		// TODO Auto-generated method stub
		System.out.println("***** CHANGE PASSWORD *****");
		System.out.print("Enter new password: ");

	}

}
