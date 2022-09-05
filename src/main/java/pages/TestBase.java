package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestBase{
	
	public static WebDriver driver;

	 public static void initDriver() {
	  System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver4.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
	 
	 public static void takeScreenshot(WebDriver driver) {
		 TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date();
		String lable = formatter.format(date);
		
		 try {
			FileUtils.copyFile(sourceFile, new File(System.getProperty("user.dir") + "/screenshot/" + lable + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	 }
	 
	 public int generateRandomNo(int boundNo) {
			Random rnd = new Random();
			int generateNo = rnd.nextInt(boundNo);
			return generateNo;
		}
		
		public void selectFromDropdown(WebElement element, String visibleText) {
			Select sel = new Select(element);
			sel.selectByVisibleText(visibleText);
		}


}
