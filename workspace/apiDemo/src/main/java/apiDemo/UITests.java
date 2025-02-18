package apiDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UITests extends BaseTest {

    
	@BeforeSuite
    public void setupExtent() {
        ExtentReportUtil reportUtil = new ExtentReportUtil();
        reportUtil.setUpReport();
    }
	@Test
    public void testLogin() {
    	ExtentReportUtil.startTest("testLogin");
        setUpDriver();
        driver.get("https://www.saucedemo.com/");
        ExtentReportUtil.logInfo("Opened website and logged in.");
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // Add assertions to verify the login was successful
        WebElement welcomeMessage = driver.findElement(By.xpath(".//span[contains(.,'Products')]"));
        assert welcomeMessage.getText().equals("Products");
        ExtentReportUtil.logPass("Login successful!");
	        

        tearDown();
    }
}

