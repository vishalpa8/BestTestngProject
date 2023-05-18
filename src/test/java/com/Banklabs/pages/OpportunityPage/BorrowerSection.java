package com.Banklabs.pages.OpportunityPage;

import com.Banklabs.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class BorrowerSection extends BasePage {

    public BorrowerSection(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@id='borrower_pencil']/i")
    WebElement borrowerEditPencil;

    @FindBy(id = "borrower_name")
    WebElement borrowerName;

    @FindBy(id = "project_name")
    WebElement projectName;

    @FindBy(xpath = "//select[@id='borrower_type_of_entity']")
    WebElement typeOfEntity;

    @FindBy(xpath = "//input[@id='borrower_city']")
    WebElement cityName;

    @FindBy(xpath = "//select[@id='borrower_state']")
    WebElement stateName;

    @FindBy(xpath = "//input[@id='borrower_zip_code']")
    WebElement zipCode;

    @FindBy(xpath = "//button[@id='borrower_button']")
    WebElement saveButton;

    @FindBy(id = "borrower_state_of_incorporation")
    WebElement stateOfIncorporation;

    @FindBy(id = "borrower_address")
    WebElement borrowerAddress;

    @FindBy(id = "loan_number")
    WebElement loanNumber;

    public DescriptionSection editBorrowerDetails(){
        waitForPageToBeReady();
        waitForElementToBeClickable(borrowerEditPencil,10).click();
        enterBorrowerDetails();
        return new DescriptionSection();
    }

    protected void enterBorrowerDetails(){
        enterBorrowerName();
        enterProjectName();
        selectTypeOfEntity();
        enterBorrowerAddress();
        enterStateOfIncorporation();
        enterCityName();
        selectStatName();
        enterZipCode();
        enterLoanNumber();
        saveTheDetails();
    }


    protected void enterBorrowerName(){
        borrowerName = waitForElementToBeClickable(borrowerName,10);
        borrowerName.sendKeys("testing");
    }
    protected void enterProjectName(){
        projectName.sendKeys("testing");
    }
    protected void enterBorrowerAddress(){
        borrowerAddress.sendKeys("streetNo-1 rail road NewYork");
    }
    protected void enterStateOfIncorporation(){
        stateOfIncorporation.sendKeys("NewYork");
    }
    protected void selectTypeOfEntity(){
        new Select(typeOfEntity).selectByIndex(4);
    }
    protected void enterCityName(){
        cityName.sendKeys("NewYork");
    }
    protected void selectStatName(){
        new Select(stateName).selectByIndex(5);
    }
    protected void enterZipCode(){
        zipCode.sendKeys("201002");
    }
    protected void enterLoanNumber(){
        loanNumber.sendKeys("098821891298");
    }
    protected void saveTheDetails(){
        saveButton.click();
    }
}
