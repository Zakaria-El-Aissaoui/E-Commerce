package Menu;

import java.util.Scanner;

import Configs.ApplicationContext;

public class ChangeEmailMenu implements Menu {
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
		context.getLoggedInUser().setEmail(userInput);
		System.out.println("Your email has been successfully changed");
		new MainMenu().start();

	}

	@Override
	public void printMenuHeader() {
		// TODO Auto-generated method stub
		System.out.println("***** CHANGE EMAIL *****");
		System.out.print("Enter new email: ");

	}

}
