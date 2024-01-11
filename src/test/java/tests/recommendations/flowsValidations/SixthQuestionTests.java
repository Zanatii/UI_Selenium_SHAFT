package tests.recommendations.flowsValidations;

import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import tests.base.BaseTest;

public class SixthQuestionTests extends BaseTest {
    JSONFileManager questionnaireFlowData = new JSONFileManager("questionnaireFlowData.json");
    JSONFileManager firstTabsRecommendationData = new JSONFileManager("oneTabRecommendationData.json");
    JSONFileManager twoTabsRecommendationData = new JSONFileManager("twoTabsRecommendationData.json");
    JSONFileManager threeTabsRecommendationData = new JSONFileManager("threeTabsRecommendationData.json");
    // vars
    LandingPage landingPage;

    @BeforeMethod
    public void setUp() {
        landingPage = new LandingPage(driver);
    }


    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateSixthQuestionFirstAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A4"),
                        questionnaireFlowData.getTestData("questions.Q6.A1"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", threeTabsRecommendationData.getTestData("secondProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", threeTabsRecommendationData.getTestData("secondProduct.premiumTab.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", threeTabsRecommendationData.getTestData("secondProduct.alternativeTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateSixthQuestionSecondAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A4"),
                        questionnaireFlowData.getTestData("questions.Q6.A2"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(2)
                .validateProductName("0", twoTabsRecommendationData.getTestData("firstProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", twoTabsRecommendationData.getTestData("firstProduct.alternativeTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateSixthQuestionThirdAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A4"),
                        questionnaireFlowData.getTestData("questions.Q6.A3"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", firstTabsRecommendationData.getTestData("thirdProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", firstTabsRecommendationData.getTestData("thirdProduct.premiumTab.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", firstTabsRecommendationData.getTestData("thirdProduct.alternativeTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateSixthQuestionFourthAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A4"),
                        questionnaireFlowData.getTestData("questions.Q5.A4"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", threeTabsRecommendationData.getTestData("fourthProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", threeTabsRecommendationData.getTestData("fourthProduct.premiumTab.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", threeTabsRecommendationData.getTestData("fourthProduct.alternativeTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateSixthQuestionFifthAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A4"),
                        questionnaireFlowData.getTestData("questions.Q6.A5"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", firstTabsRecommendationData.getTestData("fifthProduct.recommendedTab.name"));
    }
    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateSixthQuestionSixthAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A4"),
                        questionnaireFlowData.getTestData("questions.Q6.A6"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", threeTabsRecommendationData.getTestData("fifthProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", threeTabsRecommendationData.getTestData("fifthProduct.premiumTab.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", threeTabsRecommendationData.getTestData("fifthProduct.alternativeTab.name"));
    }
    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateSixthQuestionSeventhAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A4"),
                        questionnaireFlowData.getTestData("questions.Q6.A7"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", threeTabsRecommendationData.getTestData("sixthProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", threeTabsRecommendationData.getTestData("sixthProduct.premiumTab.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", threeTabsRecommendationData.getTestData("sixthProduct.alternativeTab.name"));
    }

}
