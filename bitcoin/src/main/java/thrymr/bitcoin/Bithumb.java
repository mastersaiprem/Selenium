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

public class Bithumb {
	
	
	
		public static String Url = "https://www.bithumb.com/";
		public static void Bithumb_data(WebDriver driver) throws Exception {
			Properties prop = new Properties();
			InputStream input = new FileInputStream("./inputdata.properties");
			prop.load(input);
			File file = new File(prop.getProperty("excelpath"));
			driver.get(Url);
			WaitForElementVisible(driver,By.xpath("//div[@class='g_right']"));
			driver.findElement(By.xpath("//div[@class='g_right']")).click();
			WaitForElementVisible(driver,By.xpath("//table[@id='tableAsset']/tbody"));
			WebElement Table=driver.findElement(By.xpath("//table[@id='tableAsset']/tbody"));
			List<WebElement> rows = Table.findElements(By.xpath("tr"));
			System.out.println(rows.size());
			for(int i=0; i<rows.size();i++)
			{	
				if((i%2)!=0) {			
				List<WebElement> Columns=rows.get(i).findElements(By.xpath("//*[@id=\"tableAsset\"]/tbody/tr["+i+"]/td"));
				String Pair = Columns.get(0).getText();
				String Last_Price = Columns.get(2).getText();
				System.out.println(Pair+"--"+Last_Price.trim());	
				Exceldata.writeXLSXFile(Pair, Last_Price.trim(), file.toString(), "Bithumb");
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
