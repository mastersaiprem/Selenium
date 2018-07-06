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

public class Bitfinex {
	
	public static String Url = "https://www.bitfinex.com/";
	
	public static void Bitfinex_data(WebDriver driver) throws Exception {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./inputdata.properties");
		prop.load(input);
		File file = new File(prop.getProperty("excelpath"));
		driver.get(Url);
		WaitForElementVisible(driver, By.xpath("(//*[@class=\"show-clickable\"])[1]"));
		WebElement Table=driver.findElement(By.xpath("//*[@class=\"landingtickers__table\"]//tbody"));
		List<WebElement> rows = Table.findElements(By.tagName("tr")); 
		System.out.println(rows.size());
		for(int i=0; i<rows.size(); i++)
		{
			List<WebElement> Columns=rows.get(i).findElements(By.tagName("td"));
			String Pair = Columns.get(1).getText();
			String Last_Price = Columns.get(2).getText();
			System.out.println(Pair+"--"+Last_Price.trim());	
			Exceldata.writeXLSXFile(Pair, Last_Price.trim(), file.toString(), "Bitfinex");
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
