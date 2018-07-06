package thrymr.bitcoin;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.postgresql.translation.messages_bg;

public class Hitbtc {
	public static String Url = "https://hitbtc.com/";
	public static String Sheetname ="Hitbtc";
	public static void hitbtc_dta(WebDriver driver) throws Exception {
		
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./inputdata.properties");
		prop.load(input);
		File file = new File(prop.getProperty("excelpath"));
	driver.get(Url);
	Thread.sleep(9000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,250)", "");
	jse.executeScript("window.scrollBy(0,250)", "");
	WaitForElementclickable(driver,By.xpath("//*[@class='index_tickers__fullList']"));
	driver.findElement(By.xpath("//*[@class='index_tickers__fullList']")).click();
	WebElement Table=driver.findElement(By.xpath("//*[@class='index_tickers__body']"));
	WaitForElementclickable(driver, By.xpath("html/body/div[2]/div[1]/div[2]/div/div[2]/table/tbody/tr/td/a"));
	List<WebElement> rows = Table.findElements(By.tagName("tr")); 
	System.out.println(rows.size());
	for(int i=1; i<=rows.size(); i++)
	{
			try {

				WaitForElementVisible(driver,
						By.xpath("html/body/div[2]/div[1]/div[2]/div/div[2]/table/tbody/tr[" + i + "]/td/a"));
				Thread.sleep(2000);
				String Market = driver
						.findElement(
								By.xpath("html/body/div[2]/div[1]/div[2]/div/div[2]/table/tbody/tr[" + i + "]/td/a"))
						.getText();
				System.out.println(Market);
				try {
					WaitForElementVisible(driver,
							By.xpath("html/body/div[2]/div[1]/div[2]/div/div[2]/table/tbody/tr[" + i + "]/td[3]"));
					WebElement s = driver.findElement(
							By.xpath("html/body/div[2]/div[1]/div[2]/div/div[2]/table/tbody/tr[" + i + "]/td[3]"));
					String Price = s.getText();
					System.out.println(s.getText());
					Exceldata.writeXLSXFile(Market, Price, file.toString(), Sheetname);
					Thread.sleep(500);
					}
					catch (Exception e) {
						// TODO: handle exception
						String Price = "Price Not Found";
						System.out.println(Price);
						Exceldata.writeXLSXFile(Market, Price, file.toString(), Sheetname);
						Thread.sleep(500);
					}
				
				Thread.sleep(500);

			}
		catch(Exception e){
			System.err.println(e);
			
		}
		
	}
	
}
	



public static void WaitForElementVisible(WebDriver driver, By locator) {
	WebDriverWait wait = new WebDriverWait(driver, 10000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

}

public static void WaitForElementclickable(WebDriver driver, By locator) {
	WebDriverWait wait = new WebDriverWait(driver, 10000);
	wait.until(ExpectedConditions.elementToBeClickable(locator));

}
	
	
}
