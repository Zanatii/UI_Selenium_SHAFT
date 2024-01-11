//package tests.recommendations;
//
//import com.shaft.tools.io.JSONFileManager;
//import io.qameta.allure.Description;
//import io.qameta.allure.TmsLink;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pages.LandingPage;
//import tests.base.BaseTest;
//
//public class RecommendationsDataTests extends BaseTest {
//    JSONFileManager questionnaireFlowData = new JSONFileManager("questionnaireFlowData.json");
//    JSONFileManager firstTabsRecommendationData = new JSONFileManager("oneTabRecommendationData.json");
//    JSONFileManager twoTabsRecommendationData = new JSONFileManager("twoTabsRecommendationData.json");
//    JSONFileManager threeTabsRecommendationData = new JSONFileManager("threeTabsRecommendationData.json");
//    // vars
//    LandingPage landingPage;
//
//    @BeforeMethod
//    public void setUp() {
//        landingPage = new LandingPage(driver);
//    }
//
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateMicrosoftBasicManagedData() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A1"),
//                        questionnaireFlowData.getTestData("questions.Q3.A1"),
//                        questionnaireFlowData.getTestData("questions.Q10.A1"),
//                        questionnaireFlowData.getTestData("questions.Q11.A1"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateMicrosoftStandardManagedLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A1"),
//                        questionnaireFlowData.getTestData("questions.Q3.A1"),
//                        questionnaireFlowData.getTestData("questions.Q10.A1"),
//                        questionnaireFlowData.getTestData("questions.Q11.A1"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("2")
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateMicrosoftPremiumManagedLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A1"),
//                        questionnaireFlowData.getTestData("questions.Q3.A1"),
//                        questionnaireFlowData.getTestData("questions.Q10.A1"),
//                        questionnaireFlowData.getTestData("questions.Q11.A1"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("3")
//                .validateSolutionData();
//    }
//
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateMicrosoftTeamsAlternative() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A1"),
//                        questionnaireFlowData.getTestData("questions.Q3.A1"),
//                        questionnaireFlowData.getTestData("questions.Q10.A1"),
//                        questionnaireFlowData.getTestData("questions.Q11.A2"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateMicrosoftTeamsStandard() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A1"),
//                        questionnaireFlowData.getTestData("questions.Q3.A1"),
//                        questionnaireFlowData.getTestData("questions.Q10.A1"),
//                        questionnaireFlowData.getTestData("questions.Q11.A2"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("2")
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateMicrosoftTeamsPremium() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A1"),
//                        questionnaireFlowData.getTestData("questions.Q3.A1"),
//                        questionnaireFlowData.getTestData("questions.Q10.A1"),
//                        questionnaireFlowData.getTestData("questions.Q11.A2"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("3")
//                .validateSolutionData();
//    }
//
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateWorryFreeRedirectionLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A1"),
//                        questionnaireFlowData.getTestData("questions.Q3.A2"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateFatturaRedirectionLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A1"),
//                        questionnaireFlowData.getTestData("questions.Q3.A3"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateSpidRedirectionLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A1"),
//                        questionnaireFlowData.getTestData("questions.Q3.A4"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateBackUpFacile() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A1"),
//                        questionnaireFlowData.getTestData("questions.Q3.A5"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validatePecRedirectionLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A1"),
//                        questionnaireFlowData.getTestData("questions.Q3.A6"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validatePecStandardRedirectionLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A1"),
//                        questionnaireFlowData.getTestData("questions.Q3.A6"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("2")
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validatePecPremiumRedirectionLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A1"),
//                        questionnaireFlowData.getTestData("questions.Q3.A6"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("3")
//                .validateSolutionData();
//    }
//
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validatePresenzaAlternative() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A2"),
//                        questionnaireFlowData.getTestData("questions.Q4.A3"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validatePresenzaStandard() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A2"),
//                        questionnaireFlowData.getTestData("questions.Q4.A3"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("2")
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validatePresenzaPremium() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A2"),
//                        questionnaireFlowData.getTestData("questions.Q4.A3"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("3")
//                .validateSolutionData();
//    }
//
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateSmartCommunicationRedirectionLinkAlternative() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A2"),
//                        questionnaireFlowData.getTestData("questions.Q4.A4"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateSmartCommunicationRedirectionLinkStandard() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A2"),
//                        questionnaireFlowData.getTestData("questions.Q4.A4"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("2")
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateSmartCommunicationRedirectionLinkPremium() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A2"),
//                        questionnaireFlowData.getTestData("questions.Q4.A4"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("3")
//                .validateSolutionData();
//    }
//
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateSocialConnectAlternative() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A2"),
//                        questionnaireFlowData.getTestData("questions.Q4.A5"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateSocialConnectStandard() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A2"),
//                        questionnaireFlowData.getTestData("questions.Q4.A5"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("2")
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateSocialConnectPremium() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A2"),
//                        questionnaireFlowData.getTestData("questions.Q4.A5"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("3")
//                .validateSolutionData();
//    }
//
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateMovyloAlternativeRedirectionLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A2"),
//                        questionnaireFlowData.getTestData("questions.Q4.A6"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateMovyloStandardRedirectionLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A2"),
//                        questionnaireFlowData.getTestData("questions.Q4.A6"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("2")
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateMovyloPremiumRedirectionLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A2"),
//                        questionnaireFlowData.getTestData("questions.Q4.A6"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("3")
//                .validateSolutionData();
//    }
//
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateSmartDigitalMarketingAlternativeRedirectionLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A2"),
//                        questionnaireFlowData.getTestData("questions.Q4.A7"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateSmartDigitalMarketingStandardRedirectionLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A2"),
//                        questionnaireFlowData.getTestData("questions.Q4.A7"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("2")
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateSmartDigitalMarketingPremiumRedirectionLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A2"),
//                        questionnaireFlowData.getTestData("questions.Q4.A7"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("3")
//                .validateSolutionData();
//    }
//
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateSmartTouchAlternative() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A4"),
//                        questionnaireFlowData.getTestData("questions.Q6.A2"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateSmartTouchStandard() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A4"),
//                        questionnaireFlowData.getTestData("questions.Q6.A2"))
//
//                .validateNavigationToRecommendationPage()
//                .selectSpecificTabByIndex("2")
//                .validateSolutionData();
//    }
//
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateVodafoneBusinessSvrRedirectionLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A6"),
//                        questionnaireFlowData.getTestData("questions.Q8.A1"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//
//    // todo -> what is the recommended product
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateNoEdizioniRedirectionLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A6"),
//                        questionnaireFlowData.getTestData("questions.Q8.A2"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//
//    @TmsLink("OPW-")
//    @Description("")
//    @Test
//    public void validateLookOutRedirectionLink() {
//        landingPage.clickGetStartedToQuestionnaireFlow()
//                .completeTheFlowAndNavigateToRecommendations(
//                        questionnaireFlowData.getTestData("questions.Q1.A1"),
//                        questionnaireFlowData.getTestData("questions.Q2.A6"),
//                        questionnaireFlowData.getTestData("questions.Q8.A5"))
//
//                .validateNavigationToRecommendationPage()
//                .validateSolutionData();
//    }
//
//
//}
