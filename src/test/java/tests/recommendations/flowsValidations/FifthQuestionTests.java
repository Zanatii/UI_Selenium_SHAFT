package tests.recommendations.flowsValidations;

import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import tests.base.BaseTest;

public class FifthQuestionTests extends BaseTest {
    JSONFileManager questionnaireFlowData = new JSONFileManager("questionnaireFlowData.json");
    JSONFileManager firstTabsRecommendationData = new JSONFileManager("oneTabRecommendationData.json");
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
    public void validateFifthQuestionFirstAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A3"),
                        questionnaireFlowData.getTestData("questions.Q5.A1"))

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
    public void validateFifthQuestionSecondAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A3"),
                        questionnaireFlowData.getTestData("questions.Q5.A2"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", threeTabsRecommendationData.getTestData("thirdProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", threeTabsRecommendationData.getTestData("thirdProduct.premiumTab.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", threeTabsRecommendationData.getTestData("thirdProduct.alternativeTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateFifthQuestionThirdAnswerFlowRecommendations1() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A3"),
                        questionnaireFlowData.getTestData("questions.Q5.A3"),
                        questionnaireFlowData.getTestData("questions.Q10.A1"),
                        questionnaireFlowData.getTestData("questions.Q11.A1"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", firstTabsRecommendationData.getTestData("tenthProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", firstTabsRecommendationData.getTestData("eleventhProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", firstTabsRecommendationData.getTestData("ninthProduct.recommendedTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateFourthQuestionThirdAnswerFlowRecommendations2() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A3"),
                        questionnaireFlowData.getTestData("questions.Q5.A3"),
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
    public void validateFourthQuestionThirdAnswerFlowRecommendations3() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A3"),
                        questionnaireFlowData.getTestData("questions.Q5.A3"),
                        questionnaireFlowData.getTestData("questions.Q10.A2"),
                        questionnaireFlowData.getTestData("questions.Q12.A1"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", firstTabsRecommendationData.getTestData("tenthProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", firstTabsRecommendationData.getTestData("eleventhProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", firstTabsRecommendationData.getTestData("ninthProduct.recommendedTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateFourthQuestionThirdAnswerFlowRecommendations4() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A3"),
                        questionnaireFlowData.getTestData("questions.Q5.A3"),
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
    public void validateFifthQuestionFourthAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A3"),
                        questionnaireFlowData.getTestData("questions.Q5.A4"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(1)
                .validateProductName("0", firstTabsRecommendationData.getTestData("firstProduct.recommendedTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateFifthQuestionFifthAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A3"),
                        questionnaireFlowData.getTestData("questions.Q5.A5"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(1)
                .validateProductName("0", firstTabsRecommendationData.getTestData("secondProduct.recommendedTab.name"));
    }
    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateFifthQuestionSixthAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A3"),
                        questionnaireFlowData.getTestData("questions.Q5.A6"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(1)
                .validateProductName("0", firstTabsRecommendationData.getTestData("fifthProduct.recommendedTab.name"));
    }
    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateFifthQuestionSeventhAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A3"),
                        questionnaireFlowData.getTestData("questions.Q5.A7"))

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
    public void validateFifthQuestionEighthAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A3"),
                        questionnaireFlowData.getTestData("questions.Q5.A8"))

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
