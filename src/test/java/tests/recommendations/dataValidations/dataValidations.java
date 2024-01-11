package tests.recommendations.dataValidations;
import com.shaft.tools.io.JSONFileManager;
import org.bouncycastle.util.Arrays;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import tests.base.BaseTest;

public class dataValidations extends BaseTest {

    JSONFileManager questionnaireFlowData = new JSONFileManager("questionnaireFlowData.json");
    JSONFileManager firstTabsRecommendationData = new JSONFileManager("oneTabRecommendationData.json");
    JSONFileManager twoTabsRecommendationData = new JSONFileManager("twoTabsRecommendationData.json");
    JSONFileManager threeTabsRecommendationData = new JSONFileManager("threeTabsRecommendationData.json");
    LandingPage landingPage;
    @BeforeMethod
    public void setUp (){
        landingPage = new LandingPage(driver);
    }

    @Test
    public void testing(){
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A6"),
                        questionnaireFlowData.getTestData("questions.Q8.A1"))
                .getProductFeature("0","0", firstTabsRecommendationData.getTestData("sixthProduct.Features[0]"));
    }


}
