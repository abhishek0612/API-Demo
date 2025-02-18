package apiDemo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;

public class BaseTest {
	
	private static final Logger logger = Logger.getLogger(BaseTest.class);
    protected WebDriver driver;

    // Initialize WebDriver
    public void setUpDriver() {
    	logger.info("Setting up WebDriver...");
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        logger.info("WebDriver setup completed.");
    }

    // Initialize RestAssured for API Testing
    public void setUpAPI() {
        RestAssured.baseURI = "https://api.example.com";
    }

    // Cleanup after tests
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}



