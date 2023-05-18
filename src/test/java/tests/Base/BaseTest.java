package tests.Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.base.Throwables;
import constants.AppConstants;
import dataproviders.YamlDataReader;
import factory.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

abstract public class BaseTest {


    public static ExtentTest extentTest;
    public static ExtentReports reports;
    public static ExtentSparkReporter sparkReporter;
    static public YamlDataReader yamlDataReader = null;
    WebDriver driver;
    static int screenshotCount = 0;

    @BeforeSuite(alwaysRun = true)
    public void suiteSetup(){
        reports = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(AppConstants.TARGET_FOLDER_LOCATION +
                AppConstants.EXTENT_REPORT_LOCATION);
        reports.attachReporter(sparkReporter);
        driver = new DriverFactory().selectDriver(AppConstants.BROWSER);
        yamlDataReader = new YamlDataReader(AppConstants.DATA_SOURCE);
    }

    public void suiteTearDown(){
        reports.flush();
    }

    @BeforeClass(alwaysRun = true)
    public void baseClassSetup(){
//        driver = new DriverFactory().selectDriver(AppConstants.BROWSER,AppConstants.RUN_MODE);
        driver.get(AppConstants.APP_URL);
    }

    @BeforeMethod(alwaysRun = true)
    public void logTestMethod(Method method){
        String className = method.getDeclaringClass().getName();
        Capabilities cap = ((RemoteWebDriver)driver).getCapabilities();
        String browserName = cap.getBrowserName();
        className = className.substring(className.lastIndexOf('.') + 1);
        extentTest = reports.createTest(method.getName()," <br /> BrowserName: <b ><p style= \"color:red;\">"
                +browserName + "</b></p>BaseUrl: " + driver.getCurrentUrl());
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod(Method method, ITestResult testResult, ITestContext testContext) throws IOException {
        if(testResult.getStatus() == ITestResult.FAILURE || testResult.getStatus() == ITestResult.SKIP
                || testResult.getStatus() == ITestResult.CREATED) {
            screenshotCount++;

            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String className = method.getDeclaringClass().getName();
            className = className.substring(className.lastIndexOf('.') + 1);

            String suiteName = testContext.getCurrentXmlTest().getSuite().getName();
            String screenShot = suiteName + "_" + className + "_" + method.getName() + "_" + screenshotCount + ".png";

            FileUtils.copyFile(scrFile, new File(AppConstants.TARGET_FOLDER_LOCATION + AppConstants.SCREENSHOT_LOCATION +
                    screenShot));
            extentReportLogsWithAttachedScreenShot(testResult, testContext, screenShot);
        }else{
            for (String log : Reporter.getOutput()){
                extentTest.log(Status.PASS,log);
            }
            reports.flush();
            Reporter.clear();
        }

    }

    private void extentReportLogsWithAttachedScreenShot(ITestResult testResult, ITestContext testContext,String screenShot){
        for (String log : Reporter.getOutput()){
            extentTest.log(Status.PASS,log);
        }
        if(testResult.getStatus() == ITestResult.CREATED){
            extentTest.log(Status.FAIL,"The Failed Steps: \n" + testContext.getFailedConfigurations().getAllMethods()
                            .toString(),

                    MediaEntityBuilder
                            .createScreenCaptureFromPath(
                                    AppConstants.SCREENSHOT_LOCATION + screenShot).build());
        }
        else{
            extentTest.log(Status.FAIL, Throwables.getStackTraceAsString(testResult.getThrowable()),
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(
                                    AppConstants.SCREENSHOT_LOCATION + screenShot).build());
        }
    }

    public <T> T initElements(Class<T> clazz){
        return PageFactory.initElements(driver,clazz);
    }

//    @AfterClass(alwaysRun = true)
//    public void tearDownTest(){
//        driver.manage().deleteAllCookies();
//        try {
//            if(!(driver == null)){
//
//            }
//            driver.quit();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}