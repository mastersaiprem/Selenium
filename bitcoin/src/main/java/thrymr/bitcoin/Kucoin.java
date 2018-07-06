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

public class Kucoin {
	public static String Url = "https://www.kucoin.com/#/markets";
	public static void Kucoin_data(WebDriver driver) throws Exception {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("./inputdata.properties");
		prop.load(input);
		File file = new File(prop.getProperty("excelpath"));
		// Exceldata.checkfile(file,"Bitz");
		driver.get(Url);
		WaitForElementVisible(driver,By.xpath("//div[@class='ant-table-body']//tbody"));
		WebElement Table = driver.findElement(By.xpath("//div[@class='ant-table-body']//tbody"));
		List<WebElement> rows = Table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		for (int i = 0; i < rows.size(); i++) {
			try {
				List<WebElement> Column = rows.get(i).findElements(By.tagName("td"));
				String Pair = Column.get(0).getText();
				String Last_Price = Column.get(1).getText();
				System.out.println(Pair + "--" + Last_Price.trim());
				Exceldata.writeXLSXFile(Pair, Last_Price.trim(), file.toString(), "Kucoin");
			}

			catch (Exception e) {
				// TDO: handle exception
				String Pair = "Data Not Found";
				String Last_Price = "Data Not Found";
				System.out.println(Pair + "--" + Last_Price.trim());
//				Exceldata.writeXLSXFile(Pair, Last_Price.trim(), file.toString(), "Kucoin");
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