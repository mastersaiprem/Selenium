package thrymr.linkedin;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Linked_test {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
		
	 System.setProperty("webdriver.chrome.driver","/home/thrymr/Desktop/chromedriver");
	
	 String downloadFilepath = "/home/thrymr/Desktop/linkedinfolder/";

	  HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

	  chromePrefs.put("profile.default_content_settings.popups", 0);

	  chromePrefs.put("download.default_directory", downloadFilepath);

	  ChromeOptions options = new ChromeOptions();

	  HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();

	  options.setExperimentalOption("prefs", chromePrefs);

	  options.addArguments("--test-type");

	  DesiredCapabilities cap = DesiredCapabilities.chrome();

	  cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);

	  cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

	  cap.setCapability(ChromeOptions.CAPABILITY, options);   
	  
	 WebDriver driver = new ChromeDriver(cap);
	
	
	driver.manage().window().maximize();
	driver.get("https://www.linkedin.com/");
	String Username = "khare.rishi@gmail.com";
	String Password = "Thrymr@123";
	
	Action.login(Username, Password, driver);
	Action.GetJobs(driver);
	
	}
	

}
