package com.Banklabs.pages.OpportunityPage;

import com.Banklabs.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class OriginatorSection extends BasePage {

    public OriginatorSection(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains(text(),'Participation')]")
    WebElement opportunityText;

    @FindBy(xpath = "//a[@id='originator_pencil']/i")
    WebElement originatorEditPencil;

    @FindBy(xpath = "//select[@id='loan_originator_id']")
    WebElement selectLoanOriginator;

    @FindBy(xpath = "//select[@id='lender_id']")
    WebElement selectLenderType;

    @FindBy(id = "originator_button")
    WebElement saveButton;

    public OriginatorSection clickOriginatorPencil(){
        waitForElementToBeClickable(originatorEditPencil,10).click();
        selectLoanOriginator();
        selectLenderOriginator();
        saveButton.click();
        return new OriginatorSection();
    }

    protected void selectLoanOriginator(){
        waitForPageToBeReady();
        new Select(selectLoanOriginator).selectByIndex(1);
    }
    protected void selectLenderOriginator(){
        new Select(selectLenderType).selectByIndex(1);
    }
    public String opportunityType(){
        return opportunityText.getText().trim();
    }




}
