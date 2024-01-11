package tests.recommendations.flowsValidations;

import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import tests.base.BaseTest;

public class NinthQuestionTests extends BaseTest {
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
    public void validateNinthQuestionFirstAnswerFlowRecommendations1() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A7"),
                        questionnaireFlowData.getTestData("questions.Q9.A1"),
                        questionnaireFlowData.getTestData("questions.Q10.A1"),
                        questionnaireFlowData.getTestData("questions.Q11.A1"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", firstTabsRecommendationData.getTestData("tenthProduct.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", firstTabsRecommendationData.getTestData("eleventhProduct.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", firstTabsRecommendationData.getTestData("ninthProduct.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateNinthQuestionFirstAnswerFlowRecommendations2() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A7"),
                        questionnaireFlowData.getTestData("questions.Q9.A1"),
                        questionnaireFlowData.getTestData("questions.Q10.A1"),
                        questionnaireFlowData.getTestData("questions.Q11.A2"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", threeTabsRecommendationData.getTestData("firstProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", threeTabsRecommendationData.getTestData("firstProduct.premiumTab.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", threeTabsRecommendationData.getTestData("firstProduct.alternativeTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateNinthQuestionFirstAnswerFlowRecommendations3() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A7"),
                        questionnaireFlowData.getTestData("questions.Q9.A1"),
                        questionnaireFlowData.getTestData("questions.Q10.A2"),
                        questionnaireFlowData.getTestData("questions.Q12.A1"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", firstTabsRecommendationData.getTestData("tenthProduct.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", firstTabsRecommendationData.getTestData("eleventhProduct.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", firstTabsRecommendationData.getTestData("ninthProduct.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateNinthQuestionFirstAnswerFlowRecommendations4() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A7"),
                        questionnaireFlowData.getTestData("questions.Q9.A1"),
                        questionnaireFlowData.getTestData("questions.Q10.A2"),
                        questionnaireFlowData.getTestData("questions.Q12.A2"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", threeTabsRecommendationData.getTestData("firstProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", threeTabsRecommendationData.getTestData("firstProduct.premiumTab.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", threeTabsRecommendationData.getTestData("firstProduct.alternativeTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateNinthQuestionSecondAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A7"),
                        questionnaireFlowData.getTestData("questions.Q9.A2"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(1)
                .validateProductName("0", firstTabsRecommendationData.getTestData("fourthProduct.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateNinthQuestionThirdAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A7"),
                        questionnaireFlowData.getTestData("questions.Q9.A3"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(1)
                .validateProductName("0", firstTabsRecommendationData.getTestData("eighthProduct.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateNinthQuestionFourthAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A7"),
                        questionnaireFlowData.getTestData("questions.Q9.A4"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(1)
                .validateProductName("0", firstTabsRecommendationData.getTestData("sixthProduct.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateNinthQuestionFifthAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A7"),
                        questionnaireFlowData.getTestData("questions.Q9.A5"))

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
