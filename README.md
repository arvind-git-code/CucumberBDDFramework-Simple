


This is a Simple BDD Framework using cucumber without using any design pattern 

## Steps 

> 1. create maven project in eclipse

- File> New > Maven Project- Check the text box Create a simple project(skipping the archetype);
- Group id - user website name i.e. com.arvind1
- artifact id - project name i.e. CucumberBDDFramework-Simple
- version - 1.0  the project version as you wish
- Name - project name i.e. CucumberBDDFramework-Simple


2. add 4 main dependencies in pom.xml selenium-java, cucumber-java, cucumber-testng, testng

   ``` <dependency>
    	<groupId>org.seleniumhq.selenium</groupId>
    	<artifactId>selenium-java</artifactId>
    	<version>4.25.0</version>
	</dependency>

	<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.20.1</version>
	</dependency>


	<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-testng</artifactId>
    <version>7.20.1</version>
	</dependency>

	<dependency>
    <groupId>org.testng</groupId>
   	<artifactId>testng</artifactId>
    	<version>7.10.2</version>
    	<scope>test</scope>
	</dependency>

	<!-- get the webdriver by webdriver manager optional but recomented-->

	<dependency>
   		<groupId>io.github.bonigarcia</groupId>
       	 	<artifactId>webdrivermanager</artifactId>
        	<version>5.5.3</version>
   	</dependency>
        
        
        
        
	<!-- for reporting purpose optional-->
    	<dependency>
        	<groupId>com.aventstack</groupId>
        	<artifactId>extentreports</artifactId>
        	<version>5.1.2</version>
    	</dependency>
    
   	<dependency>
    	<groupId>tech.grasshopper</groupId>
    	<artifactId>extentreports-cucumber7-adapter</artifactId>
    	<version>1.10.1</version>
	</dependency> ```

   
> if the default jar version is not compatible with the version of selenium then change the version of selenium jar in pom.xml



```  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.release>17</maven.compiler.release>
  </properties>
```
3. install cucumber and testng plugin from eclipse market place if not already installed

4. create necessary folders  and packages
    I. src/test/resource/ create a folder features- to store feature files for every feature in gerkin language
        i.e. 
        Feature: test the login page

        Scenario: checking for sucessful login
            Given the user is on home page
            When user enter username and password
            And click on submit button
            Then user is able to navigate home page
    if you want to pass multiple values the use senerio outline instead of senerio
    i.e. 
        Feature: test the login page

        Scenario Outline: checking for sucessful login
            Given the user is on home page
            When user enter username and password
            And click on submit button
            Then user is able to navigate home page
            Examples:
                | username | password |
                | abc      | 123      |
                | xyz      | 456      |

    II. src/test/java/ create a package stepDefinition - to create step definition (glue) file for every feature
        Note - for easier way you can get step definition method implementation by right clicking on feature file and then Run As -cucumber feature
        or you can define method yourself as below


```
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
    
```

	
> III. create a package in src/test/java/testrunner - to store runner file 

```  package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@login",
        features = "src/test/resources/features/", // Path to your feature files
        glue = {"stepDefinition"},					
        plugin= {"pretty","html:target/htmlReport.html"})  // Package containing your step definitions
public class TestRunner extends AbstractTestNGCucumberTests{

}
```

### How to run 
1. right click in runner page and select Run as - Test NG
2. right click on the project folder and choose - Run As -> Maven Test
3. open terminal at project path -- mvn test

> Common Mistakes
1. after static WebDriver driver;
again define WebDriver driver =new ChromeDriver(); instead of driver =new new ChromeDriver(); in a method 

## Connect with me

- **Name:** Arvind Kumar
- **LinkedIn:** [LinkedIn Profile URL](https://www.linkedin.com/in/arvind-kumar-a8b591221/)
- **Email:** [Email](mailto:arvindkumarlbsmca@gmail.com)
