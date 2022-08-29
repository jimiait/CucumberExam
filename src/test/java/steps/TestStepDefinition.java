package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.TestBase;
import pages.TestPage;

public class TestStepDefinition extends TestBase{
	
	TestPage testPage;
	
	@Before
	public void methodName() {
		initDriver();
		testPage = PageFactory.initElements(driver, TestPage.class);
	}
	
	@Given("^User is on the TechFios test page;$")
	public void user_is_on_the_TechFios_test_page() {
		driver.get("https://techfios.com/test/101/");
	}

	
	@When("^Set SkyBlue Background button exists;$")
	public void set_SkyBlue_Background_button_exists() {
	Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(), 'Set SkyBlue Background')]")).isEnabled());
	}

	@When("^I click on the SkyBlue Background button;$")
	public void i_click_on_the_SkyBlue_Background_button(){
		testPage.clickOnSetSkyBlueBackgroundButton();

	}

	@Then("^the background color will change to sky blue$")
	public void the_background_color_will_change_to_sky_blue() throws Throwable {
	   Assert.assertTrue(driver.findElement(By.xpath("//body[@style='background-color: skyblue;']")).isEnabled());
	}
	
	@When("^Set SkyWhite Background button exists;$")
	public void set_SkyWhite_Background_button_exists(){
		Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(), 'Set White Background')]")).isEnabled());
	   
	}

	@When("^I click on the SkyWhite Background button;$")
	public void i_click_on_the_SkyWhite_Background_button(){
	    testPage.clickOnSetWhiteBackgroundButton();
	}

	@Then("^the background color will change to white$")
	public void the_background_color_will_change_to_white(){
		Assert.assertTrue(driver.findElement(By.xpath("//body[@style='background-color: white;']")).isEnabled());
	}
	
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
