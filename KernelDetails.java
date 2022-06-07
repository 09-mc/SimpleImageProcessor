package ie.gmit.dip;

import java.util.Scanner;

public class KernelDetails {

	private Scanner s;
	
	public double[][] setUserKernel(double[][] userKernel) {

		s = new Scanner(System.in);			//Take in input from menu and match the int entered with the case below
		String input = s.next();
		int choice = Integer.parseInt(input);

		try {
			switch (choice) {			
			case 1:
				userKernel = Kernels.IDENTITY;
				break;
			case 2:
				userKernel = Kernels.EDGE_DETECTION_1;
				break;
			case 3:
				userKernel = Kernels.EDGE_DETECTION_2;
				break;
			case 4:
				userKernel = Kernels.LAPLACIAN;
				break;
			case 5:
				userKernel = Kernels.SHARPEN;
				break;
			case 6:
				userKernel = Kernels.VERTICAL_LINES;
				break;
			case 7:
				userKernel = Kernels.HORIZONTAL_LINES;
				break;
			case 8:
				userKernel = Kernels.DIAGONAL_45_LINES;
				break;
			case 9:
				userKernel = Kernels.BOX_BLUR;
				break;
			case 10:
				userKernel = Kernels.SOBEL_HORIZONTAL;
				break;
			case 11:
				userKernel = Kernels.SOBEL_VERTICAL;
				break;
			case 12: {
				Menu menu = new Menu();
				menu.mainMenu();
			}
			default:
				System.out.println("Invalid input");
				Menu menu = new Menu();
				menu.mainMenu();

			}
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
		return userKernel;
	}

	public void showKernelOptions() {
		System.out.println(ConsoleColour.GREEN_BOLD_BRIGHT);		//Menu Colour
		System.out.println("******************************************************************************");
		System.out.println("**************** Please select from the below list of filters ****************");
		System.out.println("******************************************************************************");
		System.out.println("1) Identity              2) Edge detection 1              3) Edge detection 2");
		System.out.println("");
		System.out.println("4) Laplacian             5) Sharpen                       6) Vertical Lines");
		System.out.println("");
		System.out.println("7) Horizontal Lines      8) Diagonal 45 lines             9) Box blur");
		System.out.println("");
		System.out.println("10) Sobel horizontal     11) Sobel vertical               12) Main Menu");
		System.out.println("******************************************************************************");
		System.out.println(ConsoleColour.RESET);					//Reset colour to standard

	}

}
