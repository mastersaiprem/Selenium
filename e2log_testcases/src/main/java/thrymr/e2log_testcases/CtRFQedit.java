package thrymr.e2log_testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CtRFQedit {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/thrymr/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl = "http://ci.thrymr.net:2018/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testFirstTestcase() throws Exception {
		driver.get(baseUrl + "/ct/login");
		assertEquals(driver.getTitle(), "e2log");
		driver.findElement(By.xpath("//input[@type='email']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).clear();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("e2log@thrymr.net");
		driver.findElement(By.xpath("//input[@type='Password']")).clear();
		driver.findElement(By.xpath("//input[@type='Password']")).sendKeys("e2Log@123");
		driver.findElement(By.cssSelector("button.rfqPrintBtn")).click();
		driver.findElement(By.linkText("RFQs")).click();
		driver.findElement(By.xpath("//div[@id='quotation-requests']/div/table/tbody/tr[2]/td[6]/button")).click();
		driver.findElement(By.name("singlebutton")).click();
		driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).clear();
		driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).sendKeys(
				"Dummy Comments for testing the application Huijjj l;sdffjfkdjk klfjk df \nfojfkjdf'df\ndffkhdk;fhkhfjfkjfdf\nfkdkfjklasfdfdjfhdjsfhjdf df\ndfhjdfhjd fj dfh df fsjkdfhasf");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.cssSelector("button.apporveButton")).click();
		driver.findElement(By.cssSelector("button.btn.btn-success")).click();
		driver.findElement(By.xpath("//div[@id='toast-container']/div/div")).click();
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