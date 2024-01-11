import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.QuestionnaireFlow;
import tests.base.BaseTest;

public class ProductPageTests extends BaseTest {
    JSONFileManager questionnaireFlowData = new JSONFileManager("questionnaireFlowData.json");
    JSONFileManager recommendationPageData = new JSONFileManager("recommendationPageData.json");
    LandingPage landingPage;
    QuestionnaireFlow questionnaireFlow;


    @BeforeClass
    public void setUp() {
        landingPage = new LandingPage(driver);
        questionnaireFlow = new QuestionnaireFlow(driver);
        landingPage = new LandingPage(driver);
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateBrowserBackFunctionality() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A1"),
                        questionnaireFlowData.getTestData("questions.Q3.A1"))
                .clickContinue("0")
                .clickBrowserBackBtn()
                .validateNavigationToRecommendationPage();
    }
}
