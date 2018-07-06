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
public class Binance {

	
	public static String Url = "https://www.binance.com/";
	public static void Binance_data(WebDriver driver) throws Exception {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./inputdata.properties");
		prop.load(input);
		File file = new File(prop.getProperty("excelpath"));
		Exceldata.checkfile(file,"Binance");
		driver.get(Url);
		WaitForElementVisible(driver,By.xpath("(//*[text()='USDT'])[1]"));
		driver.findElement(By.xpath("(//*[text()='USDT'])[1]")).click();
		
		WebElement Table=driver.findElement(By.xpath("//*[@class='ReactVirtualized__Grid ReactVirtualized__Table__Grid']"));
		
		
		List<WebElement> rows = Table.findElements(By.className("ReactVirtualized__Table__row")); 
		for(int i=0; i<rows.size();i++)
		{
			List<WebElement> Columns=rows.get(i).findElements(By.className("ReactVirtualized__Table__rowColumn"));
			String Pair = Columns.get(1).getText();
			String Last_Price = Columns.get(3).getText();
			System.out.println(Pair+"--"+Last_Price.trim());	
			Exceldata.writeXLSXFile(Pair, Last_Price.trim(), file.toString(), "Binance");
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
