package pages;
import com.google.common.collect.ImmutableList;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v115.network.Network;
import org.openqa.selenium.interactions.Actions;

import java.util.Optional;

public class QuestionnaireFlow {
    SHAFT.GUI.WebDriver driver;

    // Constructor
    public QuestionnaireFlow(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    // Locators
    private final By restartButton = By.id("questionnaire-button-restart");
    private final By nextButton = By.id ("questionnaire-button-next");
    private final By backButton = By.id("questionnaire-button-back");
    private final By closeButton = By.xpath("//button[@data-test-id='overlay-button-close']");
    private final By questionTitle = By.xpath("//h2[@data-test-id='page-title']");
    private final By questionSubtitle = By.xpath("//h2[@data-test-id='page-subtitle']");
    private By buttonTitle(String titleOfTheSelectedButton) {return By.xpath("(//span[@data-title=\""+titleOfTheSelectedButton+"\"])");}
    private By buttonTitle(String titleOfTheSelectedButton, String indexOfTheSelectedButton) {return By.xpath(String.format("(//span[@data-title=\""+titleOfTheSelectedButton+"\"])["+indexOfTheSelectedButton+"]"));}
    private final By selectedPriceValue = By.cssSelector("[data-test-id='selected-price-value']");
    private final By priceSlider = By.xpath("//div[@role='slider']");
    private final By handsetSearchField = By.id("handset-search");
    private final By firstRowSearchResult = By.xpath("(//button[@data-component-name='Interaction'])[1]");

    // error page locators
    private final By errorIcon = By.tagName("img");
    private final By errorHeader = By.tagName("h2");
    private final By errorDescription = By.tagName("p");
    private final By tryAgainBtn = By.xpath("//button[@aria-label='Προσπάθησε ξανά']");

    // loading locators
    private final By loadingIndicator = By.xpath("//div[@data-component-name='Loader']//*[name()='svg']");


    // Actions
    public QuestionnaireFlow clickContinueButton(){
        driver.element().click(nextButton);
        return this;
    }
    public RecommendationPage clickNextToRecommendationPageButton (){
        driver.element().waitToAttribute(nextButton, "aria-disabled", "false");
        driver.element().click(nextButton);
        return new RecommendationPage(driver);
    }
    public QuestionnaireFlow clickBackButton (){
        driver.element().click(backButton);
        return this;
    }
    public QuestionnaireFlow clickRestartButton () { driver.element().click(restartButton);
        return this;
    }
    public LandingPage clickXButton () { driver.element().click(closeButton);
        return new LandingPage(driver);
    }
    public RecommendationPage clickNextToNavigateToRecommendationPage(){
        driver.element().waitToAttribute(nextButton, "aria-disabled", "false");
        driver.element().click(nextButton);
        return new RecommendationPage(driver);
    }
    public QuestionnaireFlow selectTheDesiredButton(String titleOfTheSelectedButton){
        driver.element().click(buttonTitle(titleOfTheSelectedButton));
        return this;
    }
    public QuestionnaireFlow selectTheDesiredButton(String titleOfTheSelectedButton, String indexOfTheSelectedButton){
        driver.element().click(buttonTitle(titleOfTheSelectedButton, indexOfTheSelectedButton));
        return this;
    }
    public String getQuestionTitle(){
        return driver.element().getText(questionTitle);
    }
    public String getQuestionSubtitle(){
        return driver.element().getText(questionSubtitle);
    }
    public String getSelectedPriceValue(){
        return driver.element().getText(selectedPriceValue);
    }
    public QuestionnaireFlow searchForHandset(String handsetName){
        driver.element().type(handsetSearchField, handsetName);
        driver.element().click(firstRowSearchResult);
        return this;
    }
    public String getFirstRowInTheSearchResult(){
        return driver.element().getText(firstRowSearchResult);
    }
    public String getSearchFieldValue(){
        return driver.element().getAttribute(handsetSearchField,"value");
    }
    public String getPriceOnSlider(){
        return driver.element().getText(selectedPriceValue);
    }
    // todo
    public QuestionnaireFlow selectPrice(int unitsToIncreasePriceWith) {
        String initialPriceOnSlider = getPriceOnSlider();
// driver.element().dragAndDropByOffset(priceSlider, unitsToIncreasePriceWith, 0)
// .waitForTextToChange(priceOnSlider, initialPriceOnSlider);
        if (unitsToIncreasePriceWith == 0) return this;
        new Actions(driver.getDriver()).dragAndDropBy(driver.getDriver().findElement(priceSlider), unitsToIncreasePriceWith, 0).perform();
            driver.element().waitForTextToChange(selectedPriceValue, initialPriceOnSlider);

        return this;
    }
    public RecommendationPage completeTheFlowAndNavigateToRecommendations(String firstQuestionAnswer, String secondQuestionAnswer, String thirdQuestionAnswer) {
        return selectTheDesiredButton(firstQuestionAnswer)
                .clickContinueButton()
                .selectTheDesiredButton(secondQuestionAnswer)
                .clickContinueButton()
                .selectTheDesiredButton(thirdQuestionAnswer)
                .clickNextToNavigateToRecommendationPage();
    }
    public RecommendationPage completeTheFlowAndNavigateToRecommendations(String firstQuestionAnswer, String secondQuestionAnswer, String thirdQuestionAnswer, String fourthQuestionAnswer, String fifthQuestionAnswer) {
        return selectTheDesiredButton(firstQuestionAnswer)
                .clickContinueButton()
                .selectTheDesiredButton(secondQuestionAnswer)
                .clickContinueButton()
                .selectTheDesiredButton(thirdQuestionAnswer)
                .clickContinueButton()
                .selectTheDesiredButton(fourthQuestionAnswer)
                .clickContinueButton()
                .selectTheDesiredButton(fifthQuestionAnswer)
                .clickNextToNavigateToRecommendationPage();
    }
    public QuestionnaireFlow clickOnTryAgainOnQuestionsErrorPage() {
        driver.element().click(tryAgainBtn);
        return this;
    }
    public RecommendationPage clickOnTryAgainOnRecommendationsErrorPage() {
        driver.element().click(tryAgainBtn);
        return new RecommendationPage(driver);
    }
    public QuestionnaireFlow blockURL(String URL) {
//        if (driver instanceof HasDevTools) {
        DevTools devTools = ((HasDevTools) driver.getDriver()).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of(URL)));
        return this;
    }
    public QuestionnaireFlow unblockURL() {
        DevTools devTools = ((HasDevTools) driver.getDriver()).getDevTools();
        devTools.send(Network.disable());
        //devTools.close();
        return this;
    }

    /////////// Validations \\\\\\\\\\\\\\\
    public QuestionnaireFlow validatePriceOnTheSlider(String expectedPrice) {
        SHAFT.Validations.assertThat().object(getPriceOnSlider()).isEqualTo(expectedPrice).withCustomReportMessage("price on the slider page is not as expected").perform();
        return this;
    }
    public QuestionnaireFlow validateUserNavigatedToPricingPage() {
        driver.assertThat().element(priceSlider).isVisible().withCustomReportMessage("user is not on the pricing page as expected").perform();
        driver.assertThat().element(questionTitle).isVisible().withCustomReportMessage("user is not on the pricing page as expected").perform();
        return this;
    }
    public QuestionnaireFlow validateSearchBehaviorForInvalidSearch(String invalidSearch){
        SHAFT.Validations.verifyThat().object(getFirstRowInTheSearchResult()).isEqualTo("No results found for "+ invalidSearch).withCustomReportMessage("The No Search Result Found behavior is not as Expected").perform();
        return this;
    }
    public QuestionnaireFlow validateTheRedirectionToSpecificQuestionnairePage(String pageTitle){
        SHAFT.Validations.verifyThat().object(getQuestionTitle()).isEqualTo(pageTitle).withCustomReportMessage("The User is redirected to The wrong Question Page").perform();
        return this;
    }
    public QuestionnaireFlow validateTheRedirectionToSpecificQuestionnairePage(String pageTitle, String pageSubtitle){
        SHAFT.Validations.verifyThat().object(getQuestionTitle()).isEqualTo(pageTitle).withCustomReportMessage("The User is redirected to The wrong Question Page").perform();
        SHAFT.Validations.verifyThat().object(getQuestionSubtitle()).isEqualTo(pageSubtitle).withCustomReportMessage("The User is redirected to The wrong Question Page").perform();
        return this;
    }
    public QuestionnaireFlow validateTheNextButtonIsDisabled(){
        driver.verifyThat().element(nextButton).attribute("aria-disabled").isTrue().withCustomReportMessage("The Next Button Is Dimmed & UnClickable").perform();
        return this;
    }
    public QuestionnaireFlow validateTheNextButtonIsEnabled(){
        driver.verifyThat().element(nextButton).attribute("aria-disabled").isFalse().withCustomReportMessage("The Next Button Is Clickable").perform();
        return this;
    }
    public QuestionnaireFlow validateTheInputInTheSearchField(String searchedProduct){
        SHAFT.Validations.verifyThat().object(getSearchFieldValue()).isEqualTo(searchedProduct).withCustomReportMessage("The Searched Product isnot selected or doesn't match the selected").perform();
        return this;
    }
    public QuestionnaireFlow validateErrorIsDisplayed() {
        driver.verifyThat().element(closeButton).isVisible().withCustomReportMessage("close button is not displayed on error page as expected").perform();
        driver.verifyThat().element(restartButton).isVisible().withCustomReportMessage("restart button text on error page is not as expected").perform();
        driver.verifyThat().element(errorIcon).isVisible().withCustomReportMessage("error icon is not displayed").perform();
        driver.verifyThat().element(errorHeader).isVisible().withCustomReportMessage("error header is not displayed").perform();
        driver.verifyThat().element(errorDescription).isVisible().withCustomReportMessage("error description is not displayed").perform();
        driver.verifyThat().element(tryAgainBtn).isVisible().withCustomReportMessage("error page 'retry' button is not displayed").perform();
        return this;
    }
    public QuestionnaireFlow validateErrorPageData(String errorHeader, String errorDescription, String restartBtnText, String tryAgainBtnText) {
        driver.verifyThat().element(closeButton).isVisible().withCustomReportMessage("close button is not displayed on error page as expected").perform();
        driver.verifyThat().element(restartButton).text().isEqualTo(restartBtnText).withCustomReportMessage("restart button text on error page is not as expected").perform();
        driver.verifyThat().element(errorIcon).isVisible().withCustomReportMessage("error icon is not displayed").perform();
        driver.verifyThat().element(this.errorHeader).text().isEqualTo(errorHeader).withCustomReportMessage("error header is not displayed").perform();
        driver.verifyThat().element(this.errorDescription).text().isEqualTo(errorDescription).withCustomReportMessage("error description is not displayed").perform();
        driver.verifyThat().element(tryAgainBtn).text().isEqualTo(tryAgainBtnText).withCustomReportMessage("error page 'retry' button is not displayed").perform();
        return this;
    }
    public QuestionnaireFlow validateSpecificQuestionIsDisplayed(String questionName) {
        driver.verifyThat().element(questionTitle).text().isEqualTo(questionName).withCustomReportMessage("try again button doesn't return the expected question").perform();
        return this;
    }
    public QuestionnaireFlow validateQuestionDataIsPersisted(String option) {
        driver.verifyThat().element(nextButton).attribute("aria-disabled").isFalse().withCustomReportMessage("Next Btn is not enabled after clicking back in the questionnaire flow").perform();
        selectTheDesiredButton(option);
        driver.verifyThat().element(nextButton).attribute("aria-disabled").isTrue().withCustomReportMessage("Next Btn is not disabled after clicking back in the questionnaire flow").perform();
        selectTheDesiredButton(option);
        driver.verifyThat().element(nextButton).attribute("aria-disabled").isFalse().withCustomReportMessage("Next Btn is not enabled after clicking back in the questionnaire flow").perform();
        return this;
    }

    // loading validations
    public QuestionnaireFlow validateLoadingIndicatorDisplaying() {
        driver.verifyThat().element(loadingIndicator).isVisible().withCustomReportMessage("Loading indicator is not displayed").perform();
        return this;
    }

}