package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomKernel {

	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private double sum;

	public double[][] kernelSelector() throws NumberFormatException, IOException {

		System.out.println("Please select the order of the kernel you wish to use.");
		int kernelOrder = Integer.parseInt(reader.readLine());		//Takes user input for kernel order
		double[][] userKernel = new double[kernelOrder][kernelOrder];		//Creates empty kernel of size order by order

		System.out.println("For best filter results, please ensure the sum of matrix entries equals 0");

		for (int x = 0; x < kernelOrder; x++)
			for (int y = 0; y < kernelOrder; y++) {
				System.out.println(x + "," + y + ":");
				userKernel[x][y] = Double.parseDouble(reader.readLine()); //Allows user input to fill empty kernel

			}
		System.out.println("The Kernel order is:");

		for (int x = 0; x < kernelOrder; x++) {
			for (int y = 0; y < kernelOrder; y++) {
				System.out.println("\t" + userKernel[x][y]);  //Displays the list of the kernel elements

			}
		}
		return userKernel;

	}
}
