package pages;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.w3c.dom.ls.LSOutput;


public class RecommendationPage {
    private final SHAFT.GUI.WebDriver driver;

    // Constructor
    public RecommendationPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    // Locators
    private final By backButton = By.cssSelector("[data-test-id='back-button-arrow']");
    private final By closeButton = By.cssSelector("[data-test-id='overlay-button-close']");
    private final By recommendationPageTitle = By.xpath("(//div[//hr[@data-component-name='Divider']]//h2)[1]");
    private By productNameWithTabIndex(String tabIndex) {return By.xpath("//div[@data-test-id='product-name-" + tabIndex + "']//div/span");}

    // the following locator is generic for all recommended devices & it is being used to count them
    public final By devicesNames = By.xpath("//div[@id='recommendation-handset-name']/p");
    private final By colorDropdown = By.id("recommendation-handset-dropdown-color");
    private By colorDropdownByTabIndex(String tabIndex) {return By.xpath("(//*[@id='recommendation-handset-dropdown-color'])[" + tabIndex + "]");}
    private By memoryDropdownByTabIndex(String tabIndex) {return By.xpath("(//*[@id='recommendation-handset-dropdown-capacity'])[" + tabIndex + "]");}
    // the following locator was added because some device has just one memory, therefore there is no memory dropdown, and it became just a box
    private By parentMemoryElement(String tabIndex) {return By.xpath("(//*[contains(@id,'capacity')])[" + tabIndex + "]");}
    private By topFeaturesByTabIndex(String tabIndex) {return By.xpath("(//div[@data-test-id='specification-button'])[" + tabIndex + "]//div[@data-component-name='SimpleGrid']//div[@spacing='2']");}
    private By continueBtnByProductIndex(String productIndex) {return By.id("recommendation-next-button-" + productIndex);}
    private final By priceText = By.cssSelector("[data-test-id='device-price-value']");
    private By priceTypeByTabIndex(String tabIndex) {return RelativeLocator.with(By.tagName("p")).above(devicePriceByTabIndex(tabIndex));}

    // generic locator to count tabs (get the number of tabs)
    private final By recommendationTabs = By.xpath("//button[@role='tab']");
    private By productFeature(String featureIndex, String tabIndex) {return By.xpath("//p[@data-test-id='feature-"+featureIndex+"-name-tab-"+tabIndex+"']");}
    private By arrayOfFeature = By.xpath("//p[@data-test-id='feature-0-name-tab-0']");

    //todo the following locator need to be changed as there is no parent in Greece
    private final By deviceImage = By.xpath("//picture//img");
    private By devicePriceByTabIndex(String tabIndex) {return By.xpath("(//*[@data-test-id='device-price-value'])[" + tabIndex + "]");}
    private By recommendationTypeTabByTabName(String tabName) {return By.xpath("//button[div//@data-text='" + tabName + "']");}
    private By recommendationTabByTabIndex(String tabIndex) {return By.xpath("(//button[@role='tab'])[" + tabIndex + "]");}

    /**
     * the following locators is a little bit confusing -> it is getting the last device name locator
     *** the reason is there is an issue that all recommended devices share the same locator
     *  and somehow, the third device may be having the index [2] not [3] when getting elements by index
     ****  so this method gets the last selected tab device name ->
     **** (only if the selected tab is after the previous selected tab)
     */
    private final By lastDeviceName = By.xpath("(//div[@id='recommendation-handset-name']/p)[last()]");
    private final By lastCompareButton = By.xpath("(//button[@data-test-id='compare-devices-button'])[last()]");

    // error page locators (appear when recommendations APIs fail)
    private final By errorIcon = By.tagName("img");
    private final By errorHeader = By.tagName("h2");
    private final By errorDescription = By.tagName("p");
    private final By retryBtn = By.xpath("//button[@aria-label='Προσπάθησε ξανά']");

    // Actions
    public LandingPage refreshTheApp() {
        driver.browser().refreshCurrentPage();
        return new LandingPage(driver);
    }
    public RecommendationPage selectSpecificTabByIndex(String tabIndex){
        driver.element().click(recommendationTabByTabIndex(tabIndex));
        return this;
    }
    public RecommendationPage selectSpecificTabByName(String tabName){
        driver.element().click(recommendationTypeTabByTabName(tabName));
        return this;
    }
    public QuestionnaireFlow clickBackButton (){
        driver.element().click(backButton);
        return new QuestionnaireFlow(driver);
    }
    public LandingPage clickCloseButton (){
        driver.element().click(closeButton);
        return new LandingPage(driver);
    }
    public String getPriceText() {
        return driver.element().getText(priceText);
    }
    public String getDeviceName(String tabIndex) {
        return driver.element().getText(productNameWithTabIndex(tabIndex));
    }

    /**
     * this method to solve locators problem as all recommended devices share the same locator
     */
    public String getLastSelectedTabDeviceName() {
        return driver.element().getText(lastDeviceName);
    }
    public ProductPage clickContinue(String productIndex) {
        driver.element().click(continueBtnByProductIndex(productIndex));
        return new ProductPage(driver);
    }
    public String getDeviceNameWhenReopeningGSAfterClickingClose() {
        return driver.element().getText(lastDeviceName);
    }
    public String getProductFeature (String featureIndex, String tabIndex, String actualProductFeature) {
        /**testing the data */

        Validations.verifyThat().object(driver.element().getText(productFeature(featureIndex, tabIndex))).isEqualTo(actualProductFeature).perform();
        return driver.element().getText(productFeature(featureIndex, tabIndex));
    }


    /**
     *  in this project validations are written on the page class in the aim for
     *      1- re-usability
     *      2- fluent design
     *      3- readability
     */
    // Validations
    public RecommendationPage validateSpecificTabIsSelected(String tabIndex) {
        Validations.verifyThat().object(driver.element().getAttribute(recommendationTabByTabIndex(tabIndex), "aria-selected")).isEqualTo("true").withCustomReportMessage("tab number " + tabIndex + " is not selected as expected").perform();
        return this;
    }

    /**
     * this method validates price of a specific memory (old price), is not the same after selecting another memory
     * @param priceBeforeChangingCapacity -> which the (old price) stored before changing the memory
     * @return this -> to continue the fluent design (shaft already validates on it)
     */
    public RecommendationPage validateRecommendedPriceChangesWithCapacity(String priceBeforeChangingCapacity) {
        Validations.assertThat().object(getPriceText()).doesNotEqual(priceBeforeChangingCapacity).withCustomReportMessage("Price of the recommended device didn't change upon changing the capacity").perform();
        return this;
    }
    public RecommendationPage validateNavigationToRecommendationPage() {
        driver.verifyThat().element(recommendationTabByTabIndex("1")).isVisible().withCustomReportMessage("Navigation to recommendation page didn't occur as expected").perform();
        return this;
    }

    /**
     * the following locators is a little bit confusing -> it is getting the last device name locator
     *** the reason is there is an issue that all recommended devices share the same locator
     *  and somehow, the third device may be having the index [2] not [3] when getting elements by index
     ****  so this method gets the last selected tab device name ->
     **** (only if the selected tab is after the previous selected tab)
     */
    public RecommendationPage validateDeviceChanged(String oldDeviceName) {
        Validations.verifyThat().element(lastDeviceName).text().doesNotEqual(oldDeviceName).withCustomReportMessage("device hasn't change").perform();
        return this;
    }

    /**
     * look at the locator doc if the method name is confusing
     */
    public RecommendationPage validateProductName(String productIndex, String expectedDeviceName) {
        driver.verifyThat().element(productNameWithTabIndex(productIndex)).text().isEqualTo(expectedDeviceName).withCustomReportMessage("recommended device name is not as expected").perform();
        return this;
    }
    public RecommendationPage validateNumberOfTabs(int expectedTabsNumber) {
        Validations.verifyThat().object(driver.element().getElementsCount(recommendationTabs)).isEqualTo(expectedTabsNumber).withCustomReportMessage("Number of tabs is not as expected (the expected number was -> " + expectedTabsNumber + ")").perform();
        return this;
    }
    public RecommendationPage validateSolutionData(int expectedTabsNumber) {
        Validations.verifyThat().object(driver.element().getElementsCount(recommendationTabs)).isEqualTo(expectedTabsNumber).withCustomReportMessage("Number of tabs is not as expected (the expected number was -> " + expectedTabsNumber + ")").perform();
        return this;
    }

}
