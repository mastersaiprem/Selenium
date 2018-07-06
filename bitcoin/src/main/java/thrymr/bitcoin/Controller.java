package thrymr.bitcoin;

import java.io.FileInputStream;
import java.io.InputStream;

import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Controller {

	
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {

		Properties prop = new Properties();
		InputStream input = new FileInputStream("./inputdata.properties");
		prop.load(input);
		System.out.println(prop.getProperty("driverpath"));
		System.setProperty("webdriver.chrome.driver", prop.getProperty("driverpath"));
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Binance.Binance_data(driver);
		Bitfinex.Bitfinex_data(driver);
		Bithumb.Bithumb_data(driver);
		Cryptopia.Cryptopia_data(driver);
		Bitz.Bitz_data(driver);
		Coinone.Coinone_data(driver);
		Kucoin.Kucoin_data(driver);
		Liqui.Liqui_data(driver);
		Hitbtc.hitbtc_dta(driver);
		Bitflyer.Bitflyer_data(driver);
	
}
}