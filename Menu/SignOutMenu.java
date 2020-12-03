package Menu;

import Configs.ApplicationContext;

public class SignOutMenu implements Menu {
private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		printMenuHeader();
		context.setLoggedInUser(null);

	}

	@Override
	public void printMenuHeader() {
		// TODO Auto-generated method stub
		System.out.println("***** Sign Out *****");
		System.out.println("Have a nice day! Look forward to welcoming back!");

	}

}
