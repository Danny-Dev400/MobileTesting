package screens;

import baseTest.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Navbar extends BaseScreen {

    private final By searchButton = By.id("com.imdb.mobile:id/navigation_search_browse");
    private final By homeButton = By.id("com.imdb.mobile:id/navigation_home");
    private final By videButton = By.id("com.imdb.mobile:id/navigation_video");
    private final By profileButton = By.id("com.imdb.mobile:id/navigation_you");

    public Navbar(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Go To Home Screen")
    public HomeScreen goToHomeScreen(){
        waitForDisplayAnElement(homeButton,20).clickE();
        return new HomeScreen(driver);
    }

    @Step("Go To Search Screen")
    public SearchScreen goToSearchScreen(){
        waitForDisplayAnElement(searchButton,20).clickE();
        return new SearchScreen(driver);
    }

    @Step("Go To Video Screen")
    public VideoScreen goToVideoScreen(){
        waitForDisplayAnElement(videButton,20).clickE();
        return new VideoScreen(driver);
    }

    @Step("Go To Profile Screen")
    public ProfileScreen goToProfileScreen(){
        waitForDisplayAnElement(profileButton,20).clickE();
        return new ProfileScreen(driver);
    }
}
