package thrymr.e2log_testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Filereading {

		public static void FileRead() {
			Properties prop = new Properties();
			InputStream input = null;

			try {

				input = new FileInputStream("mail.properties");

				prop.load(input);

				// get the property value and print it out
				System.out.println(prop.getProperty("username"));
				System.out.println(prop.getProperty("password"));
				
			} catch (IOException ex) {
	
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}

		public static void main(String[] args) {
			WebDriver driver;
		
		}
	

	
}
