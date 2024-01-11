package tests.recommendations.flowsValidations;

import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import tests.base.BaseTest;

public class ThirdQuestionTests extends BaseTest {
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
    public void validateFirstFlowRecommendations_part1() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A1"),
                        questionnaireFlowData.getTestData("questions.Q3.A1"),
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
    public void validateFirstFlowRecommendations_part2() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A1"),
                        questionnaireFlowData.getTestData("questions.Q3.A1"),
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
    public void validateFirstFlowRecommendations_part3() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A1"),
                        questionnaireFlowData.getTestData("questions.Q3.A1"),
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
    public void validateFirstFlowRecommendations_part4() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A1"),
                        questionnaireFlowData.getTestData("questions.Q3.A1"),
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
    public void validateSecondFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A1"),
                        questionnaireFlowData.getTestData("questions.Q3.A2"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(1)
                .validateProductName("0", firstTabsRecommendationData.getTestData("firstProduct.recommendedTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateThirdFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A1"),
                        questionnaireFlowData.getTestData("questions.Q3.A3"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(1)
                .validateProductName("0", firstTabsRecommendationData.getTestData("secondProduct.recommendedTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateFourthFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A1"),
                        questionnaireFlowData.getTestData("questions.Q3.A4"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(1)
                .validateProductName("0", firstTabsRecommendationData.getTestData("thirdProduct.recommendedTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateFifthFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A1"),
                        questionnaireFlowData.getTestData("questions.Q3.A5"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(1)
                .validateProductName("0", firstTabsRecommendationData.getTestData("fourthProduct.recommendedTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateSixthFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A1"),
                        questionnaireFlowData.getTestData("questions.Q3.A6"))

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

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}