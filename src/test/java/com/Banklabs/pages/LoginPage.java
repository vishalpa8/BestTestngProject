package com.Banklabs.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@data-target='#modSignin']")
    WebElement signIn;

    @FindBy(xpath = "//input[@id='username_email_modal']")
    WebElement userNameTxt;

    @FindBy(xpath = "//input[@id='user_password_modal']")
    WebElement passwordTxt;

    @FindBy(xpath = "//button[@id='signIn_modal_action']")
    WebElement signInBtn;


    public LoginPage clickSigin(){
        waitForElementToBeClickable(signIn,10).click();
        return new LoginPage();
    }
    public HomePage fillDetails(){
        waitForElementToBeClickable(userNameTxt,10).sendKeys("satya.pandey@qualitestgroup.com");
        passwordTxt.sendKeys("Vishalpa@098");
        signInBtn.click();
        return new HomePage();
    }
}
