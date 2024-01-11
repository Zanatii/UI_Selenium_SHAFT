package tests.base;

import com.shaft.driver.SHAFT;
import org.testng.annotations.*;

public class BaseTest {
    // Driver declaration
    public static SHAFT.GUI.WebDriver driver;

    // URL is extracted from "src/main/resources/properties/config.properties"
    public String URL = System.getProperty("URL");

    @BeforeMethod
    public void mainSetUp() {
        // Driver initiation
        driver = new SHAFT.GUI.WebDriver();
        // Navigation to the app
        driver.browser().navigateToURL(URL);
    }


}

