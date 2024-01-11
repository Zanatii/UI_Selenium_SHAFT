package tests.errorPagesTests;

import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.QuestionnaireFlow;
import tests.base.BaseTest;

public class ErrorPagesTests extends BaseTest {
    JSONFileManager questionnaireFlowData = new JSONFileManager("questionnaireFlowData.json");
    JSONFileManager recommendationPageData = new JSONFileManager("recommendationPageData.json");
    JSONFileManager appApis = new JSONFileManager("app-apis.json");

    // questionnaire flow data
    LandingPage landingPage;
    String firstQuestionHelpMeChooseAnswer;
    String secondQuestionFirstAnswer;
    String fourthQuestionThirdAnswer;
    String fifthQuestionSecondAnswer;
    String appleBrand;

    @BeforeMethod
    public void setUp() {
        // questionnaire flow data definition
        landingPage = new LandingPage(driver);
        firstQuestionHelpMeChooseAnswer = questionnaireFlowData.getTestData("questions.Q1.A1");
        secondQuestionFirstAnswer = questionnaireFlowData.getTestData("questions.Q2.A1");
        fourthQuestionThirdAnswer = questionnaireFlowData.getTestData("questions.Q4.A1");
        fifthQuestionSecondAnswer = questionnaireFlowData.getTestData("questions.Q5.A2");
        appleBrand = questionnaireFlowData.getTestData("questions.Q3.A2");
    }

    @TmsLink("OPW-2915")
    @Description("Validate the display of Error message in case of request failure")
    @Test
    public void validateErrorPageIsDisplayedWhenQuestionApiFails() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(firstQuestionHelpMeChooseAnswer)
                .clickContinueButton()
                .blockURL(appApis.getTestData("questionsApi"))
                .selectTheDesiredButton(secondQuestionFirstAnswer)
                .clickContinueButton()
                .validateErrorPageData(appApis.getTestData("questionErrorPage.errorHeader"),
                                       appApis.getTestData("questionErrorPage.errorHeader"),
                                       appApis.getTestData("questionErrorPage.errorHeader"),
                                       appApis.getTestData("questionErrorPage.errorHeader"));
    }


    /*
            add the follow to Jira & update the 'TmsLink' and 'Description'
     */

    @TmsLink("OPW-")
    @Description("Validate the error page after recommendations API failure")
    @Test
    public void validateErrorPageIsDisplayedWhenRecommendationsApiFails() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                // proceeding into the flow with 'help me choose device' scenario
                .selectTheDesiredButton(firstQuestionHelpMeChooseAnswer).clickContinueButton()
                .selectTheDesiredButton(secondQuestionFirstAnswer).clickContinueButton()
                .selectTheDesiredButton(appleBrand).clickContinueButton()
                .selectTheDesiredButton(fourthQuestionThirdAnswer).clickContinueButton()
                .selectTheDesiredButton(fifthQuestionSecondAnswer,"1")
                .selectTheDesiredButton(fifthQuestionSecondAnswer,"2")
                .selectTheDesiredButton(fifthQuestionSecondAnswer,"3").clickContinueButton()
                .selectPrice(1)
                .blockURL(appApis.getTestData("recommendationsApi"))
                .clickContinueButton()
                .validateErrorPageData(appApis.getTestData("recommendationErrorPage.errorHeader"),
                                       appApis.getTestData("recommendationErrorPage.errorHeader"),
                                       appApis.getTestData("recommendationErrorPage.errorHeader"),
                                       appApis.getTestData("recommendationErrorPage.errorHeader"));
    }

    @TmsLink("OPW-")
    @Description("Validate 'Restart' button functionality on the error page after questions API failure")
    @Test
    public void validateRestartFunctionalityInQuestionsErrorPage() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(firstQuestionHelpMeChooseAnswer)
                .clickContinueButton()
                .blockURL(appApis.getTestData("questionsApi"))
                .selectTheDesiredButton(secondQuestionFirstAnswer)
                .clickContinueButton()
                .validateErrorIsDisplayed()
                .clickRestartButton()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q1.title"));
    }

    @TmsLink("OPW-")
    @Description("Validate 'Restart' button functionality on the error page after recommendations API failure")
    @Test
    public void validateRestartFunctionalityInRecommendationsErrorPage() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                // proceeding into the flow with 'help me choose device' scenario
                .selectTheDesiredButton(firstQuestionHelpMeChooseAnswer).clickContinueButton()
                .selectTheDesiredButton(secondQuestionFirstAnswer).clickContinueButton()
                .selectTheDesiredButton(appleBrand).clickContinueButton()
                .selectTheDesiredButton(fourthQuestionThirdAnswer).clickContinueButton()
                .selectTheDesiredButton(fifthQuestionSecondAnswer,"1")
                .selectTheDesiredButton(fifthQuestionSecondAnswer,"2")
                .selectTheDesiredButton(fifthQuestionSecondAnswer,"3").clickContinueButton()
                .selectPrice(1)
                .blockURL(appApis.getTestData("recommendationsApi"))
                .clickContinueButton()
                .validateErrorIsDisplayed()
                .clickRestartButton()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q1.title"));
    }

    @TmsLink("OPW-4111")
    @Description("Validate the question error page is persisted after reopening the guided selling modal")
    @Test
    public void validateQuestionsErrorPageIsPersistedAfterReopeningGs() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(firstQuestionHelpMeChooseAnswer)
                .clickContinueButton()
                .blockURL(appApis.getTestData("questionsApi"))
                .selectTheDesiredButton(secondQuestionFirstAnswer)
                .clickContinueButton()
                .validateErrorIsDisplayed()
                .clickXButton()
                .clickGetStartedToQuestionnaireFlow()
                .validateErrorPageData(appApis.getTestData("questionErrorPage.errorHeader"),
                                       appApis.getTestData("questionErrorPage.errorHeader"),
                                       appApis.getTestData("questionErrorPage.errorHeader"),
                                       appApis.getTestData("questionErrorPage.errorHeader"));
    }

    @TmsLink("OPW-4112")
    @Description("Validate the recommendation error page is persisted after reopening the guided selling modal")
    @Test
    public void validateRecommendationsErrorPageIsPersistedAfterReopeningGs() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                // proceeding into the flow with 'help me choose device' scenario
                .selectTheDesiredButton(firstQuestionHelpMeChooseAnswer).clickContinueButton()
                .selectTheDesiredButton(secondQuestionFirstAnswer).clickContinueButton()
                .selectTheDesiredButton(appleBrand).clickContinueButton()
                .selectTheDesiredButton(fourthQuestionThirdAnswer).clickContinueButton()
                .selectTheDesiredButton(fifthQuestionSecondAnswer,"1")
                .selectTheDesiredButton(fifthQuestionSecondAnswer,"2")
                .selectTheDesiredButton(fifthQuestionSecondAnswer,"3").clickContinueButton()
                .selectPrice(1)
                .blockURL(appApis.getTestData("recommendationsApi"))
                .clickContinueButton()
                .validateErrorIsDisplayed()
                .clickXButton()
                .clickGetStartedToQuestionnaireFlow()
                .validateErrorPageData(appApis.getTestData("recommendationErrorPage.errorHeader"),
                                       appApis.getTestData("recommendationErrorPage.errorHeader"),
                                       appApis.getTestData("recommendationErrorPage.errorHeader"),
                                       appApis.getTestData("recommendationErrorPage.errorHeader"));
    }

    @TmsLink("OPW-4113")
    @Description("Validate 'Try again' button functionality on the questions error page after unblocking the API")
    @Test
    public void validateTryAgainButtonFunctionalityInQuestionsErrorPage() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(firstQuestionHelpMeChooseAnswer)
                .clickContinueButton()
                .blockURL(appApis.getTestData("questionsApi"))
                .selectTheDesiredButton(secondQuestionFirstAnswer)
                .clickContinueButton()
                .validateErrorIsDisplayed()
                .unblockURL()
                .clickOnTryAgainOnQuestionsErrorPage()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q3.title"));
    }

    @TmsLink("OPW-4114")
    @Description("Validate 'Try again' button functionality on the recommendations error page after unblocking the API")
    @Test
    public void validateTryAgainButtonFunctionalityIRecommendationsErrorPage() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                // proceeding into the flow with 'help me choose device' scenario
                .selectTheDesiredButton(firstQuestionHelpMeChooseAnswer).clickContinueButton()
                .selectTheDesiredButton(secondQuestionFirstAnswer).clickContinueButton()
                .selectTheDesiredButton(appleBrand).clickContinueButton()
                .selectTheDesiredButton(fourthQuestionThirdAnswer).clickContinueButton()
                .selectTheDesiredButton(fifthQuestionSecondAnswer,"1")
                .selectTheDesiredButton(fifthQuestionSecondAnswer,"2")
                .selectTheDesiredButton(fifthQuestionSecondAnswer,"3").clickContinueButton()
                .selectPrice(1)
                .blockURL(appApis.getTestData("recommendationsApi"))
                .clickContinueButton()
                .validateErrorIsDisplayed()
                .unblockURL()
                .clickOnTryAgainOnRecommendationsErrorPage()
                .validateNavigationToRecommendationPage();
    }

    @AfterMethod
    public void tearDown() {
        new QuestionnaireFlow(driver).unblockURL();
        driver.browser().refreshCurrentPage();
    }

}
