package ie.gmit.dip;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {

	private Scanner s;

	public void mainMenu() throws Exception {
		{
			showOptions();			//show menu
			s = new Scanner(System.in);
			int menuChoice = Integer.parseInt(s.next());    //Take in int from user to determine switch statement

			switch (menuChoice) {
			case 1 -> kernelOptions();						//begin program
			case 2 -> {										//quit
				System.out.println("Shutting down");
				System.exit(menuChoice);
				;
			}

			default -> {									// Guarantee functionality, loop back to menu if neither 1 or 2 selected
				System.out.println("Invalid input: Please select from option 1-2");
				TimeUnit.SECONDS.sleep(2);
				mainMenu();
			}
			}
		}
	}

	private void showOptions() {
		System.out.println(ConsoleColour.GREEN_BOLD_BRIGHT);
		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*           Image Filtering System V0.1           *");
		System.out.println("*     H.Dip in Science (Software Development)     *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");

		System.out.println("1) Image Editor");
		System.out.println("2) Quit");
		System.out.println("\nSelect Option [1-2]>");
		System.out.println(ConsoleColour.RESET);
	}

	public void kernelOptions() throws Exception {		//how to access kernelChoiceOption when it is in another class
		ImageEditor ie = new ImageEditor();
		ie.kernelChoiceOption();
	}

}