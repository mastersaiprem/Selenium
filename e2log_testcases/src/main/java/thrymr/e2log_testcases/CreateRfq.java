package thrymr.e2log_testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateRfq {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  public static String RFQ_ID;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver","/home/thrymr/Desktop/chromedriver");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
    baseUrl = "http://ci.thrymr.net:2018/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateRfq() throws Exception {
    driver.get(baseUrl + "/");
    assertEquals(driver.getTitle(), "e2log");
    driver.findElement(By.cssSelector("button.btn.btn-readMore")).click();
  //  driver.findElement(By.xpath("//input[@type='email']")).clear();
  //  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("suryajyoti.bisen09@gmail.com");
    //driver.findElement(By.xpath("//input[@type='Password']")).clear();
  
//    driver.findElement(By.cssSelector("button.rfqPrintBtn.btn")).click();
//    driver.findElement(By.xpath("//input[@type='email']")).click();
//    driver.findElement(By.xpath("//input[@type='email']")).click();
//    driver.findElement(By.xpath("//input[@type='email']")).clear();
    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("suryajyotibisen09@gmail.com");
    driver.findElement(By.xpath("//input[@type='Password']")).sendKeys("e2loG@123");
    driver.findElement(By.cssSelector("button.rfqPrintBtn.btn")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//a[@href= '/customer/quotations/rfq']")).click();
    driver.findElement(By.xpath("//option[@value='3: CAD']")).click();
    new Select(driver.findElement(By.name("currency"))).selectByVisibleText("HKD");
    driver.findElement(By.xpath("//option[@value='9: HKD']")).click();
    driver.findElement(By.xpath("//input[@type='text']")).click();
    driver.findElement(By.xpath("//input[@type='text']")).clear();
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Rfq1");
  
//    driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("tester");
//    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("tester@gmail.com");
  //  driver.findElement(By.xpath("//textarea[@type='text']")).clear();
    driver.findElement(By.cssSelector("button.btnpicker.btnpickerenabled")).click();
    driver.findElement(By.xpath("//div[@id='home']/div/form/div[3]/div/div/div[2]/div/my-date-picker/div/div[2]/table[2]/tbody/tr[4]/td[4]/div")).click();
    driver.findElement(By.xpath("//textarea[@type='text']")).sendKeys("");
    new Select(driver.findElement(By.id("contactPersonMobileCountry"))).selectByVisibleText("India (+91)");
   // driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("5634634634");
    new Select(driver.findElement(By.id("officeLandNumberCountry"))).selectByVisibleText("India (+91)");
   // driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("5235235");
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)", "");
    driver.findElement(By.cssSelector("div.c-btn")).click();
    driver.findElement(By.xpath("//div[@id='home']/div/form/div[3]/div/div[4]/div[2]/div/angular2-multiselect/div/div[2]/div[3]/div/label")).click();
    driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).click();
    driver.findElement(By.xpath("//span[text()='Through e2log']")).click();
	driver.findElement(By.xpath("//span[@class = 'checkmark']")).click();
	jse.executeScript("window.scrollBy(0,250)", "");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    new Select(driver.findElement(By.id("state"))).selectByVisibleText("Open Yard");
    driver.findElement(By.cssSelector("button.btnpicker.btnpickerenabled")).click();
    driver.findElement(By.xpath("//tr[4]/td[5]/div/span")).click();
    new Select(driver.findElement(By.name("deliveryLocation"))).selectByVisibleText("Quay Side");
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    driver.findElement(By.xpath("//tr[4]/td[6]/div")).click();
    new Select(driver.findElement(By.id("pickupCountryId"))).selectByVisibleText("American Samoa");
    driver.findElement(By.xpath("//option[@value='5']")).click();
    new Select(driver.findElement(By.id("pickupStateId"))).selectByVisibleText("Swains Island");
    driver.findElement(By.xpath("(//option[@value='139'])[2]")).click();
    new Select(driver.findElement(By.id("deliveryCountryId"))).selectByVisibleText("American Samoa");
    new Select(driver.findElement(By.id("deliveryStateId"))).selectByVisibleText("Western District");
    driver.findElement(By.xpath("(//option[@value='140'])[6]")).click();
    new Select(driver.findElement(By.id("pickupCityId"))).selectByVisibleText("Taulaga");
    driver.findElement(By.xpath("//input[@type='text']")).clear();
    driver.findElement(By.xpath("//input[@type='text']")).sendKeys("452453534");
    new Select(driver.findElement(By.id("deliveryCityId"))).selectByVisibleText("Malaeloa/Aitulagi");
    driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("346346346");
    driver.findElement(By.xpath("//textarea[@type='text']")).clear();
    driver.findElement(By.xpath("//textarea[@type='text']")).sendKeys("dfhdfhdfh");
    driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).click();
    driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).clear();
    driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).sendKeys("fdhdfhdfh");
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("dfhdfh");
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("fdhdf@fgh.fgh");
    driver.findElement(By.xpath("(//input[@type='text'])[6]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("dfhdfhf");
    driver.findElement(By.xpath("(//input[@type='text'])[7]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("dgsdg@ghg.hh");
    driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("64634634");
    driver.findElement(By.xpath("//input[@type='number']")).clear();
    driver.findElement(By.xpath("//input[@type='number']")).sendKeys("34634634");
    driver.findElement(By.xpath("(//input[@type='text'])[8]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("34634634");
    driver.findElement(By.name("deliveryMobileNumber")).clear();
    driver.findElement(By.name("deliveryMobileNumber")).sendKeys("346346346");
	jse.executeScript("window.scrollBy(0,250)", "");
    driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
	jse.executeScript("window.scrollBy(0,250)", "");
  //  driver.findElement(By.cssSelector("span.checkmark")).click();
    driver.findElement(By.cssSelector("my-date-picker[name=\"internationalTransitCommencementDate\"] > div.mydp > div.selectiongroup.ng-star-inserted > div.selbtngroup > button.btnpicker.btnpickerenabled")).click();
    driver.findElement(By.xpath("//tr[4]/td[5]/div")).click();

   // driver.findElement(By.id("isPartialQuoteAllowed")).click();
    driver.findElement(By.xpath("//*[text()='Yes']")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
   Thread.sleep(2000);
    driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("3434");
//    driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
//    driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("346436");
//    driver.findElement(By.xpath("(//input[@type='text'])[3]")).click();
//    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("525");
    driver.findElement(By.xpath("//input[@type='tel']")).click();
  //  driver.findElement(By.xpath("//input[@type='tel']")).clear();
    driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("235235");
   // driver.findElement(By.xpath("//input[@type='number']")).clear();
    driver.findElement(By.xpath("//input[@type='number']")).sendKeys("32523");
    new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText("LB");
    driver.findElement(By.xpath("(//input[@type='number'])[2]")).click();
  //  driver.findElement(By.xpath("(//input[@type='number'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys("325");
 //   driver.findElement(By.xpath("(//input[@type='number'])[3]")).clear();
    driver.findElement(By.xpath("(//input[@type='number'])[3]")).sendKeys("35");
   // driver.findElement(By.xpath("(//input[@type='number'])[4]")).clear();
    driver.findElement(By.xpath("(//input[@type='number'])[4]")).sendKeys("35");
    new Select(driver.findElement(By.xpath("//div[2]/div[2]/select"))).selectByVisibleText("CM");
    new Select(driver.findElement(By.xpath("//div[3]/select"))).selectByVisibleText("Class 2");
    new Select(driver.findElement(By.xpath("//div[4]/select"))).selectByVisibleText("Old");
    jse.executeScript("window.scrollBy(0,250)", "");
    driver.findElement(By.xpath("//*[text()='Temporary Export']")).click();
   // driver.findElement(By.cssSelector("span.label-text")).click();
    driver.findElement(By.xpath("//*[text()='Permanent Import']")).click();
    driver.findElement(By.xpath("//button[contains(.,'NEXT')]")).click();
    driver.findElement(By.id("info")).click();
 //   driver.findElement(By.id("info")).clear();
    driver.findElement(By.id("info")).sendKeys("gsdgdsgd fhfh fhfh fhhfh");
    driver.findElement(By.id("1")).click();
    driver.findElement(By.id("5")).click();
    driver.findElement(By.id("2")).click();
    driver.findElement(By.id("6")).click();
    driver.findElement(By.id("3")).click();
    driver.findElement(By.id("7")).click();
    driver.findElement(By.id("11")).click();
    driver.findElement(By.id("12")).click();
    driver.findElement(By.id("14")).click();
    driver.findElement(By.id("19")).click();
    driver.findElement(By.id("10")).click();
    driver.findElement(By.id("18")).click();
	jse.executeScript("window.scrollBy(0,250)", "");

    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
    WebElement element = driver.findElement(By.xpath("//button[contains(.,'BACK')]"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",element);
    driver.findElement(By.xpath("(//input[@type='checkbox'])[11]")).click();
   // driver.findElement(By.cssSelector("span.checkmark")).click();
    driver.findElement(By.xpath("//form[@id='form']/div[2]/div/button[3]")).click();
    RFQ_ID = driver.findElement(By.xpath("(//*[@class='bluetext'])[1]")).getText();
    System.out.println("RFQ id:"+RFQ_ID);
    Thread.sleep(7000);
    driver.findElement(By.xpath("(//*[@data-toggle='dropdown'])[3]")).click();
    driver.findElement(By.linkText("Sign out")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
  //  driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
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
