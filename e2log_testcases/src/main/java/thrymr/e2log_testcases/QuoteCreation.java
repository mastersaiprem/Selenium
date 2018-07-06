package thrymr.e2log_testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class QuoteCreation {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://ci.thrymr.net:2018/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testQuoteCreation() throws Exception {
    driver.get(baseUrl + "/");
    assertEquals(driver.getTitle(), "e2log");
    driver.findElement(By.cssSelector("div.col-sm-6.logisticsServiceProvider-text > button.btn.btn-readMore")).click();
    driver.findElement(By.xpath("//input[@type='email']")).clear();
    driver.findElement(By.xpath("//input[@type='email']")).sendKeys("suryajyoti.bisen@thrymr.net");
    driver.findElement(By.xpath("//input[@type='Password']")).clear();
    driver.findElement(By.xpath("//input[@type='Password']")).sendKeys("e2loG@123");
    driver.findElement(By.cssSelector("button.rfqPrintBtn.btn")).click();
    driver.findElement(By.linkText("Quotation Requests")).click();
    driver.findElement(By.cssSelector("button.rfqPrintBtn")).click();
    driver.findElement(By.xpath("//div[@id='content1']/app-lsp-manage-quotation-rfqreceived/div[2]/app-lsp-view-rfq/div/div/div/div[2]/button")).click();
    driver.findElement(By.id("11")).click();
    driver.findElement(By.cssSelector("span.checkmark")).click();
    driver.findElement(By.id("12")).click();
    driver.findElement(By.xpath("//div[@id='print-drafted-rfq1']/div/div[2]/div/div/ul/li[2]/div/label/span")).click();
    driver.findElement(By.id("13")).click();
    driver.findElement(By.xpath("//div[@id='print-drafted-rfq1']/div/div[2]/div/div/ul/li[3]/div/label/span")).click();
    driver.findElement(By.id("14")).click();
    driver.findElement(By.xpath("//div[@id='print-drafted-rfq1']/div/div[2]/div/div/ul/li[4]/div/label/span")).click();
    driver.findElement(By.id("15")).click();
    driver.findElement(By.xpath("//div[@id='print-drafted-rfq1']/div/div[2]/div/div/ul/li[5]/div/label/span")).click();
    driver.findElement(By.id("16")).click();
    driver.findElement(By.xpath("//div[@id='print-drafted-rfq1']/div/div[2]/div/div/ul/li[6]/div/label/span")).click();
    driver.findElement(By.id("18")).click();
    driver.findElement(By.xpath("//div[@id='print-drafted-rfq1']/div/div[2]/div/div/ul/li[8]/div/label/span")).click();
    driver.findElement(By.id("17")).click();
    driver.findElement(By.xpath("//div[@id='print-drafted-rfq1']/div/div[2]/div/div/ul/li[7]/div/label/span")).click();
    driver.findElement(By.id("18")).click();
    driver.findElement(By.xpath("//div[@id='print-drafted-rfq1']/div/div[2]/div/div/ul/li[8]/div/label/span")).click();
    driver.findElement(By.id("18")).click();
    driver.findElement(By.xpath("//div[@id='print-drafted-rfq1']/div/div[2]/div/div/ul/li[8]/div/label/span")).click();
    driver.findElement(By.id("19")).click();
    driver.findElement(By.xpath("//div[@id='print-drafted-rfq1']/div/div[2]/div/div/ul/li[9]/div/label/span")).click();
    driver.findElement(By.id("110")).click();
    driver.findElement(By.xpath("//div[@id='print-drafted-rfq1']/div/div[2]/div/div/ul/li[10]/div/label/span")).click();
    driver.findElement(By.name("namead")).clear();
    driver.findElement(By.name("namead")).sendKeys("12");
    driver.findElement(By.name("camanpowerPrice")).clear();
    driver.findElement(By.name("camanpowerPrice")).sendKeys("23");
    driver.findElement(By.name("catravelAccomodationRate")).click();
    driver.findElement(By.name("catravelAccomodationRate")).clear();
    driver.findElement(By.name("catravelAccomodationRate")).sendKeys("23");
    driver.findElement(By.name("catravelAccomodationPersons")).clear();
    driver.findElement(By.name("catravelAccomodationPersons")).sendKeys("24");
    driver.findElement(By.xpath("//div[@id='accordian']/div[2]/div/a/div/div/div[3]/span/i")).click();
    driver.findElement(By.xpath("(//input[@name='namead'])[2]")).click();
    driver.findElement(By.xpath("(//input[@name='namead'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@name='namead'])[2]")).sendKeys("24");
    driver.findElement(By.name("plpforkLiftPrice")).clear();
    driver.findElement(By.name("plpforkLiftPrice")).sendKeys("24");
    driver.findElement(By.name("plpcranesPrice")).clear();
    driver.findElement(By.name("plpcranesPrice")).sendKeys("24");
    driver.findElement(By.name("plplashingPrice")).clear();
    driver.findElement(By.name("plplashingPrice")).sendKeys("24");
    driver.findElement(By.name("plpwoddenBoxPrice")).click();
    driver.findElement(By.name("plpwoddenBoxPrice")).clear();
    driver.findElement(By.name("plpwoddenBoxPrice")).sendKeys("2");
    driver.findElement(By.name("plpheavyPackingPrice")).clear();
    driver.findElement(By.name("plpheavyPackingPrice")).sendKeys("2");
    driver.findElement(By.name("plpbundlingPrice")).clear();
    driver.findElement(By.name("plpbundlingPrice")).sendKeys("2");
    driver.findElement(By.name("plpcontainerStuffingPrice")).clear();
    driver.findElement(By.name("plpcontainerStuffingPrice")).sendKeys("2");
    driver.findElement(By.name("plppackingListPreparationPrice")).clear();
    driver.findElement(By.name("plppackingListPreparationPrice")).sendKeys("2");
    driver.findElement(By.xpath("//div[@id='accordian']/div[3]/div[2]/a/div/div/div[3]/span/i")).click();
    driver.findElement(By.xpath("(//input[@name='namead'])[3]")).clear();
    driver.findElement(By.xpath("(//input[@name='namead'])[3]")).sendKeys("234");
    driver.findElement(By.name("ltforkLiftPrice")).clear();
    driver.findElement(By.name("ltforkLiftPrice")).sendKeys("2");
    driver.findElement(By.name("ltcranesPrice")).clear();
    driver.findElement(By.name("ltcranesPrice")).sendKeys("2");
    driver.findElement(By.name("ltenclosedTruckPrice")).clear();
    driver.findElement(By.name("ltenclosedTruckPrice")).sendKeys("2");
    driver.findElement(By.name("ltflatBedPrice")).clear();
    driver.findElement(By.name("ltflatBedPrice")).sendKeys("22");
    driver.findElement(By.name("lthydraulicPrice")).clear();
    driver.findElement(By.name("lthydraulicPrice")).sendKeys("2");
    driver.findElement(By.name("ltlowBedPrice")).clear();
    driver.findElement(By.name("ltlowBedPrice")).sendKeys("2");
    driver.findElement(By.name("ltescortCharges")).click();
    driver.findElement(By.name("ltescortCharges")).clear();
    driver.findElement(By.name("ltescortCharges")).sendKeys("2");
    driver.findElement(By.name("ltroadPermits")).clear();
    driver.findElement(By.name("ltroadPermits")).sendKeys("2");
    driver.findElement(By.name("ltotherCostDescription")).clear();
    driver.findElement(By.name("ltotherCostDescription")).sendKeys("fgdfgf");
    driver.findElement(By.name("ltotherCost")).clear();
    driver.findElement(By.name("ltotherCost")).sendKeys("34");
    driver.findElement(By.xpath("(//input[@name='namead'])[4]")).clear();
    driver.findElement(By.xpath("(//input[@name='namead'])[4]")).sendKeys("34");
    driver.findElement(By.xpath("(//input[@name='namead'])[5]")).click();
    driver.findElement(By.xpath("(//input[@name='namead'])[5]")).clear();
    driver.findElement(By.xpath("(//input[@name='namead'])[5]")).sendKeys("3");
    driver.findElement(By.xpath("//div[@id='accordian']/div[4]/div[2]/a/div/div/div[3]/span/i")).click();
    driver.findElement(By.name("cclagencyFeesPercentage")).clear();
    driver.findElement(By.name("cclagencyFeesPercentage")).sendKeys("34");
    driver.findElement(By.name("cclstatutoryCharges")).click();
    driver.findElement(By.name("cclstatutoryCharges")).clear();
    driver.findElement(By.name("cclstatutoryCharges")).sendKeys("34");
    driver.findElement(By.xpath("//div[@id='accordian']/div[5]/div[2]/a/div/div/div[3]/span/i")).click();
    driver.findElement(By.name("tlthcPhcPrice")).clear();
    driver.findElement(By.name("tlthcPhcPrice")).sendKeys("34");
    driver.findElement(By.name("ltloadingCranePrice")).clear();
    driver.findElement(By.name("ltloadingCranePrice")).sendKeys("34");
    driver.findElement(By.name("lttruckinPrice")).clear();
    driver.findElement(By.name("lttruckinPrice")).sendKeys("3");
    driver.findElement(By.xpath("//div[@id='accordian']/div[6]/div[2]/a/div/div/div[3]/span/i")).click();
    driver.findElement(By.xpath("(//input[@name='namead'])[6]")).clear();
    driver.findElement(By.xpath("(//input[@name='namead'])[6]")).sendKeys("5");
    driver.findElement(By.name("itfreightPortPrice")).clear();
    driver.findElement(By.name("itfreightPortPrice")).sendKeys("5");
    driver.findElement(By.name("itfreightPortWtPrice")).clear();
    driver.findElement(By.name("itfreightPortWtPrice")).sendKeys("5");
    driver.findElement(By.name("itratePersurvey")).clear();
    driver.findElement(By.name("itratePersurvey")).sendKeys("5");
    driver.findElement(By.name("itnoOfSurvey")).clear();
    driver.findElement(By.name("itnoOfSurvey")).sendKeys("5");
    driver.findElement(By.name("itinsurancePrice")).clear();
    driver.findElement(By.name("itinsurancePrice")).sendKeys("55");
    driver.findElement(By.name("itroadPerms")).click();
    driver.findElement(By.name("itroadPerms")).clear();
    driver.findElement(By.name("itroadPerms")).sendKeys("5");
    driver.findElement(By.name("itescortCharges")).click();
    driver.findElement(By.name("itescortCharges")).clear();
    driver.findElement(By.name("itescortCharges")).sendKeys("5");
    new Select(driver.findElement(By.name("itinternationalTransportMode"))).selectByVisibleText("SEA");
    driver.findElement(By.name("itvesselType")).clear();
    driver.findElement(By.name("itvesselType")).sendKeys("fdgdf");
    driver.findElement(By.name("itvesselSizeInTons")).clear();
    driver.findElement(By.name("itvesselSizeInTons")).sendKeys("45");
    driver.findElement(By.name("itvesselSizeInCbms")).clear();
    driver.findElement(By.name("itvesselSizeInCbms")).sendKeys("45");
    new Select(driver.findElement(By.name("itfreightPlan"))).selectByVisibleText("Full Charter");
    driver.findElement(By.name("itnameOfCarrier")).clear();
    driver.findElement(By.name("itnameOfCarrier")).sendKeys("sdfgsdg");
    driver.findElement(By.name("itflagOfCarrier")).click();
    driver.findElement(By.name("itflagOfCarrier")).clear();
    driver.findElement(By.name("itflagOfCarrier")).sendKeys("gsdgsd");
    driver.findElement(By.name("itloadingPort")).click();
    driver.findElement(By.name("itloadingPort")).clear();
    driver.findElement(By.name("itloadingPort")).sendKeys("dgsdg");
    driver.findElement(By.name("itagencyResponsibleLoading")).clear();
    driver.findElement(By.name("itagencyResponsibleLoading")).sendKeys("dsgsdg");
    driver.findElement(By.cssSelector("button.btnpicker.btnpickerenabled")).click();
    driver.findElement(By.xpath("//div[@id='scope-5']/div[2]/div[19]/form/div/div/my-date-picker/div/div[2]/table[2]/tbody/tr[4]/td[5]/div/span")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
    driver.findElement(By.xpath("//div[@id='scope-5']/div[2]/div[19]/form/div/div[2]/my-date-picker/div/div[2]/table[2]/tbody/tr[4]/td[6]/div/span")).click();
    driver.findElement(By.name("itdetentionLoadPortCharges")).clear();
    driver.findElement(By.name("itdetentionLoadPortCharges")).sendKeys("6");
    driver.findElement(By.name("itfreeDaysForLoading")).click();
    driver.findElement(By.name("itfreeDaysForLoading")).clear();
    driver.findElement(By.name("itfreeDaysForLoading")).sendKeys("6");
    driver.findElement(By.name("itdischargePort")).clear();
    driver.findElement(By.name("itdischargePort")).sendKeys("jfg");
    driver.findElement(By.name("itagencyResponsibleForOffLoading")).clear();
    driver.findElement(By.name("itagencyResponsibleForOffLoading")).sendKeys("fgjfgj");
    driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
    driver.findElement(By.xpath("//div[@id='scope-5']/div[2]/div[28]/form/div/div/my-date-picker/div/div[2]/table[2]/tbody/tr[4]/td[5]")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
    driver.findElement(By.xpath("//div[@id='scope-5']/div[2]/div[28]/form/div/div[2]/my-date-picker/div/div[2]/table[2]/tbody/tr[4]/td[5]/div")).click();
    driver.findElement(By.name("itdetentionDischargePortCharges")).clear();
    driver.findElement(By.name("itdetentionDischargePortCharges")).sendKeys("66");
    driver.findElement(By.name("itfreeDaysforOffLoading")).clear();
    driver.findElement(By.name("itfreeDaysforOffLoading")).sendKeys("66");
    new Select(driver.findElement(By.name("ittypeOfBLRelease"))).selectByVisibleText("Others");
    driver.findElement(By.xpath("(//input[@name='namead'])[7]")).clear();
    driver.findElement(By.xpath("(//input[@name='namead'])[7]")).sendKeys("6");
    driver.findElement(By.xpath("//div[@id='accordian']/div[7]/div[2]/a/div/div/div[3]/span/i")).click();
    driver.findElement(By.name("tphdthcPhcPrice")).click();
    driver.findElement(By.name("tphdthcPhcPrice")).clear();
    driver.findElement(By.name("tphdthcPhcPrice")).sendKeys("6");
    driver.findElement(By.name("itloadingCranePrice")).clear();
    driver.findElement(By.name("itloadingCranePrice")).sendKeys("6");
    driver.findElement(By.name("namead2")).click();
    driver.findElement(By.name("namead2")).clear();
    driver.findElement(By.name("namead2")).sendKeys("6");
    driver.findElement(By.xpath("//div[@id='accordian']/div[8]/div[2]/a/div/div/div[3]/span/i")).click();
    driver.findElement(By.xpath("(//input[@name='namead'])[8]")).clear();
    driver.findElement(By.xpath("(//input[@name='namead'])[8]")).sendKeys("6");
    driver.findElement(By.name("ccdagencyFeesPercentage")).click();
    driver.findElement(By.name("ccdagencyFeesPercentage")).clear();
    driver.findElement(By.name("ccdagencyFeesPercentage")).sendKeys("67");
    driver.findElement(By.name("ccdstatutoryCharges")).clear();
    driver.findElement(By.name("ccdstatutoryCharges")).sendKeys("67");
    driver.findElement(By.xpath("//div[@id='accordian']/div[9]/div[2]/a/div/div/div[3]/span/i")).click();
    driver.findElement(By.xpath("(//input[@name='namead'])[9]")).clear();
    driver.findElement(By.xpath("(//input[@name='namead'])[9]")).sendKeys("67");
    driver.findElement(By.cssSelector("div.col-md-6 > div.row.width-20 > div.col-md-4.form-group > input[name=\"namead2\"]")).clear();
    driver.findElement(By.cssSelector("div.col-md-6 > div.row.width-20 > div.col-md-4.form-group > input[name=\"namead2\"]")).sendKeys("6");
    driver.findElement(By.xpath("(//input[@name='namead2'])[3]")).clear();
    driver.findElement(By.xpath("(//input[@name='namead2'])[3]")).sendKeys("8");
    driver.findElement(By.xpath("(//input[@name='namead2'])[4]")).clear();
    driver.findElement(By.xpath("(//input[@name='namead2'])[4]")).sendKeys("9");
    driver.findElement(By.xpath("(//input[@name='namead2'])[5]")).clear();
    driver.findElement(By.xpath("(//input[@name='namead2'])[5]")).sendKeys("87");
    driver.findElement(By.xpath("(//input[@name='namead2'])[6]")).clear();
    driver.findElement(By.xpath("(//input[@name='namead2'])[6]")).sendKeys("78");
    driver.findElement(By.xpath("(//input[@name='namead2'])[7]")).clear();
    driver.findElement(By.xpath("(//input[@name='namead2'])[7]")).sendKeys("67");
    driver.findElement(By.cssSelector("div.col-md-12.form-group > input[name=\"namead2\"]")).clear();
    driver.findElement(By.cssSelector("div.col-md-12.form-group > input[name=\"namead2\"]")).sendKeys("67");
    driver.findElement(By.xpath("(//input[@name='namead2'])[9]")).clear();
    driver.findElement(By.xpath("(//input[@name='namead2'])[9]")).sendKeys("67");
    driver.findElement(By.name("ltDishchargeotherCostDescription")).clear();
    driver.findElement(By.name("ltDishchargeotherCostDescription")).sendKeys("hgfhfg");
    driver.findElement(By.name("ltDishchargeotherCost")).clear();
    driver.findElement(By.name("ltDishchargeotherCost")).sendKeys("57");
    driver.findElement(By.xpath("(//input[@name='namead'])[10]")).clear();
    driver.findElement(By.xpath("(//input[@name='namead'])[10]")).sendKeys("57");
    driver.findElement(By.xpath("//div[@id='accordian']/div[10]/div[2]/a/div/div/div[3]/span/i")).click();
    driver.findElement(By.name("offLoadingAtDloadForkLiftPrice")).clear();
    driver.findElement(By.name("offLoadingAtDloadForkLiftPrice")).sendKeys("57");
    driver.findElement(By.cssSelector("#scope-9 > div.row > div.col-md-6 > div.row.width-20 > div.col-md-4.form-group > input[name=\"namead2\"]")).click();
    driver.findElement(By.cssSelector("#scope-9 > div.row > div.col-md-6 > div.row.width-20 > div.col-md-4.form-group > input[name=\"namead2\"]")).clear();
    driver.findElement(By.cssSelector("#scope-9 > div.row > div.col-md-6 > div.row.width-20 > div.col-md-4.form-group > input[name=\"namead2\"]")).sendKeys("57");
    driver.findElement(By.id("data-1")).clear();
    driver.findElement(By.id("data-1")).sendKeys("/home/thrymr/Desktop/500_error.png");
    driver.findElement(By.id("data-2")).clear();
    driver.findElement(By.id("data-2")).sendKeys("/home/thrymr/Desktop/500_error.png");
    driver.findElement(By.id("data-3")).clear();
    driver.findElement(By.id("data-3")).sendKeys("/home/thrymr/Desktop/500_error.png");
    driver.findElement(By.id("data-5")).clear();
    driver.findElement(By.id("data-5")).sendKeys("/home/thrymr/Desktop/500_error.png");
    driver.findElement(By.id("data-6")).clear();
    driver.findElement(By.id("data-6")).sendKeys("/home/thrymr/Desktop/500_error.png");
    driver.findElement(By.id("data-7")).clear();
    driver.findElement(By.id("data-7")).sendKeys("/home/thrymr/Desktop/500_error.png");
    driver.findElement(By.id("data-10")).clear();
    driver.findElement(By.id("data-10")).sendKeys("/home/thrymr/Desktop/500_error.png");
    driver.findElement(By.id("data-11")).clear();
    driver.findElement(By.id("data-11")).sendKeys("/home/thrymr/Desktop/500_error.png");
    driver.findElement(By.id("data-12")).clear();
    driver.findElement(By.id("data-12")).sendKeys("/home/thrymr/Desktop/500_error.png");
    driver.findElement(By.id("data-14")).clear();
    driver.findElement(By.id("data-14")).sendKeys("/home/thrymr/Desktop/500_error.png");
    driver.findElement(By.id("data-18")).clear();
    driver.findElement(By.id("data-18")).sendKeys("/home/thrymr/Desktop/500_error.png");
    driver.findElement(By.id("data-19")).clear();
    driver.findElement(By.id("data-19")).sendKeys("/home/thrymr/Desktop/500_error.png");
    driver.findElement(By.id("manageQuoteTerms")).click();
    driver.findElement(By.cssSelector("div.padding-10 > label.md-checkbox2.lineheight-20 > span.checkmark")).click();
    driver.findElement(By.cssSelector("div.col-md-6 > button[name=\"button\"]")).click();
    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
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
