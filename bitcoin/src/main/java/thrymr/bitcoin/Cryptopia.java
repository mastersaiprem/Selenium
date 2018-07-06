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

public class Cryptopia {
	public static String Url = "https://www.cryptopia.co.nz/Exchange/?baseMarket=USDT";
	public static void Cryptopia_data(WebDriver driver) throws Exception {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./inputdata.properties");
		prop.load(input);
		File file = new File(prop.getProperty("excelpath"));
		driver.get(Url);
		WaitForElementVisible(driver,By.xpath("//span[contains(text(),'USDT')]"));
		WebElement Table=driver.findElement(By.xpath("//*[@id='currencyData-USDT']"));
		List<WebElement> rows = Table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		for(int i=1; i<rows.size();i++)
		{
			List<WebElement> Columns=rows.get(i).findElements(By.tagName("td"));
			System.out.println(Columns.size());
			String Pair = Columns.get(1).getText();
			String Last_Price = Columns.get(7).getText();
			System.out.println(Pair+"--"+Last_Price.trim());
			Exceldata.writeXLSXFile(Pair, Last_Price.trim(), file.toString(), "Cryptopia");
			
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
