package factory;

import constants.AppConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;


public class DriverFactory {

    static public WebDriver driver;

    public WebDriver selectDriver(String browser){
        driver = localDriverInstace(browser);
        return driver;

    }

    private WebDriver localDriverInstace(String browser) {

        switch (browser){

            case "chrome" :
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--start-maximized");
                options.addArguments("--allow-running-insecure-content");
                options.addArguments("--ignore-certificate-errors");

                if (AppConstants.BROWSER_RUN_MODE != null){
                    options.addArguments("--headless");
                    options.addArguments("--windows-size=1500,1280");
                }
                System.setProperty("webdriver.chrome.driver",System.getenv("Public") + "\\webdriver\\chromedriver.exe");
                driver = new ChromeDriver(options);
                break;

            case "edge" :
                System.setProperty("webdriver.edge.driver", System.getenv("Public") + "\\webdriver\\msedgedriver.exe");
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;


        }

        return driver;
    }

}
