package thrymr.e2log_testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RFQDraftsaving {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private static WebElement element;
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver", "/home/thrymr/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl = "http://ci.thrymr.net:2018/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitled() throws Exception {

		driver.get(baseUrl + "/customer");
		assertEquals(driver.getTitle(), "e2log");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sai.prem@thrymr.net");
		driver.findElement(By.xpath("//input[@type='Password']")).sendKeys("e2loG@123");
		driver.findElement(By.cssSelector("button.rfqPrintBtn.btn")).click();
		driver.findElement(By.xpath("//a[@href= '/customer/quotations/rfq']")).click();
		Thread.sleep(1000);
//	    driver.findElement(By.xpath("//button")).click();
//		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Singapore to India");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("saiprem");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("geminiganeshan@pulihora.com");
		new Select(driver.findElement(By.id("contactPersonMobileCountry"))).selectByVisibleText("India (+91)");
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("65869523");
		new Select(driver.findElement(By.id("officeLandNumberCountry"))).selectByVisibleText("India (+91)");
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("798544654");
		driver.findElement(By.xpath("//button[@aria-label='Open Calendar']")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		driver.findElement(By.xpath("//div[@id='home']/div/form/div[3]/div/div/div[2]/div/my-date-picker/div/div[2]/table[2]/tbody/tr[2]/td[2]/div")).click();
		Scroll_down(driver);
		driver.findElement(By.cssSelector("div.c-btn")).click();
		driver.findElement(By.xpath(
				"//div[@id='home']/div/form/div[3]/div/div[4]/div[2]/div/angular2-multiselect/div/div[2]/div[3]/div"))
				.click();
		driver.findElement(By.xpath("//div[@id='home']/div/form/div[3]/div/div[4]/div[2]/div")).click();
		driver.findElement(By.xpath("//span[contains(.,'Through e2log')]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'checkmark')]")).click();
		Scroll_down(driver);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		new Select(driver.findElement(By.id("state"))).selectByVisibleText("Open Yard");
		driver.findElement(By.cssSelector("button.btnpicker.btnpickerenabled")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		driver.findElement(By.xpath("//tr[2]/td[3]/div")).click();
		new Select(driver.findElement(By.name("deliveryLocation"))).selectByVisibleText("Quay Side");
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		driver.findElement(By.xpath("//tr[3]/td[6]/div")).click();
		new Select(driver.findElement(By.id("pickupCountryId"))).selectByVisibleText("Singapore");
		new Select(driver.findElement(By.id("pickupStateId"))).selectByVisibleText("Singapore");
		driver.findElement(By.cssSelector("#pickupStateId > option.ng-star-inserted")).click();
		new Select(driver.findElement(By.id("deliveryCountryId"))).selectByVisibleText("India");
		new Select(driver.findElement(By.id("deliveryStateId"))).selectByVisibleText("Tamil Nadu");
		new Select(driver.findElement(By.id("deliveryCityId"))).selectByVisibleText("Chennai");
		new Select(driver.findElement(By.id("pickupCityId"))).selectByVisibleText("Singapore");
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("153626");
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("520058");
		driver.findElement(By.xpath("//textarea[@type='text']")).clear();
		driver.findElement(By.xpath("//textarea[@type='text']")).sendKeys("qwert");
		driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).clear();
		driver.findElement(By.xpath("(//textarea[@type='text'])[2]")).sendKeys("qwert");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("sai");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("sai@gmail.com");
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("prem");
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("prem@gmail.com");
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("125365");
		driver.findElement(By.xpath("//input[@type='number']")).clear();
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("6588985");
		driver.findElement(By.xpath("(//input[@type='text'])[8]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("9533622");
		driver.findElement(By.name("deliveryMobileNumber")).clear();
		driver.findElement(By.name("deliveryMobileNumber")).sendKeys("95656565");
		Thread.sleep(1000);
		Scroll_down(driver);		
		driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
		driver.findElement(By.cssSelector(
				"my-date-picker[name=\"internationalTransitCommencementDate\"] > div.mydp > div.selectiongroup.ng-star-inserted > div.selbtngroup > button.btnpicker.btnpickerenabled"))
				.click();
		driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		driver.findElement(By.xpath("//tr[3]/td[4]/div/span")).click();
		driver.findElement(By.xpath("//span[contains(text(),'No')]")).click();
		driver.findElement(By.xpath("//button[contains(.,'SAVE AS DRAFT')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='drafted']")).click();
		String RFQID =driver.findElement(By.xpath("//span[@class='theme-color fs-18'][1]")).getText();
		driver.findElement(By.xpath("//input[@type='text']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(RFQID);
		driver.findElement(By.xpath("//div/i")).click();
		driver.findElement(By.linkText("Edit RFQ")).click();
		Scroll_down(driver);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Scroll_down(driver);
		driver.findElement(By.cssSelector(
				"my-date-picker[name=\"internationalTransitCommencementDate\"] > div.mydp > div.selectiongroup.ng-star-inserted > div.selbtngroup > button.btnpicker.btnpickerenabled"))
				.click();
		driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
		driver.findElement(By.xpath("//tr[3]/td[2]")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='text']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("col");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("789123");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("5");
		driver.findElement(By.xpath("//input[@type='tel']")).clear();
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("12");
		driver.findElement(By.xpath("//input[@type='number']")).clear();
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("10");
		new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText("KG");
		driver.findElement(By.xpath("(//input[@type='number'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys("5");
		driver.findElement(By.xpath("(//input[@type='number'])[3]")).clear();
		driver.findElement(By.xpath("(//input[@type='number'])[3]")).sendKeys("5");
		driver.findElement(By.xpath("(//input[@type='number'])[4]")).clear();
		driver.findElement(By.xpath("(//input[@type='number'])[4]")).sendKeys("5");
		new Select(driver.findElement(By.xpath("//div[2]/div[2]/select"))).selectByVisibleText("M");
		new Select(driver.findElement(By.xpath("//div[3]/select"))).selectByVisibleText("Non DG");
		new Select(driver.findElement(By.xpath("//div[4]/select"))).selectByVisibleText("New");
		Scroll_down(driver);
		driver.findElement(By.xpath("//label[2]/span")).click();
		driver.findElement(By.xpath("//div[2]/div/div/label/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.rfqPrintBtn.as_marLF_15")).click();
		Thread.sleep(1000);
		System.out.println("1111111111111111");
		Scroll_down(driver);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);
		Scroll_down(driver);	
	    Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(.,'SAVE AS DRAFT')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='drafted']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(RFQID);
		driver.findElement(By.xpath("//div/i")).click();
		driver.findElement(By.linkText("Edit RFQ")).click();
		Scroll_down(driver);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Scroll_down(driver);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Scroll_down(driver);
		driver.findElement(By.cssSelector("button.rfqPrintBtn.as_marLF_15")).click();
		Scroll_down(driver);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Scroll_down(driver);
		driver.findElement(By.xpath("//span[@class='checkmark']")).click();
		driver.findElement(By.xpath("//button[contains(.,'SUBMIT')]")).click();
		
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
//		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	
	public static void Scroll_down(WebDriver driver ) {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {
			Thread.sleep(1000);
		element = driver.findElement(By.xpath("//button[contains(.,'SAVE AS DRAFT')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",element);
		}
		
		catch (Exception e) {
			System.out.println("Element not found");
		}
		
		finally {
			jse.executeScript("window.scrollBy(0,250)", "");
			jse.executeScript("window.scrollBy(0,250)", "");
			jse.executeScript("window.scrollBy(0,250)", "");
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
