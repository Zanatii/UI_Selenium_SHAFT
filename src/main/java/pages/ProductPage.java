package pages;

import com.shaft.driver.SHAFT;

public class ProductPage {
    SHAFT.GUI.WebDriver driver;

    // Constructor
    public ProductPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    // Actions
    public RecommendationPage clickBrowserBackBtn() {
        driver.browser().navigateBack();
        return new RecommendationPage(driver);
    }

    // Validations
    public ProductPage validatePageUrl(String expectedUrl) {
        driver.verifyThat().browser().url().isEqualTo(expectedUrl).withCustomReportMessage("Product URL is not as expected").perform();
        return this;
    }

}
