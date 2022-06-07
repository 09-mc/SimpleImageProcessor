package ie.gmit.dip;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FileSource {
	
	private Scanner s;
	private String text;
	private File f;
	private String url;

	public File setInputFile() {
		System.out.println();
		System.out.println("Please enter the file name that you wish to use: ");
		Scanner s = new Scanner(System.in);
		String fileName = s.next();
		File f = new File(fileName);
		return f;
	}

	public File getInputFile() throws InterruptedException {
		try {
			setInputFile();
		} catch (Exception e) {
			System.out.println();
			System.out.println("Cannot find the URL file. Please retry.");
			System.out.println();
			TimeUnit.SECONDS.sleep(2);
			getInputFile();
		}
		return f;
	}

	public File setUrlPath() throws IOException {
		System.out.println();
		System.out.println("Please enter the URL that you wish to use: ");
		Scanner s = new Scanner(System.in);
		url = s.next();
		URL urlPath = new URL(url);
		InputStream in = urlPath.openStream();
		Scanner sc = new Scanner(in).useDelimiter("\\A");
		String result = sc.hasNext() ? sc.next() : "";
		File f = new File(result);
		return f;
	}

	public File getUrlPath() throws Exception {
		try {
			setUrlPath();
		} catch (Exception e) {
			System.out.println();
			System.out.println("Cannot find the URL file. Please retry.");
			System.out.println();
			TimeUnit.SECONDS.sleep(2);
			getUrlPath();
		}
		return f;
	}
	
	public void urlOrLocalMenu() {
		System.out.println();
		System.out.println("1) Local File location");
		System.out.println("2) URL File Location");
		System.out.println("3) Quit");
		System.out.println("\nSelect Option [1-3]>");
		System.out.println();
		}
		
		public void urlOrLocalMenuOptions() throws Exception {
			urlOrLocalMenu();
			s = new Scanner(System.in);
			int menuChoice = Integer.parseInt(s.next()); // Take in int from user to determine switch statement

			switch (menuChoice) {
			case 1:
				getInputFile();
				
				break;		    
			case 2:
				getUrlPath();
				
				break;
			case 3: {
				System.out.println("Shutting down");
				System.exit(menuChoice);
				;
			}

			default: {
				System.out.println("Invalid input: Please select from option 1-4");
				TimeUnit.SECONDS.sleep(2);
				urlOrLocalMenuOptions();
			}
			}
		}

}
