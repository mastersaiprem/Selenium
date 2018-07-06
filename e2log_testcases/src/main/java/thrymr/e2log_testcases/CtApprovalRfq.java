package thrymr.e2log_testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CtApprovalRfq {
  private static  WebDriver driver;
  private String baseUrl;
  private static boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver","/home/thrymr/Desktop/chromedriver");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	
    baseUrl = "http://ci.thrymr.net:2018";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCtApprovalRfq() throws Exception {
    driver.get(baseUrl + "/ct/login");
    assertEquals(driver.getTitle(), "e2log");
   // driver.findElement(By.xpath("//input[@type='email']")).clear();
    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("e2log@thrymr.net");
   // driver.findElement(By.xpath("//input[@type='Password']")).clear();
    driver.findElement(By.xpath("//input[@type='Password']")).sendKeys("e2Log@123");
    driver.findElement(By.cssSelector("button.rfqPrintBtn")).click();
    driver.findElement(By.xpath("//a[@href='/ct/waiting-rfqs']")).click();
    driver.findElement(By.xpath("//input[@placeholder='RFQ ID']")).sendKeys("55-118");
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button.btn.rfqPrintBtn")).click();
    WebElement element = driver.findElement(By.cssSelector("button.apporveButton"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",element);
    driver.findElement(By.cssSelector("button.apporveButton")).click();
   driver.findElement(By.cssSelector("button.btn.btn-success")).click();
   Thread.sleep(5000);
 driver.findElement(By.xpath("(//*[@class='btn btn-success'])[1]")).click();
   
    
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
//    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
      
    }
  }

  private static boolean isElementPresent(By by) {
    try {
    		System.out.println("test1");
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private static  boolean isAlertPresent() {
    try {
    	System.out.println("test2");
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
  
  
  
  private static String closeAlertAndGetItsText() {
    try {
    	System.out.println("test3");
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
