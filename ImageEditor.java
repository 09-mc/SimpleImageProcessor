package ie.gmit.dip;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

public class ImageEditor {

	private Scanner s;
	private double[][] userKernel;
	private boolean keepRunning;
	private String inputPath;
	private BufferedImage image;

	public File bufferedImageEditor() throws Exception {

		try {
			System.out.println("Please wait while your picture is filtered...");
			int width = image.getWidth();						
			int height = image.getHeight();											//Get the width/height of image for creating output
			BufferedImage output = new BufferedImage(width, height, image.getType()); //output image will be input width/height with colour amendments

			double[][] imageArray = new double[width][height]; // create 2d array width by height size
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					imageArray[x][y] = image.getRGB(x, y); //loop over and enter in the RGB of each pixel into the 2d array
				}
			}

			for (int x = 0; x < imageArray.length; x++) {
				for (int y = 0; y < imageArray[height].length; y++) {  //looping over the image array

					double red = 0.0, green = 0.0, blue = 0.0;    //set accumulators to zero

					for (int i = 0; i < userKernel.length; i++) {
						for (int j = 0; j < userKernel[i].length; j++) {  // looping over kernels

							int imageX = (x - userKernel.length / 2 + i + imageArray.length) % imageArray.length;
							int imageY = (y - userKernel[i].length / 2 + j + imageArray[height].length)
									% imageArray[height].length;  //code to wrap image around so that edge pixels use the other edge for calculation

							int RGB = image.getRGB(imageX, imageY); //Get RGB of single pixel 
							int r = (RGB >> 16) & 0xff;				//Separate into different colour channels
							int g = (RGB >> 8) & 0xff;
							int b = (RGB) & 0xff;

							red += (r * userKernel[i][j]);			//Multiply each colour channel with the kernel, add the sums to the accumulator
							green += (g * userKernel[i][j]);
							blue += (b * userKernel[i][j]);

						}
					}

					int filterRed, filterGreen, filterBlue;

					filterRed = Math.min(Math.max((int) (red), 0), 255);  //Ensures accumulator is between 0 & 255
					filterGreen = Math.min(Math.max((int) (green), 0), 255);
					filterBlue = Math.min(Math.max((int) (blue), 0), 255);

					output.setRGB(x, y, new Color(filterRed, filterGreen, filterBlue).getRGB()); 
					//sets the pixel colour to the combination of accumulators 
					//loops back through all pixels
				}
			}
			System.out.println("Please enter filtered picture name:"); //Allows user to specify output name
			String outputName = s.next();
			ImageIO.write(output, "png", new File(outputName + ".png"));
			System.out.println("Your image has been filtered.");
			TimeUnit.SECONDS.sleep(2);
			menuMain();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void menuMain() throws Exception {	//Allows calling main menu in this class
		Menu m = new Menu();
		m.mainMenu();
	}

	public void kernelOptions() throws Exception {	//Allows calling kernel options in this class
		KernelDetails kd = new KernelDetails();
		kd.showKernelOptions();
	}

	public double[][] getUserKernel() {			//Calls user kernel and brings userKernel variable across from another class
		KernelDetails kd = new KernelDetails();
		userKernel = kd.setUserKernel(userKernel);
		return userKernel;
	}

	public double[][] userChoiceKernel() throws NumberFormatException, IOException {
		CustomKernel ck = new CustomKernel();		//Calls created kernel and brings userKernel variable across from another class
		userKernel = ck.kernelSelector();
		return userKernel;
	}

	public BufferedImage setUrlPath() throws MalformedURLException {
		System.out.println("Please enter the URL of the picture you wish to edit");
		Scanner s = new Scanner(System.in);		//Setter to create buffered image from URL
		String inputPath = s.next();
		URL URLPath = new URL(inputPath);
		try {
			image = ImageIO.read(URLPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	public BufferedImage getUrlPath() throws IOException, InterruptedException {//Getter to create buffered image from URL
		try {
			setUrlPath();
		} catch (Exception e) {
			System.out.println(ConsoleColour.RED_BOLD);
			System.out.println("Cannot find the URL image. Please retry.");
			System.out.println(ConsoleColour.RESET);
			TimeUnit.SECONDS.sleep(2);
			getUrlPath();
		}
		return image;
	}

	public String setLocalPath() {		//Allow user input for the picture path (setter here/getter below)
		System.out.println("Please enter the path to the picture you wish to edit.");
		Scanner s = new Scanner(System.in);
		String inputPath = s.next();
		return inputPath;
	}

	public BufferedImage getLocalPath() throws IOException, InterruptedException {
		try {
			ImageEditor ie = new ImageEditor();
			inputPath = ie.setLocalPath();
			File f = new File(inputPath);
			image = ImageIO.read(new FileInputStream(f));
		} catch (Exception e) {
			System.out.println(ConsoleColour.RED_BOLD);
			System.out.println("Cannot find the selected image. Please retry.");
			System.out.println(ConsoleColour.RESET);
			TimeUnit.SECONDS.sleep(2);
			getLocalPath();
		}
		return image;

	}

	public void localOrURL() throws Exception {  //Menu and switch statement for choice between local or URL
		System.out.println(ConsoleColour.GREEN_BOLD_BRIGHT);
		System.out.println("******************************************************************************");
		System.out.println("*********************************Local or URL*********************************");
		System.out.println("******************************************************************************");
		System.out.println("                            1) Local picture								  ");
		System.out.println("                            2) Enter URL									  ");
		System.out.println("                                                                              ");
		System.out.println("******************************************************************************");
		System.out.println(ConsoleColour.RESET);

		Scanner s = new Scanner(System.in);
		int choice = Integer.parseInt(s.next());
		switch (choice) {
		case 1:
			getLocalPath();
			break;
		case 2:
			getUrlPath();
			break;

		default: {
			System.out.println("Invalid input: Please select from option 1-2");
			TimeUnit.SECONDS.sleep(2);
			localOrURL();
		}
		}
		bufferedImageEditor();
	}

	public void kernelChoiceOption() throws Exception { //Menu and switch statement for choice between pre-loaded or user created filter
		System.out.println(ConsoleColour.GREEN_BOLD_BRIGHT);
		System.out.println("******************************************************************************");
		System.out.println("******************************* Filter Options *******************************");
		System.out.println("******************************************************************************");
		System.out.println("                            1) Pre-loaded filters							  ");
		System.out.println("                            2) Create your own filter						  ");
		System.out.println("******************************************************************************");

		while (keepRunning = true) {
			s = new Scanner(System.in);
			int kernelChoice = Integer.parseInt(s.next());

			switch (kernelChoice) {
			case 1:
				kernelOptions();
				getUserKernel();
				break;
			case 2:
				userChoiceKernel();
				break;

			default: {
				System.out.println(ConsoleColour.RED_BOLD);
				System.out.println("Invalid input: Please select from option 1-2");
				System.out.println(ConsoleColour.RESET);
				TimeUnit.SECONDS.sleep(2);
				menuMain();
				keepRunning = true;
			}
			}
			localOrURL();
			keepRunning = false;
		}
	}
}