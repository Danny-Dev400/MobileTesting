package baseTest;

import core.MobileDriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import screens.*;

import java.io.ByteArrayInputStream;

public class Hooks {

    protected AndroidDriver<MobileElement> driver;
    String PATH_CAPABILITIES= "src/test/resources/desiredCapabilities/";
    String jsonFilename = "Capabilities.json";

    protected Modals modals;
    protected HomeScreen homeScreen;
    protected LoginScreen loginScreen;
    protected MovieDetails movieDetails;
    protected Navbar navbar;
    protected ProfileScreen profileScreen;
    protected SearchScreen searchScreen;
    protected VideoScreen videoScreen;
    protected RatingHistoryScreen ratingHistoryScreen;
    protected ActorsScreen actorsScreen;

    @BeforeMethod
    public void setup(){
        driver = MobileDriverManager.setupDriver(PATH_CAPABILITIES, jsonFilename);

        modals = new Modals(driver);
        homeScreen = new HomeScreen(driver);
        loginScreen = new LoginScreen(driver);
        movieDetails = new MovieDetails(driver);
        navbar = new Navbar(driver);
        profileScreen = new ProfileScreen(driver);
        searchScreen = new SearchScreen(driver);
        videoScreen = new VideoScreen(driver);
        ratingHistoryScreen = new RatingHistoryScreen(driver);
        actorsScreen = new ActorsScreen(driver);

        modals.dennyLocation()
                .acceptNotifications()
                .skipLogin();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if (!result.isSuccess()){
            byte[] myScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot",new ByteArrayInputStream(myScreenshot));
        }
        driver.quit();
    }
}
