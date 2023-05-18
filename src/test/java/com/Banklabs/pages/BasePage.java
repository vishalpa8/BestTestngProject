package com.Banklabs.pages;

import factory.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

public class BasePage extends DriverFactory {

    protected WebDriver driver;


    public BasePage(){
        this.driver = new DriverFactory().driver;
    }


    public <T> T initElements(Class<T> clazz){
        return PageFactory.initElements(driver,clazz);
    }
    ArrayList<String> tabs;

    protected WebElement waitForElementToBeClickable(WebElement element, int waitTime ) {
        new WebDriverWait(driver, waitTime).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
    protected void letsWait(int time){
        try {
            Thread.sleep(time * 1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void clickByJavaScriptExecutor(WebElement element){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();",element);
    }
    protected void scrollIntoView(WebElement element){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    protected void switchToWindow(String tab){
        tabs = new ArrayList<String>(driver.getWindowHandles());
        if(tab.equalsIgnoreCase("secondTab")){
            driver.switchTo().window(tabs.get(1));
        }

        if (tab.equalsIgnoreCase("firstTab")){
            driver.close();
            driver.switchTo().window(tabs.get(0));
            letsWait(5);
        }

    }

    protected void waitForPageToBeReady(){
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public String convertCurrencyToString(String amount){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        Number number = null;
        try {
            number = numberFormat.parse(amount);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return number.toString();
    }


    //    @AfterSuite
    public void tearDown(){
        if(driver != null){
            driver.close();
        }
    }

}
