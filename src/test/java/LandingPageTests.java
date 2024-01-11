import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import tests.base.BaseTest;

public class LandingPageTests extends BaseTest {
    JSONFileManager questionnaireFlowData = new JSONFileManager("questionnaireFlowData.json");
    LandingPage landingPage;

    @BeforeClass
    public void setUp() {
        landingPage = new LandingPage(driver);
    }

    @TmsLink("OPW-2873")
    @Description("Validate that clicking on the Get Started button will launch the guided selling overlay")
    @Test
    public void validateGetStartedBtnFunctionality() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q1.title"));
    }

}
