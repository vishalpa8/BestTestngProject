package tests.CreateNewParticipation;

import com.Banklabs.pages.HomePage;
import com.Banklabs.pages.LoginPage;
import com.Banklabs.pages.OpportunityPage.BorrowerSection;
import dataproviders.YamlDataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.Map;

public class CreateNewParticipationTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    BorrowerSection borrowerSection;


    @BeforeClass
    public void classSetup(){
        loginPage = initElements(LoginPage.class);
        borrowerSection = initElements(BorrowerSection.class);
    }

    @Test(description = "Agriculture Crop Production Loan", dataProvider = "testData-dataSource", dataProviderClass = YamlDataProvider.class)
    public void BLP_1510_Proper_fields_are_presented_when_creating_Agriculture_Crop_Production_Loan(Map<String,String> data){
        homePage = loginPage.clickSigin().fillDetails();

        String opportunityType = homePage.createNewParticipation()
                                        .clickOriginatorPencil()
                                        .opportunityType();

        String loanTotalAmount = borrowerSection.editBorrowerDetails()
                .editDescriptionDetails(data)
                .editStatisticsDetails(data)
                .editPreliminaryDetails()
                .getTotalLoanAmount();


        Assert.assertEquals(opportunityType,data.get("opportunityType"),"We Are Not on Opportunity Page");

        Assert.assertTrue(data.get("loanAmount").contains(loanTotalAmount),"Total Loan Amount is different from give one.");

    }


}
