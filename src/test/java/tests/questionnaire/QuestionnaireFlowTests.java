package tests.questionnaire;

import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.QuestionnaireFlow;
import tests.base.BaseTest;

public class QuestionnaireFlowTests extends BaseTest {
    LandingPage landingPage;
    QuestionnaireFlow questionnaireFlow;
    JSONFileManager questionnaireFlowData;


    @BeforeClass
    public void setUp() {
        landingPage = new LandingPage(driver);
        questionnaireFlow = new QuestionnaireFlow(driver);
        landingPage = new LandingPage(driver);
        questionnaireFlowData = new JSONFileManager("questionnaireFlowData.json");
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateModalBackBtnFunctionalityInSecondQuestion() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q2.title"))
                .clickBackButton()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q1.title"))
                .validateQuestionDataIsPersisted(questionnaireFlowData.getTestData("questions.Q1.A1"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateModalBackBtnFunctionalityInThirdQuestion() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q3.title"))
                .clickBackButton()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q2.title"))
                .validateQuestionDataIsPersisted(questionnaireFlowData.getTestData("questions.Q2.A1"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateDataPersistenceAfterReopeningTheModal() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickXButton().validateNavigationToTheLandingPage()
                .clickGetStartedToQuestionnaireFlow()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q1.title"))
                .validateQuestionDataIsPersisted(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()

                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickXButton().validateNavigationToTheLandingPage()
                .clickGetStartedToQuestionnaireFlow()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q2.title"))
                .validateQuestionDataIsPersisted(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()

                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A1"))
                .clickXButton().validateNavigationToTheLandingPage()
                .clickGetStartedToQuestionnaireFlow()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q3.title"))
                .validateQuestionDataIsPersisted(questionnaireFlowData.getTestData("questions.Q3.A1"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateRestartBtnFunctionalityInSecondQuestion() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q2.title"))
                .clickRestartButton()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q1.title"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validateRestartBtnFunctionalityInThirdQuestion() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q3.title"))
                .clickRestartButton()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q1.title"));
    }

    @TmsLink("OPW-")
    @Description("")
    @Test
    public void validate() {
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q3.title"))
                .clickRestartButton()
                .validateSpecificQuestionIsDisplayed(questionnaireFlowData.getTestData("questions.Q1.title"));
    }




















    /*///////////////////////////////////////////

                          OLD

     *//////////////////////////////////////////

    @TmsLink("OPW-1708")
    @Description("Validating that user can select many selections while trying to select manufacturer even he didn't select All Brands option")
    @Test
    public void validateTheMultiSelectionQuestionTypeBehavior(){
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A2"))
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A3"))
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A3"))
                .validateTheNextButtonIsEnabled();
    }

    @TmsLink("OPW-1707")
    @Description("Validating that only one selection is available from the second page with title 'What device are you looking for?' of GS app with Phones journey")
    @Test
    public void validateTheOneSelectionQuestionTypeBehaviorForTheSecondQuestion(){
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .validateTheNextButtonIsEnabled()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A2"))
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A2"))
                .validateTheNextButtonIsDisabled();
    }
    @TmsLink("OPW-1710")
    @Description("Validating that user can select only one screen size option from screen size page")
    @Test
    public void validateTheOneSelectionQuestionTypeBehaviorForTheFourthQuestion(){
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q4.A1"))
                .validateTheNextButtonIsEnabled()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q4.A2"))
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q4.A2"))
                .validateTheNextButtonIsDisabled();
    }

    @TmsLink("OPW-1709")
    @Description("Validating that user can't select any other brand will he navigating to the manufacturer selection page for Phones journey and select all brands option")
    @Test
    public void validateTheAllBrandsSelectionButtonBehavior(){
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A2"))
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A3"))
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A4"))
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A5"))
                .validateTheNextButtonIsEnabled()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A1"))
                .validateTheNextButtonIsEnabled()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A1"))
                .validateTheNextButtonIsDisabled();
    }

    @TmsLink("OPW-1399")
    @Description("Validating on the data of price selection screen will remain without any changes while clicking on X icon then reopen it again")
    @Test
    public void validateTheSliderPersistsItsValueWhenClickingOnCloseButton(){
        String priceValue= landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A2"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q4.A2"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"1")
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"2")
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"3")
                .clickContinueButton()
                .selectPrice((int) questionnaireFlowData.getTestDataAsJson("testData.minimumUnitsToIncreasePriceWith"))
                .getPriceOnSlider();
        questionnaireFlow.clickXButton()
                .clickGetStartedToQuestionnaireFlow()
                .validatePriceOnTheSlider(priceValue);
    }

    @TmsLink("OPW-4116")
    @Description("Validating that user will be redirected to the correct question according to the question flow when click on the Next button through Greece GS questionnaire flow pages")
    @Test
    public void validateTheNavigationThroughTheQuestionnaireFlow(){
        landingPage.clickGetStartedToQuestionnaireFlow()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q1.title"))
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q2.title"))
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q3.title"), questionnaireFlowData.getTestData("questions.Q3.subTitle"))
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A2"))
                .clickContinueButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q4.title"))
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q4.A2"))
                .clickContinueButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q5.title"))
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"1")
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"2")
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"3")
                .clickContinueButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q6.title"), questionnaireFlowData.getTestData("questions.Q6.subTitle"))
                .clickNextToRecommendationPageButton()
                .validateNavigationToRecommendationPage();

    }

    @TmsLink("OPW-1389")
    @Description("Validating that user will restart the Greece GS journey again whenever clicking on Restart button")
    @Test
    public void validateTheRestartButtonFunctionalityInTheQuestionnaireFlowPages(){
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .clickRestartButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q1.title"))
                .validateTheNextButtonIsDisabled()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()
                .clickRestartButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q1.title"))
                .validateTheNextButtonIsDisabled()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A2"))
                .clickContinueButton()
                .clickRestartButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q1.title"))
                .validateTheNextButtonIsDisabled()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A2"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q4.A2"))
                .clickContinueButton()
                .clickRestartButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q1.title"))
                .validateTheNextButtonIsDisabled()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A2"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q4.A2"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"1")
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"2")
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"3")
                .clickContinueButton()
                .clickRestartButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q1.title"))
                .validateTheNextButtonIsDisabled();
    }
    @TmsLink("OPW-1390")
    @Description("Validating the Restart button functionality after clicking back from the Recommendation page")
    @Test
    public void validateTheRestartButtonFunctionalityAfterClickingBackFromTheRecommendationPage(){
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A2"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q4.A2"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"1")
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"2")
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"3")
                .clickContinueButton()
                .clickNextToNavigateToRecommendationPage()
                .clickBackButton()
                .clickRestartButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q1.title"))
                .validateTheNextButtonIsDisabled();
    }

    @TmsLink("OPW-4115")
    @Description("Validate that Greece GS app will be closed when clicking on close button in the questionnaire flow pages")
    @Test
    public void validateTheCloseButtonBehaviorInTheQuestionnaireFlowPages(){
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickXButton()
                .clickGetStartedToQuestionnaireFlow()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q1.title"))
                .validateTheNextButtonIsEnabled()
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickXButton()
                .clickGetStartedToQuestionnaireFlow()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q2.title"))
                .validateTheNextButtonIsEnabled()
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A2"))
                .clickXButton()
                .clickGetStartedToQuestionnaireFlow()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q3.title"), questionnaireFlowData.getTestData("questions.Q3.subTitle"))
                .validateTheNextButtonIsEnabled()
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q4.A2"))
                .clickXButton()
                .clickGetStartedToQuestionnaireFlow()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q4.title"))
                .validateTheNextButtonIsEnabled()
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"1")
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"2")
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"3")
                .clickXButton()
                .clickGetStartedToQuestionnaireFlow()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q5.title"))
                .validateTheNextButtonIsEnabled();
    }

    @TmsLink("OPW-1397")
    @Description("Validating that all user selections remain without conflict while answer all questions till the end of the journey then press on back button for each page")
    @Test
    public void validateTheBackButtonBehaviorInTheQuestionnaireFlowPages(){
        landingPage.clickGetStartedToQuestionnaireFlow()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A2"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q4.A2"))
                .clickContinueButton()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"1")
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"2")
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q5.A2"),"3")
                .clickContinueButton()
                .clickBackButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q5.title"))
                .validateTheNextButtonIsEnabled()
                .clickBackButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q4.title"))
                .validateTheNextButtonIsEnabled()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q4.A2"))
                .validateTheNextButtonIsDisabled()
                .clickBackButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q3.title"), questionnaireFlowData.getTestData("questions.Q3.subTitle"))
                .validateTheNextButtonIsEnabled()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q3.A2"))
                .validateTheNextButtonIsDisabled()
                .clickBackButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q2.title"))
                .validateTheNextButtonIsEnabled()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q2.A1"))
                .validateTheNextButtonIsDisabled()
                .clickBackButton()
                .validateTheRedirectionToSpecificQuestionnairePage(questionnaireFlowData.getTestData("questions.Q1.title"))
                .validateTheNextButtonIsEnabled()
                .selectTheDesiredButton(questionnaireFlowData.getTestData("questions.Q1.A1"))
                .validateTheNextButtonIsDisabled();
    }


    @AfterMethod
    public void afterTestCase(){
        driver.browser().refreshCurrentPage();
    }

}
