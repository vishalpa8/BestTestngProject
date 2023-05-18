package com.Banklabs.pages;

import com.Banklabs.pages.OpportunityPage.OriginatorSection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Participations")
    WebElement participationBtn;

    @FindBy(linkText = "Create New")
    WebElement createNewBtn;

    @FindBy(xpath = "//input[@value='participation_new']")
    WebElement participationNewBtn;

    @FindBy(xpath = "//a[@id='create_opportunity_btn']")
    WebElement confirmBtn;

    @FindBy(xpath = "//input[@value='participation_existing_sold']")
    WebElement participationSoldBtn;

    @FindBy(xpath = "//input[@id='opportunity_type_bought']")
    WebElement participationBoughtBtn;


    public OriginatorSection createNewParticipation(){
        clickParticipation();
        clickCreateNew();
        waitForElementToBeClickable(participationNewBtn,10).click();
        clickConfirmBtn();

        return new OriginatorSection();
    }


    public OriginatorSection createSoldParticipation(){
        clickParticipation();
        clickCreateNew();
        waitForElementToBeClickable(participationSoldBtn,10).click();
        clickConfirmBtn();

        return new OriginatorSection();
    }

    public OriginatorSection createBoughtParticipation(){
        clickParticipation();
        clickCreateNew();
        waitForElementToBeClickable(participationBoughtBtn,10).click();
        clickConfirmBtn();

        return new OriginatorSection();
    }

    protected void clickParticipation(){
        waitForElementToBeClickable(participationBtn,10).click();
    }

    protected void clickCreateNew(){
        waitForElementToBeClickable(createNewBtn,10).click();
    }

    protected void clickConfirmBtn(){
        waitForElementToBeClickable(confirmBtn,10).click();
    }


}
