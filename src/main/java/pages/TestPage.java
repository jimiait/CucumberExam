package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TestPage {
	
	WebDriver driver;
	
	public TestPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	 @FindBy(how = How.XPATH, using = "//span[@id='extra']/button[1]")
	 WebElement SetSkyBlueBackground;
	 @FindBy(how = How.XPATH, using = "//span[@id='extra']/button[2]")
	 WebElement SetWhiteBackground;
	 
	 public void clickOnSetSkyBlueBackgroundButton() {
		 SetSkyBlueBackground.click();
	 }
	 
	 public void clickOnSetWhiteBackgroundButton() {
		 SetWhiteBackground.click();
	 }

}	
