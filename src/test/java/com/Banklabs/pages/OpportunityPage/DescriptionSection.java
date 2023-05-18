package com.Banklabs.pages.OpportunityPage;

import com.Banklabs.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class DescriptionSection extends BasePage {

    public DescriptionSection() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@id='description_pencil']/i")
    WebElement descriptionEditPencil;

    @FindBy(xpath = "//*[@id='opportunity_loan_narrative']")
    WebElement loanNarrativeArea;

    @FindBy(xpath = "//*[@id='opportunity_borrower_general']")
    WebElement borrowerGeneralArea;

    @FindBy(xpath = "//button[@id='description_button']")
    WebElement saveButton;



    public StatisticsSection editDescriptionDetails(Map<String,String> data){
        waitForPageToBeReady();
        waitForElementToBeClickable(descriptionEditPencil,10).click();
        enterLoanNarrativeDetails();
        enterBorrowerGeneralArea();
        saveTheDetails();
        return new StatisticsSection();
    }



    protected void enterLoanNarrativeDetails(){
        loanNarrativeArea = waitForElementToBeClickable(loanNarrativeArea,10);
        loanNarrativeArea.sendKeys("this is for testing purpose");
    }
    protected void enterBorrowerGeneralArea(){
        borrowerGeneralArea.sendKeys("this is for testing purpose");
    }
    protected void saveTheDetails(){
        saveButton.click();
    }


}
