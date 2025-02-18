	package apiDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ExtentReportUtil {
    private static ExtentReports extent;
    private static ExtentTest test;

    // Initialize ExtentReports
    @BeforeSuite
    public void setUpReport() {
        // Initialize ExtentSparkReporter to generate HTML report
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-report.html");
        sparkReporter.config().setReportName("Automation Test Report");

        // Initialize ExtentReports with the SparkReporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    // Create a test instance
    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    // Log info in the report
    public static void logInfo(String message) {
        test.info(message);
    }

    // Log pass/fail status
    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

    // Finalize the report after the tests are completed
    @AfterSuite
    public void tearDownReport() {
        extent.flush(); // Write the results to the HTML file
    }
}
