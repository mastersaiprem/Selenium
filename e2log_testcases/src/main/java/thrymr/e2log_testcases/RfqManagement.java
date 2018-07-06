package thrymr.e2log_testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RfqManagement {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver","/home/thrymr/Desktop/chromedriver");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://ci.thrymr.net:2018/");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRfqManagement() throws Exception {
    driver.get(baseUrl + "/customer");
    assertEquals(driver.getTitle(), "e2log");
    driver.findElement(By.xpath("//input[@type='email']")).clear();
    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("suryajyotibisen09@gmail.com");
    driver.findElement(By.xpath("//input[@type='Password']")).clear();
    driver.findElement(By.xpath("//input[@type='Password']")).sendKeys("e2loG@123");
    driver.findElement(By.cssSelector("button.rfqPrintBtn.btn")).click();
    driver.findElement(By.linkText("RFQ's")).click();
    driver.findElement(By.xpath("//a[contains(@href, '/customer/quotations/allquotations')]")).click();
    driver.findElement(By.xpath("//button")).click();
    driver.findElement(By.xpath("//button[@value='20']")).click();
    driver.findElement(By.linkText("Quotes Shortlist")).click();
    driver.findElement(By.name("singlebutton")).click();
    driver.findElement(By.cssSelector("button.btnpicker.btnpickerenabled")).click();
    driver.findElement(By.cssSelector("span.markcurrday")).click();
    driver.findElement(By.cssSelector("my-date-picker[name=\"eDate\"] > div.mydp > div.selectiongroup.ng-star-inserted > div.selbtngroup > button.btnpicker.btnpickerenabled")).click();
    driver.findElement(By.xpath("//div[@id='myModal']/div/div/div[2]/form/div/div[3]/div/my-date-picker/div/div[2]/table[2]/tbody/tr[4]/td[4]/div")).click();
    driver.findElement(By.name("sub")).click();
    driver.findElement(By.linkText("Optimize Quotes")).click();
    driver.findElement(By.linkText("LSP Wise")).click();
    driver.findElement(By.linkText("Lowest Cost/ Duration/ Customised")).click();
    driver.findElement(By.linkText("LSP Wise")).click();
    driver.findElement(By.linkText("Recommended")).click();
    driver.findElement(By.linkText("Lowest Cost/ Duration/ Customised")).click();
    driver.findElement(By.linkText("LSP Wise")).click();
    driver.findElement(By.id("termsAndConditons1")).click();
    driver.findElement(By.cssSelector("label.md-checkbox2.mar-top-18 > span.checkmark")).click();
    driver.findElement(By.xpath("//div[@id='LSPWISE']/div[4]/div/div[3]/div[2]/button")).click();
    driver.findElement(By.linkText("Pre-Award")).click();
    driver.findElement(By.cssSelector("div.form-group.col-md-4 > my-date-picker[name=\"sdate\"] > div.mydp > div.selectiongroup.ng-star-inserted > div.selbtngroup > button.btnpicker.btnpickerenabled")).click();
    driver.findElement(By.xpath("//div[@id='PA']/app-customer-pre-award/div[2]/div[2]/my-date-picker/div/div[2]/table[2]/tbody/tr[4]/td[4]/div")).click();
    driver.findElement(By.cssSelector("div.col-md-4 > label.md-checkbox2.margin-top-10 > input[type=\"checkbox\"]")).click();
    driver.findElement(By.cssSelector("div.col-md-4 > label.md-checkbox2.margin-top-10 > span.checkmark")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[15]")).click();
    driver.findElement(By.linkText("Shipments")).click();
    driver.findElement(By.cssSelector("li.ng-star-inserted > a > span")).click();
    driver.findElement(By.cssSelector("span.hidden-xs.text-uppercase")).click();
    driver.findElement(By.linkText("Sign out")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
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
