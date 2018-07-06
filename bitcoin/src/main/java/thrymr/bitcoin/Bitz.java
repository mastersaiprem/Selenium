package thrymr.bitcoin;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bitz {
	public static String Url = "https://www.bit-z.com/";
	public static void Bitz_data(WebDriver driver) throws Exception {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./inputdata.properties");
		prop.load(input);
		File file = new File(prop.getProperty("excelpath"));
	
		driver.get(Url);
		WaitForElementVisible(driver,By.xpath("//span[contains(text(),'BTC Markets ')]"));
		driver.findElement(By.xpath("//span[contains(text(),'BTC Markets ')]")).click();
		WebElement Table=driver.findElement(By.xpath("//*[@class='btc_box mk_tabitem ']/ul"));
		List<WebElement> rows = Table.findElements(By.tagName("li"));
		
		System.out.println(rows.size());
		for(int i=1; i<=rows.size();i++)
		{	
			try {	
			String Pair = driver.findElement(By.xpath("//*[@class='btc_box mk_tabitem ']/ul/li["+ i +"]//a/span[1]")).getText();
			String Last_Price = driver.findElement(By.xpath("//*[@class='btc_box mk_tabitem ']/ul/li["+ i +"]//a/span[2]")).getText();
			System.out.println(Pair+"--"+Last_Price.trim());	
			Exceldata.writeXLSXFile(Pair, Last_Price.trim(), file.toString(), "Bitz");
			}
			
			catch (Exception e) {
				// TDO: handle exception
				String Pair = "Data Not Found";
				String Last_Price = "Data Not Found";;
				System.out.println(Pair+"--"+Last_Price.trim());	
				Exceldata.writeXLSXFile(Pair, Last_Price.trim(), file.toString(), "Bitz");
			}
			
		}
		
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