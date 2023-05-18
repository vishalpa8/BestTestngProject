package com.Banklabs.pages.OpportunityPage;

import com.Banklabs.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;


public class StatisticsSection extends BasePage {

    public StatisticsSection() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//a[@id='statistics_pencil']/i")
    WebElement statisticsEditPencil;

    @FindBy(xpath = "//select[@name='loan_type']")
    WebElement loanType;

    @FindBy(xpath = "//select[@name='loan_sub_type']")
    WebElement loanSubType;

    @FindBy(xpath = "//select[@name='occupancy_type']")
    WebElement occupancyType;

    @FindBy(xpath = "//input[@name='loan_rate']")
    WebElement loanRatePercent;

    @FindBy(xpath = "//select[@id='rate_type']")
    WebElement rateType;

    @FindBy(xpath = "//input[@name='loan_amount_cents']")
    WebElement loanAmount;

    @FindBy(xpath = "//input[@name='outstanding_balance_cents']")
    WebElement outstandingBalance;

    @FindBy(xpath = "//input[@id='balance_date']")
    WebElement balanceDate;

    @FindBy(css = "input#initial_loan_funding_amount_cents")
    WebElement initialLoanFundingAmount;

    @FindBy(css = "input[id=participation_amount_cents]")
    WebElement amountToParticipate;

    @FindBy(css = "input[id=origination_fees]")
    WebElement originationFees;

    @FindBy(css = "input[id=servicing_fee]")
    WebElement servicingFees;

    @FindBy(css = "input[id='initial_servicing_fee_cents']")
    WebElement initialServicingFees;

    @FindBy(css = "*[id='issuer_rating']")
    WebElement bankAssessedLoanQuality;

    @FindBy(css = "input[id*='cra_eligible']")
    List<WebElement> craEligibility;

    @FindBy(css = "select[id='guarantors']")
    WebElement guarantors;

    @FindBy(css = "input[id*='guarantors_type']")
    List<WebElement> guarantorType;

    @FindBy(css = "input[id='guarantors_amount_cents']")
    WebElement guarantorAmount;

    @FindBy(css = "input[id=tentative_closing_date]")
    WebElement tentativeClosingDate;

    @FindBy(css = "input[id=originated_date]")
    WebElement originatedDate;

    @FindBy(css = "input[id=funding_date]")
    WebElement fundingDate;

    @FindBy(css = "input[id=maturity_date]")
    WebElement maturityDate;

    @FindBy(css = "input[id=loan_term]")
    WebElement loanTermMonth;

    @FindBy(css = "input[id=interest_calculation_method]")
    WebElement interestCalculationMethod;

    @FindBy(css = "button[id=statistics_button]")
    WebElement saveButton;

    public PreliminaryUnderwritingSection editStatisticsDetails(Map<String,String> data) {
        waitForPageToBeReady();
        waitForElementToBeClickable(statisticsEditPencil, 10).click();
        selectLoanType();
        selectLoanSubType();
        enterLoanRatePercent("4");
        selectRateType("Fixed");
        enterLoanAmount(data.get("loanAmount"));
        enterOutstandingBalance("200000.00");
        enterBalanceDate("05/16/2023");
        enterInitialLoanFundingAmount("10000.00");
        enterAmountToParticipated("10000.00");
        enterOriginationFees("2");
        enterServicingFees("1");
        enterInitialServicingFees("100.00");
        enterBankAssessedLoanQuality();
        selectCRAEligibility("no");
        selectGuarantors("2");
        selectGuarantorsType("amount");
        enterGuarantorsAmount("100.00");
        enterTentativeClosingDate("05/27/2023");
        enterOriginatedDate();
        enterFundingDate();
        enterMaturityDate();
        enterLoanTermMonth();
        enterInterestCalculationMethod();
        saveTheDetails();


        return new PreliminaryUnderwritingSection();
    }


    public void selectLoanType() {
        loanType = waitForElementToBeClickable(loanType, 10);
        new Select(loanType).selectByValue("9");
    }

    public void selectLoanSubType() {
        new Select(loanSubType).selectByIndex(3);
    }

    public void selectOccupancyType() {
        new Select(occupancyType).selectByIndex(2);
    }

    public void enterLoanRatePercent(String percent) {
        loanRatePercent.clear();
        loanRatePercent.sendKeys(percent);
    }

    public void selectRateType(String value) {
        new Select(rateType).selectByValue(value);
    }

    public void enterLoanAmount(String amount) {
        loanAmount.sendKeys(amount);
    }

    public void enterOutstandingBalance(String amount) {
        outstandingBalance.sendKeys(amount);
    }

    public void enterBalanceDate(String date) {
        balanceDate.sendKeys(date);
    }

    public void enterInitialLoanFundingAmount(String amount) {
        initialLoanFundingAmount.sendKeys(amount);
    }

    public void enterAmountToParticipated(String amount) {
        amountToParticipate.sendKeys(amount);
    }

    public void enterOriginationFees(String feesPercent) {
        originationFees.clear();
        originationFees.sendKeys(feesPercent);
    }
    public void enterServicingFees(String feesPercent) {
        servicingFees.clear();
        servicingFees.sendKeys(feesPercent);
    }

    public void enterInitialServicingFees(String amount){
        initialServicingFees.sendKeys(amount);
    }
    public void enterBankAssessedLoanQuality(){
        bankAssessedLoanQuality.sendKeys("testing");
    }
    public void selectCRAEligibility(String value){
        if(value.equalsIgnoreCase("no")){
            craEligibility.get(0).click();
        }
        else{
            craEligibility.get(1).click();
        }
    }
    public void selectGuarantors(String value){
        new Select(guarantors).selectByValue(value);
    }
    public void selectGuarantorsType(String type){
        if(type.equalsIgnoreCase("amount")){
            guarantorType.get(0).click();
        }
        else {
            guarantorType.get(1).click();
        }
    }
    public void enterGuarantorsAmount(String amount){
        guarantorAmount.sendKeys(amount);
    }
    public void enterTentativeClosingDate(String date) {
        tentativeClosingDate.sendKeys(date);
    }

    public void enterOriginatedDate() {
        originatedDate.sendKeys("05/16/2023");
    }

    public void enterFundingDate() {
        fundingDate.sendKeys("05/16/2023");
    }

    public void enterMaturityDate() {
        maturityDate.sendKeys("05/16/2023");
    }

    public void enterLoanTermMonth() {
        loanTermMonth.sendKeys("3");
    }

    public void enterInterestCalculationMethod() {
        interestCalculationMethod.sendKeys("Simple");
    }
    public void saveTheDetails(){
        saveButton.click();
    }

}
