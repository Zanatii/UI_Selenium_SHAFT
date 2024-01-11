import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import tests.base.BaseTest;

public class LoadingTests extends BaseTest {
    JSONFileManager questionnaireFlowData = new JSONFileManager("questionnaireFlowData.json");
    LandingPage landingPage;


    @BeforeClass
    public void setUp() {
        landingPage = new LandingPage(driver);
    }

    @TmsLink("OPW-2899")
    @Description("Validating that there is a loading indicator that displaying in the previous page before the recommendation page")
    @Test
    public void validateLoadingIndicationsWhileRecommendationsLoad() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A1"))
                .clickContinueButton()
                .validateLoadingIndicatorDisplaying();
    }
}
