package tests.recommendations;

import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import tests.base.BaseTest;

public class RecommendationPageTests extends BaseTest {
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
    @Description("Validating that the selected price remain without any changes when navigate forward to recommendation page then press back to the price page")
    @Test
    public void validateModalBackBtnFunctionality() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                   .completeTheFlowAndNavigateToRecommendations(questionnaireFlowData.getTestData("questions.Q1.A1"),
                                                                questionnaireFlowData.getTestData("questions.Q2.A1"),
                                                                questionnaireFlowData.getTestData("questions.Q3.A1"))
                   .clickBackButton()
                   .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q3.title"))
                   .validateQuestionDataIsPersisted(questionnaireFlowData.getTestData("questions.Q3.A1"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateSpecificFlowRecommendOnlyOneProduct() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A1"),
                        questionnaireFlowData.getTestData("questions.Q3.A3"))
                .validateNumberOfTabs(1);
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateSpecificFlowRecommendOnlyTwoProduct() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A4"),
                        questionnaireFlowData.getTestData("questions.Q6.A2"))
                .validateNumberOfTabs(2);
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateSpecificFlowRecommendThreeProduct() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A1"),
                        questionnaireFlowData.getTestData("questions.Q3.A1"))
                .validateNumberOfTabs(3);
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateDataPersistenceAfterReopeningTheModal() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(questionnaireFlowData.getTestData("questions.Q1.A1"),
                                                             questionnaireFlowData.getTestData("questions.Q2.A1"),
                                                             questionnaireFlowData.getTestData("questions.Q3.A1"))
                .validateNavigationToRecommendationPage()
                .clickCloseButton().validateNavigationToTheLandingPage()
                .clickGetStartedToBackToRecommendationPage()
                .validateNavigationToRecommendationPage();
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateNavigationBetweenTabs() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A1"),
                        questionnaireFlowData.getTestData("questions.Q3.A1"))
                .validateNavigationToRecommendationPage()
                .validateSpecificTabIsSelected("1")
                .validateProductName("0", "M365 NCE M365 Business Standard")

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", "M365 NCE M365 Business Premium")

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", "M365 NCE Microsoft Teams Essentials");
    }

    /*
            Third question flows
     */

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
                .validateProductName("0", firstTabsRecommendationData.getTestData("firstProduct.name"));
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
                .validateProductName("0", firstTabsRecommendationData.getTestData("secondProduct.name"));
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
                .validateProductName("0", firstTabsRecommendationData.getTestData("thirdProduct.name"));
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
                .validateProductName("0", firstTabsRecommendationData.getTestData("fourthProduct.name"));
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

    /*
            Fourth question flows
     */
    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateFourthQuestionFirstAnswerFlowRecommendations1() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A2"),
                        questionnaireFlowData.getTestData("questions.Q4.A1"),
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
    public void validateFourthQuestionFirstAnswerFlowRecommendations2() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A2"),
                        questionnaireFlowData.getTestData("questions.Q4.A1"),
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
    public void validateFourthQuestionFirstAnswerFlowRecommendations3() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A2"),
                        questionnaireFlowData.getTestData("questions.Q4.A1"),
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
    public void validateFourthQuestionFirstAnswerFlowRecommendations4() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A2"),
                        questionnaireFlowData.getTestData("questions.Q4.A1"),
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
    public void validateFourthQuestionSecondAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A2"),
                        questionnaireFlowData.getTestData("questions.Q4.A2"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(1)
                .validateProductName("0", firstTabsRecommendationData.getTestData("firstProduct.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateFourthQuestionThirdAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A2"),
                        questionnaireFlowData.getTestData("questions.Q4.A3"))

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
    public void validateFourthQuestionFourthAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A2"),
                        questionnaireFlowData.getTestData("questions.Q4.A4"))

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
    public void validateFourthQuestionFifthAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A2"),
                        questionnaireFlowData.getTestData("questions.Q4.A5"))

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
    public void validateFourthQuestionSixthAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A2"),
                        questionnaireFlowData.getTestData("questions.Q4.A6"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(1)
                .validateProductName("0", firstTabsRecommendationData.getTestData("fifthProduct.recommendedTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateFourthQuestionSeventhAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A2"),
                        questionnaireFlowData.getTestData("questions.Q4.A7"))

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
    public void validateFourthQuestionEighthAnswerRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A2"),
                        questionnaireFlowData.getTestData("questions.Q4.A8"))

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

    /*
            Fifth question flow
     */
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
                        questionnaireFlowData.getTestData("questions.Q5.A1"))

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
                .validateNumberOfTabs(3)
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
                .validateNumberOfTabs(3)
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
                .validateNumberOfTabs(3)
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

    /*
            Sixth question flow
     */
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
                .validateNumberOfTabs(3)
                .validateProductName("0", twoTabsRecommendationData.getTestData("secondProduct.recommendedTab.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", twoTabsRecommendationData.getTestData("secondProduct.premiumTab.name"));
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
                .validateProductName("0", firstTabsRecommendationData.getTestData("thirdProduct.name"))

                .selectSpecificTabByName("Soluzione Premium")
                .validateSpecificTabIsSelected("2")
                .validateProductName("1", firstTabsRecommendationData.getTestData("thirdProduct.name"))

                .selectSpecificTabByName("Soluzione Alternativa")
                .validateSpecificTabIsSelected("3")
                .validateProductName("2", firstTabsRecommendationData.getTestData("thirdProduct.name"));
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
    /*
            Seventh question flow
     */
    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateSeventhQuestionFirstAnswerFlowRecommendations1() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A5"),
                        questionnaireFlowData.getTestData("questions.Q7.A1"),
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
    public void validateSeventhQuestionFirstAnswerFlowRecommendations2() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A5"),
                        questionnaireFlowData.getTestData("questions.Q7.A1"),
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
    public void validateSeventhQuestionFirstAnswerFlowRecommendations3() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A5"),
                        questionnaireFlowData.getTestData("questions.Q7.A1"),
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
    public void validateSeventhQuestionFirstAnswerFlowRecommendations4() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A5"),
                        questionnaireFlowData.getTestData("questions.Q7.A1"),
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
    public void validateSeventhQuestionSecondAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A5"),
                        questionnaireFlowData.getTestData("questions.Q7.A2"))

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
    public void validateSeventhQuestionThirdAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A5"),
                        questionnaireFlowData.getTestData("questions.Q7.A3"))

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
    public void validateSeventhQuestionFourthAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A5"),
                        questionnaireFlowData.getTestData("questions.Q7.A4"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", firstTabsRecommendationData.getTestData("fifthProduct.recommendedTab.name"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateSeventhQuestionFifthAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A5"),
                        questionnaireFlowData.getTestData("questions.Q7.A5"))

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
    public void validateSeventhQuestionSixthAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A5"),
                        questionnaireFlowData.getTestData("questions.Q7.A6"))

                .validateNavigationToRecommendationPage()
                .validateNumberOfTabs(3)
                .validateProductName("0", firstTabsRecommendationData.getTestData("fourthProduct.recommendedTab.name"));
    }
    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateSeventhQuestionSeventhAnswerFlowRecommendations() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .completeTheFlowAndNavigateToRecommendations(
                        questionnaireFlowData.getTestData("questions.Q1.A1"),
                        questionnaireFlowData.getTestData("questions.Q2.A5"),
                        questionnaireFlowData.getTestData("questions.Q7.A7"))

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

     /*
            Ninth question flows
     */

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



















    /*//////////////////////////////////////

                  OLD

     */////////////////////////////////
//    @TmsLink("OPW-1403")
//    @Description("Validating that the recommended device is selected by default once we enter the recommendation page first time without any changes")
//    @Test
//    public void validateTheRecommendedDeviceIsSelectedByDefault(){
//        new LandingPage(driver).clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(firstQuestionYesAnswer, searchingDevice)
//                .validateProductName(searchingDevice)
//                .validateSpecificTabIsSelected("1");
//    }
//
//    @TmsLink("OPW-1674")
//    @Description("Validate that guided selling app will be closed when clicking on close button in the Recommendations page in phone only journey")
//    @Test
//    public void theSelectedTabIsPersistedUponClosingAndReopeningTheApp() {
//        String deviceNameInSecondTab = new LandingPage(driver).clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(firstQuestionYesAnswer, searchingDevice)
//                .validateProductName(searchingDevice)
//                .selectSpecificTabByIndex("2")
//                .getDeviceName("2");
//        // closing the modal while second tab is opened
//        // and reopening the modal to validate it opens on the second tab
//        String deviceNameInThirdTab = new RecommendationPage(driver).clickCloseButton()
//                .clickGetStartedToBackToRecommendationPage()
//                .validateProductName(deviceNameInSecondTab)
//                // closing the modal while third tab is opened
//                // and reopening the modal to validate it opens on the third tab
//                .selectSpecificTabByIndex("3")
//                .getDeviceNameWhenReopeningGSAfterClickingClose();
//        new RecommendationPage(driver).clickCloseButton()
//                .clickGetStartedToBackToRecommendationPage()
//                .validateProductName(deviceNameInThirdTab);
//    }
//
//    @TmsLink("OPW-1685")
//    @Description("Validate that changing Memory will Reflect on the price in the Recommendations page in phone only journey")
//    @Test
//    public void testChangingInDevicePriceUponChangingMemory(){
//        String devicePriceBeforeChangingCapacity =
//                new LandingPage(driver).clickGetStartedToQuestionnaireFlow()
//                                .completeTheFlowAndNavigateToRecommendations(firstQuestionYesAnswer, searchingDevice)
//                                .getPriceText();
//
//                new RecommendationPage(driver).selectMemory(memoryToSelect)
//                        .validateRecommendedPriceChangesWithCapacity(devicePriceBeforeChangingCapacity);
//
//    }
//
//    // todo tabs is data
//    @TmsLink("OPW-1716")
//    @Description("Validating that the retrieved devices from recommendation page are with same selected brand same as user selected from brand selection screen")
//    @Test
//    public void validateAllRecommendedDevicesRelatedToSelectedBrand(){
//        new LandingPage(driver).clickGetStartedToQuestionnaireFlow()
//                     .completeHelpMeChooseFlowAndNavigateToRecommendations(firstQuestionHelpMeChooseAnswer, secondQuestionFirstAnswer, appleBrand, fourthQuestionThirdAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, 0)
//                     .validateDeviceNameContainBrandName(appleBrand)
//                     .selectSpecificTab("2")
//                     .validateDeviceNameContainBrandName(appleBrand)
//                     .selectSpecificTab("3")
//                     .validateDeviceNameContainBrandName(appleBrand);
//    }
//
//    @TmsLink("OPW-1706")
//    @Description("Validate that the Back button will navigate the user back to the pricing page when navigating to the Recommendations page from the questions flow in phone only journey")
//    @Test
//    public void validateBackBtnFunctionalityToPricingPage(){
//        new LandingPage(driver).clickGetStartedToQuestionnaireFlow()
//                        .completeHelpMeChooseFlowAndNavigateToRecommendations(firstQuestionHelpMeChooseAnswer, secondQuestionFirstAnswer, appleBrand, fourthQuestionThirdAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, 0)
//                        .clickBackButton()
//                        .validateUserNavigatedToPricingPage();
//    }
//
//    @TmsLink("OPW-1671")
//    @Description("Validate that the Back button will navigate the user back to the search page when navigating to the Recommendations page from the search page in phone only journey")
//    @Test
//    public void validateBackBtnFunctionalityToSearchPage(){
//        new LandingPage(driver).clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(firstQuestionYesAnswer, searchingDevice)
//                .validateNavigationToRecommendationPage(recommendationPageData.getTestData("pageTitle"))
//                .clickBackButton()
//                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.searchPage.title"));
//    }
//
//    @TmsLink("OPW-1422")
//    @Description("Validating that changing in selected budget from price slider page may affect on the recommendation devices and change them to another devices")
//    @Test
//    public void validateChangingPriceAffectsRecommendedDevice(){
//        String deviceNameWithBeforeChangingDevice = new LandingPage(driver).clickGetStartedToQuestionnaireFlow()
//                        .completeHelpMeChooseFlowAndNavigateToRecommendations(firstQuestionHelpMeChooseAnswer, secondQuestionFirstAnswer, appleBrand, fourthQuestionThirdAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, 0)
//                        .getDeviceName("1");
//        new RecommendationPage(driver).clickBackButton()
//                        .selectPrice(unitsToIncreasePriceWith)
//                        .clickNextToNavigateToRecommendationPage()
//                        .validateDeviceChanged(deviceNameWithBeforeChangingDevice);
//    }
//
//    // todo -> revisit
//    @TmsLink("OPW-1689")
//    @Description("Validate the displaying data for each recommended device in the Recommendations page in phone only journey")
//    @Test
//    public void validateRecommendedDevicesData(){
//        new LandingPage(driver).clickGetStartedToQuestionnaireFlow()
//                .completeHelpMeChooseFlowAndNavigateToRecommendations(firstQuestionHelpMeChooseAnswer, secondQuestionFirstAnswer, appleBrand, fourthQuestionThirdAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, 0)
//                .validateExistenceOfRecommendedDeviceData("1", numberOfTopFeatures)
//                .selectSpecificTab("2")
//                .validateExistenceOfRecommendedDeviceData("2", numberOfTopFeatures)
//                .selectSpecificTab("3")
//                .validateExistenceOfRecommendedDeviceData("3", numberOfTopFeatures);
//    }
//
//    @TmsLink("OPW-1675")
//    @Description("Validate that Top characteristics will displayed and extend when clicking on Specifications button in Recommendations page in phone only journey")
//    @Test
//    public void validateDisplayingOfTopFeatures(){
//        new LandingPage(driver).clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(firstQuestionYesAnswer, searchingDevice)
//                .clickSpecificationsExtend()
//                .validateExistenceOfTopFeatures("1", numberOfTopFeatures);
//    }
//
//    // todo -> make sure which scenario ?
//    @TmsLink("OPW-1402")
//    @Description("Number Of Recommendations")
//    @Test
//    public void validateNumberOfRecommendations(){
//        new LandingPage(driver).clickGetStartedToQuestionnaireFlow()
//                    .completeTheFlowAndNavigateToRecommendations(firstQuestionYesAnswer, searchingDevice)
//                    .validateNumberOfRecommendations(3);
//    }
//
//    @TmsLink("OPW-1686")
//    @Description("Validate that Changing the Color will change the device image in the Recommendations page in phone only journey")
//    @Test
//    public void validateDeviceImagesChangesUponChangingColor() {
//        new LandingPage(driver).clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(firstQuestionYesAnswer, searchingDevice)
//                .selectColor(recommendationPageData.getTestData("testData.colorToSelect"))
//                .validateSelectedColor(recommendationPageData.getTestData("testData.colorToSelect"), recommendationPageData.getTestData("testData.colorHexaCode"))
//                .validateImageChangedUponChangingDeviceColor(recommendationPageData.getTestData("testData.colorInEnglish"));
//    }
//
//    @TmsLink("OPW-1419")
//    @Description("Validating that user will get different devices on device recommendation page each time he goes with different selections through phones journey")
//    @Test
//    public void validateRecommendationsChangeByChangingDevicesBrand() {
//        new LandingPage(driver).clickGetStartedToQuestionnaireFlow()
//                .completeHelpMeChooseFlowAndNavigateToRecommendations(firstQuestionHelpMeChooseAnswer, secondQuestionFirstAnswer, appleBrand, fourthQuestionThirdAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, 0)
//                .validateDeviceNameContainBrandName(appleBrand)
//                .selectSpecificTab("2")
//                .validateDeviceNameContainBrandName(appleBrand)
//                .selectSpecificTab("3")
//                .validateDeviceNameContainBrandName(appleBrand)
//
//                .refreshTheApp()
//                .clickGetStartedToQuestionnaireFlow()
//                .completeHelpMeChooseFlowAndNavigateToRecommendations(firstQuestionHelpMeChooseAnswer, secondQuestionFirstAnswer, xiaomiBrand, fourthQuestionThirdAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, 0)
//                .validateDeviceNameContainBrandName(xiaomiBrand)
//                .selectSpecificTab("2")
//                .validateDeviceNameContainBrandName(xiaomiBrand)
//                .selectSpecificTab("3")
//                .validateDeviceNameContainBrandName(xiaomiBrand);
//    }
//
//    // todo -> make the assertion with 2 arrays  of devices
//    @TmsLink("OPW-1420")
//    @Description("Validating that the recommendations devices may be changed to another devices while change the selected screen size")
//    @Test
//    public void validateRecommendationsChangeByChangingScreenSizeSelection() {
//        // getting devices names before changing the answer and getting new devices
//        String bestFitDeviceBeforeChangingAnswers =
//                new LandingPage(driver).clickGetStartedToQuestionnaireFlow()
//                .completeHelpMeChooseFlowAndNavigateToRecommendations(firstQuestionHelpMeChooseAnswer, questionnaireFlowData.getTestData("questions.Q2.A2"), questionnaireFlowData.getTestData("questions.Q3.A1"), questionnaireFlowData.getTestData("questions.Q4.A2"), fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, 0)
//                .getDeviceName("1");
//        String secondTabDeviceName =
//                new RecommendationPage(driver).selectSpecificTabByIndex("2")
//                .getDeviceName("2");
//        String thirdTabDeviceName =
//                new RecommendationPage(driver).selectSpecificTabByIndex("3")
//                .getDeviceName("3");
//        // changing the answer and validate devices changed
//        new RecommendationPage(driver).refreshTheApp()
//                .clickGetStartedToQuestionnaireFlow()
//                .completeHelpMeChooseFlowAndNavigateToRecommendations(firstQuestionHelpMeChooseAnswer, questionnaireFlowData.getTestData("questions.Q2.A2"), questionnaireFlowData.getTestData("questions.Q3.A1"), questionnaireFlowData.getTestData("questions.Q4.A4"), fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, 0)
//                .validateDeviceChanged(bestFitDeviceBeforeChangingAnswers)
//                .selectSpecificTab("2")
//                .validateDeviceChanged(secondTabDeviceName)
//                .selectSpecificTab("3")
//                .validateDeviceChanged(thirdTabDeviceName);
//    }
//
//    @TmsLink("OPW-1418")
//    @Description("Alter answer after recommendations - 1")
//    @Test
//    public void validateChangingDeviceTypeQuestionAnswerChangesRecommendations() {
//        // getting devices names before changing the answer and getting new devices
//        String bestFitDeviceBeforeChangingAnswers =
//                                new LandingPage(driver).clickGetStartedToQuestionnaireFlow()
//                                .completeHelpMeChooseFlowAndNavigateToRecommendations(firstQuestionHelpMeChooseAnswer, secondQuestionFirstAnswer, appleBrand, fourthQuestionThirdAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, 0)
//                                 .getDeviceName("1");
//        String secondTabDeviceBeforeChangingAnswers =
//                                new RecommendationPage(driver).selectSpecificTabByIndex("2")
//                                .getDeviceName("2");
//        String thirdTabDeviceBeforeChangingAnswers =
//                                new RecommendationPage(driver).selectSpecificTabByIndex("3")
//                                .getDeviceName("3");
//        // changing the answer and validate devices changed
//        new RecommendationPage(driver).refreshTheApp()
//                                .clickGetStartedToQuestionnaireFlow()
//                                .completeHelpMeChooseFlowAndNavigateToRecommendations(firstQuestionHelpMeChooseAnswer, questionnaireFlowData.getTestData("questions.Q2.A2"), appleBrand, fourthQuestionThirdAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, fifthQuestionSecondAnswer, 0)
//                                .validateDeviceChanged(bestFitDeviceBeforeChangingAnswers)
//                                .selectSpecificTab("2")
//                                .validateDeviceChanged(secondTabDeviceBeforeChangingAnswers)
//                                .selectSpecificTab("3")
//                                .validateDeviceChanged(thirdTabDeviceBeforeChangingAnswers);
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.browser().refreshCurrentPage();
//    }
//
}
