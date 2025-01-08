package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LoginPage {
	
	WebDriver driver;


	@Given("the user is on home page")
	public void the_user_is_on_home_page() {
//	System.setProperty("webdriver.driver.chromedriver", "src/main/resources/chromedriver.exe") ;
//		As of selenium 4.10.0 the driver manager is fully integrated, and will silently download drivers as needed. (Eg. On Mac/Linux, drivers are automatically downloaded to the ~/.cache/selenium
		
		
	    driver =new ChromeDriver();
        driver=new FirefoxDriver();
	    driver.get("https://www.saucedemo.com/v1/");
	
	 
	    
	}

	@When("user enter username and password")
	public void user_enter_username_and_password() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    driver.findElement(By.id("password")).sendKeys("secret_sauce");

	}

	@And("click on submit button")
	public void click_on_submit_button() {
        driver.findElement(By.id("login-button")).click();
	    
	}

	@Then("user is able to navigate home page")
	public void user_is_able_to_navigate_home_page()
	{
		WebElement homeMenu=driver.findElement(By.xpath("//button[text()='Open Menu']"));
		homeMenu.isDisplayed();
	}
	
	@And("close the browser")
	public void close_the_browser() {
		driver.close();
	}

}  
