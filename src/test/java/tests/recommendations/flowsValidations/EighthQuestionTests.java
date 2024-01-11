package tests.recommendations.flowsValidations;

import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import tests.base.BaseTest;

public class EighthQuestionTests extends BaseTest {
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


    /*
        Eighth question flow
 */
    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateEighthQuestionFirstAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A6"),
                        questionnaireFlowData.getTestData("questions.Q8.A1"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", firstTabsRecommendationData.getTestData("sixthProduct.name"));
    }

    // todo -> what is the recommended product
    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateEighthQuestionSecondAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A6"),
                        questionnaireFlowData.getTestData("questions.Q8.A2"))

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
    public void validateEighthQuestionThirdAnswerFlowRecommendations1() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A6"),
                        questionnaireFlowData.getTestData("questions.Q8.A3"),
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
    public void validateEighthQuestionThirdAnswerFlowRecommendations2() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A6"),
                        questionnaireFlowData.getTestData("questions.Q8.A3"),
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
    public void validateEighthQuestionThirdAnswerFlowRecommendations3() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A6"),
                        questionnaireFlowData.getTestData("questions.Q8.A3"),
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
    public void validateEighthQuestionThirdAnswerFlowRecommendations4() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A6"),
                        questionnaireFlowData.getTestData("questions.Q8.A3"),
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
    public void validateEighthQuestionFourthAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A6"),
                        questionnaireFlowData.getTestData("questions.Q8.A4"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", firstTabsRecommendationData.getTestData("fourthProduct.recommendedTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateEighthQuestionFifthAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A6"),
                        questionnaireFlowData.getTestData("questions.Q8.A5"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", threeTabsRecommendationData.getTestData("eighthProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", threeTabsRecommendationData.getTestData("eighthProduct.premiumTab.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", threeTabsRecommendationData.getTestData("eighthProduct.alternativeTab.name"));
    }
    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateEighthQuestionSixthAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A6"),
                        questionnaireFlowData.getTestData("questions.Q8.A6"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", firstTabsRecommendationData.getTestData("sixthProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", threeTabsRecommendationData.getTestData("sixthProduct.premiumTab.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", threeTabsRecommendationData.getTestData("sixthProduct.alternativeTab.name"));
    }
}
