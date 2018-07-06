package thrymr.e2log_testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class QuoteApprove {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://ci.thrymr.net:2018/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testQuoteApprove() throws Exception {
    driver.get(baseUrl + "/ct/login");
    assertEquals(driver.getTitle(), "e2log");
    driver.findElement(By.xpath("//input[@type='email']")).clear();
    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("e2log@thrymr.net");
    driver.findElement(By.xpath("//input[@type='Password']")).clear();
    driver.findElement(By.xpath("//input[@type='Password']")).sendKeys("e2Log@123");
    driver.findElement(By.cssSelector("button.rfqPrintBtn")).click();
    driver.findElement(By.cssSelector("li.collapsed.ng-star-inserted > a > span > a")).click();
    driver.findElement(By.cssSelector("button.btn.rfqPrintBtn")).click();
    driver.findElement(By.cssSelector("button.apporveButton.ng-star-inserted")).click();
    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
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
