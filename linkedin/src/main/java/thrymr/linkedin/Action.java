package thrymr.linkedin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {
	static String no_of_applicants;
	private static final String FILE_HEADER = "Name,Mobilenumber,Email,Experianance,Linkedin_link";
	public static File file = new File("/home/thrymr/Desktop/LinkedinDATA/ApplicantsResume.xlsx");

	public static void login(String Username, String Password, WebDriver driver) {
		WaitForElementVisible(driver, By.xpath("//input[@id='login-email']"));
		driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@id='login-submit']")).click();
		Excellsample.checkfile(file);
	}

	public static void GetJobs(WebDriver driver) throws Exception {
		WaitForElementVisible(driver, By.xpath("(//span[contains(.,'Jobs')])[1]"));
		driver.findElement(By.xpath("(//span[contains(.,'Jobs')])[1]")).click();
		WaitForElementVisible(driver,
				By.xpath("//a[@href='https://www.linkedin.com/job/cap/manage/list?trk=flagship3_job_home']"));
		driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/job/cap/manage/list?trk=flagship3_job_home']"))
				.click();
		WaitForElementVisible(driver, By.xpath("//a[contains(.,'applicants')]"));
		no_of_applicants = driver.findElement(By.xpath("(//*[@class='pipeline__count'])[1]")).getText();
		int applicants_number = Integer.parseInt(no_of_applicants);
		driver.findElement(By.xpath("//a[contains(.,'applicants')]")).click();
		WaitForElementVisible(driver, By.xpath("//ol[@class='profile-list']"));
		driver.findElement(By.xpath("(//ol[@class='profile-list']//figure)[1]")).click();
		Thread.sleep(4000);
		getdata(driver, applicants_number);
	}

	public static void getdata(WebDriver driver, int applicants_number) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		

		try {
			System.out.println(applicants_number);
			
			for (int l = 0; l < 320; l++) {

				WaitForElementVisible(driver, By.xpath("(//header[@class='topcard-condensed ember-view']//h3)[2]"));
				String applicant_name = driver
						.findElement(By.xpath("(//header[@class='topcard-condensed ember-view']//h3)[2]")).getText();
				System.out.println(applicant_name);
				
				if(Excellsample.checkName(applicant_name, file.toString()))
						{
					System.out.println("ifffffffff");
					WaitForElementVisible(driver, By.xpath("(//span[contains(.,'Next')])[3]"));
					driver.findElement(By.xpath("(//span[contains(.,'Next')])[3]")).click();
				}
			
				else {
				String fileStatus ="";
					try {
				Thread.sleep(2000);
				WebElement Download_link = driver.findElement(By.xpath("//*[@class='candidate-info__body']//span[contains(text(),'Download')]"));
				Download_link.click();
				fileStatus = "file found";
				
				}
				
				catch (Exception e) {
					System.out.println("file not found");
					fileStatus = "file not found";
				}
//				
				String email = "";
				try {
					WebElement emailElement = driver.findElement(By.xpath("(//*[@class='contact-info__list'])[1]"));
					List<WebElement> email_list = emailElement.findElements(By.className("contact-info__method"));
					for (int i = 0; i < email_list.size(); i++) {
//						System.out.println(email_list.get(i).getText());
						email += email_list.get(i).getText() + "\n";

					}
				} catch (Exception e) {
					email += "not found" + "\n";
				}
//				Excellsample.writeXLSXFile(l, 1, email, file.toString(), "Sheet1");

				String mob = "";
				try {
					WebElement mobileElement = driver
							.findElement(By.xpath("(//*[@class='contact-info__list'])[2]//li"));
					List<WebElement> mobilenumber = mobileElement.findElements(By.className("contact-info__method"));

					for (int j = 0; j < mobilenumber.size(); j++) {
//						System.out.println(mobilenumber.get(j).getText());
						mob += mobilenumber.get(j).getText() + "\n";
					}
				} catch (Exception e) {
					mob += "not found" + "\n";
				}
//				Excellsample.writeXLSXFile(l, 2, mob, file.toString(), "Sheet1");

				String experince = "";
				try {
					WebElement Experience = driver
							.findElement(By.xpath("(//*[@class='expandable-list__list background-section__list'])[1]"));
					List<WebElement> ExperienceList = Experience.findElements(By.tagName("li"));
					for (int k = 0; k < ExperienceList.size(); k++) {

//						System.out.println(ExperienceList.get(k).getText());
						experince += ExperienceList.get(k).getText() + "\n";
					}
				} catch (Exception e) {
					e.printStackTrace();
					experince += "not found" + "\n";
				}
//				Excellsample.writeXLSXFile(l, 3, experince, file.toString(), "Sheet1");
				Thread.sleep(5000);
				WebElement element1 = driver.findElement(By.xpath("//*[@class='personal-info__link']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element1);
				String Linkedin_link = element1.getText();
				System.out.println(Linkedin_link);
				////*[@id="ember2842"]/div/a
		
//				Excellsample.writeXLSXFile(l, 4, Linkedin_link, file.toString(), "Sheet1");
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//span[contains(.,'Next')])[3]")).click();
				Excellsample.writeXLSXFile(applicant_name,email,mob,experince,Linkedin_link,fileStatus,file.toString());
				
				
//				Actions s=new Actions(driver);
//				s.moveByOffset(10, -50).build().perform();
				driver.navigate().refresh();
				Thread.sleep(3000);
				
			}
		}	

		
		} catch (Exception e) {
			System.out.println("filed in main loop");
		}

	}

	public static void scroll_up(WebDriver driver, WebElement Download_link) {
		WebElement sup=driver.findElement(By.xpath("//*[@id=\"ember2751\"]/div"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", sup);
	}

	public static void WaitForElementVisible(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public static void WaitForAlertPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	
}
