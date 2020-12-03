package Menu;

import java.util.Scanner;

import com.sun.tools.javac.Main;

import Configs.ApplicationContext;

public class MainMenu implements Menu {
	public static final String MENU_COMMAND="menu";
	private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed." + System.lineSeparator()
	+ "1. Sign Up" + System.lineSeparator() + "2. Sign In"
	+ System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
	+ "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() + 
	"6. Customer List";
	private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed." + System.lineSeparator()
	+ "1. Sign Up" + System.lineSeparator() + "2. Sign Out"
	+ System.lineSeparator() + "3. Product Catalog" + System.lineSeparator()
	+ "4. My Orders" + System.lineSeparator() + "5. Settings" + System.lineSeparator() + 
	"6. Customer List";;
	
	private ApplicationContext context ;
	{
		context=ApplicationContext.getInstance();
	}
	

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
		
		Menu menuToNavigate = null;
		mainLoop: while (true) {
			printMenuHeader();
			
			Scanner sc = new Scanner(System.in);

			System.out.print("User input: ");
			String userInput = sc.next();
			
				int commandNumber = Integer.parseInt(userInput);
				switch (commandNumber) {
				
				case 1:
					menuToNavigate = new SignUpMenu();
					break ;
				case 2:
					if (context.getLoggedInUser() == null) {
						menuToNavigate = new SignInMenu();
					} else {
						menuToNavigate = new SignOutMenu();
					}
					break ;
				case 3:
					menuToNavigate = new ProductCatalogMenu();
					break ;
				case 4:
					menuToNavigate = new MyOrdersMenu();
					break ;
				case 5:
					menuToNavigate = new SettingsMenu();
					break ;
				case 6:
					menuToNavigate = new CustomerListMenu();
					break ;
				default:
					System.out.println("Only 1, 2, 3, 4, 5 is allowed. Try one more time");
					continue; // continue endless loop
			
				
				
				}
				menuToNavigate.start();

			}
		
		
		
		

	}

	@Override
	public void printMenuHeader() {
		// TODO Auto-generated method stub
		System.out.println("***** MAIN MENU *****");
		if (context.getLoggedInUser() == null) {
			System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER);
		} else {
			System.out.println(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER);
		}
	}

	

}
