package tests.userPermissionPage;

import com.Banklabs.pages.HomePage;
import com.Banklabs.pages.LoginPage;
import com.Banklabs.pages.OpportunityPage.BorrowerSection;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tests.Base.BaseTest;

import java.util.Map;


public class UserPermissionPageTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    BorrowerSection borrowerSection;


    @BeforeClass
    public void classSetup(){
        loginPage = initElements(LoginPage.class);
        borrowerSection = initElements(BorrowerSection.class);
    }

    @Test
    public void BLP_1465_Validate_Create_New_Participation_with_Unauthorized_User_affiliated_with_Bank(Map<String,String> data){
        homePage = loginPage.clickSigin().fillDetails();

        String opportunityType = homePage.createNewParticipation()
                                          .clickOriginatorPencil()
                                            .opportunityType();

        borrowerSection.editBorrowerDetails()
                .editDescriptionDetails(data).editStatisticsDetails(data);


        Assert.assertEquals(opportunityType,"Participation New");
    }

}
