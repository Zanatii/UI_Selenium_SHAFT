package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LandingPage {
    SHAFT.GUI.WebDriver driver;

    // Constructor
    public LandingPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    // Locators
    private final By getStarted_button = By.id("gs-cta-button");

    // Actions
    public String getStartedText(){
        return driver.element().getText(getStarted_button);
    }
    public QuestionnaireFlow clickGetStartedToQuestionnaireFlow(){
        driver.element().click(getStarted_button);
        return new QuestionnaireFlow(driver);
    }

    /**
     *  This method is used when closing the modal from the recommendation page, and
     *  then clicking on 'Get started' BTN. It will redirect the user to the recommendation page again
     */
    public RecommendationPage clickGetStartedToBackToRecommendationPage(){
        driver.element().click(getStarted_button);
        return new RecommendationPage(driver);
    }

    // Validations
    // todo -> revisit it
    public LandingPage validateNavigationToTheLandingPage(){
        //Validations.verifyThat().element(closeButton).doesNotExist().withCustomReportMessage("The Overlay didn't close").perform();
        //SHAFT.Validations.verifyThat().object(getStartedText()).isEqualTo("Έναρξη").withCustomReportMessage("Navigation to landing page didn't occur successfully").perform();
        return this;
    }

}

