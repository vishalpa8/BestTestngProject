package com.Banklabs.pages.OpportunityPage;

import com.Banklabs.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PreliminaryUnderwritingSection extends BasePage {

    public PreliminaryUnderwritingSection() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[id=net_operating_income_cents]")
    WebElement netOperatingIncome;

    @FindBy(xpath = "//a[@id='preliminary_underwriting_pencil']/i")
    WebElement preliminaryEditPencil;

    @FindBy(css = "input[id=historical_yields]")
    WebElement historicalYields;

    @FindBy(css = "select[id=borrower_own_or_lease_land]")
    WebElement borrowerOwnOrLeaseLand;

    @FindBy(css = "#div_opportunity_quick_details > h4")
    WebElement loanValueTxt;

    @FindBy(css = "*[id=collateral_detail]")
    WebElement collateralDetails;

    @FindBy(css = "*[id=crops_by_type]")
    WebElement cropByType;

    @FindBy(css = "input[id=debt_service_coverage]")
    WebElement debtServiceCoverage;

    @FindBy(css = "select[id=govt_guaranty]")
    WebElement governmentGuaranty;

    @FindBy(css = "*[id=govt_commodity_predictions_used]")
    WebElement governmentCommodity;

    @FindBy(css = "textarea[id=purpose]")
    WebElement purposeArea;

    @FindBy(css = "input[id=lease_term]")
    WebElement termOfLease;

    @FindBy(css = "button[id=preliminary_button]")
    WebElement saveButton;

    public PreliminaryUnderwritingSection editPreliminaryDetails() {
        waitForPageToBeReady();
        waitForElementToBeClickable(preliminaryEditPencil, 10).click();

        enter3YearHistoricalYields("testing");
        selectBorrowerOneOrLeaseLand("Own");        //Own or Lease
        setCollateralDetails("testing");
        setCropByType("Testing");
        setGovernmentGuaranty("Yes");       // Yes or No
        enterGovernmentCommodityPredictionsUsed("testing");
        enterNetOperatingIncome("100.00");
        enterPurpose("this is for testing purpose");
        enterTermOfLeaseInMonths("6");
        saveTheDetails();

        return this;
    }

    public void enter3YearHistoricalYields(String value) {
        historicalYields = waitForElementToBeClickable(historicalYields,10);
        historicalYields.sendKeys(value);
    }

    public void selectBorrowerOneOrLeaseLand(String type) {
        new Select(borrowerOwnOrLeaseLand).selectByValue(type);
    }

    public void setCollateralDetails(String value) {
        collateralDetails.sendKeys(value);
    }

    public void setCropByType(String value) {
        cropByType.sendKeys(value);
    }

    public void setDebtServiceCoverage(String percentage) {
        debtServiceCoverage.sendKeys(percentage);
    }

    public void setGovernmentGuaranty(String value) {
        new Select(governmentGuaranty).selectByValue(value);
    }

    public void enterGovernmentCommodityPredictionsUsed(String value) {
        governmentCommodity.sendKeys(value);
    }

    public void enterNetOperatingIncome(String value){
        netOperatingIncome.sendKeys(value);
    }

    public void enterPurpose(String value){
        purposeArea.sendKeys(value);
    }
    public void enterTermOfLeaseInMonths(String month){
        termOfLease.sendKeys(month);
    }

    public void saveTheDetails(){
        saveButton.click();
    }

    public String getTotalLoanAmount(){
        String value = loanValueTxt.getText();

        return convertCurrencyToString(value);
    }
}
