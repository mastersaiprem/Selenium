package thrymr.bitcoin;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Huobi {
	public static String Url = "https://www.huobi.pro/";
	public static void Huobi_data(WebDriver driver) throws Exception {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./inputdata.properties");
		prop.load(input);
		File file = new File(prop.getProperty("excelpath"));
		driver.get(Url);
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("(//em[@class='uppercase'])[1]"));
		scroll_down(driver, element);
		WebElement Table=driver.findElement(By.xpath("//div[@class='coin_list']"));		
		List<WebElement> rows = Table.findElements(By.tagName("dd"));
		System.out.println(rows.size());
		for(int i=1; i<rows.size();i++)
		{
			List<WebElement> Columns=rows.get(i).findElements(By.xpath("//span"));	
			String Pair = driver.findElement(By.xpath("(//dd//em[@class=\"base_currency\"])["+ i +"]")).getText();
			String Last_Price = driver.findElement(By.xpath("(//dd//span[@price=\"price\"])["+ i +"]")).getText();
			Exceldata.writeXLSXFile(Pair, Last_Price.trim(), file.toString(), "Huobi");
		}
		driver.close();
	}
	
	
	public static void scroll_down(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		
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