package screens;

import baseTest.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.pmw.tinylog.Logger;

import java.util.List;

public class RatingHistoryScreen extends BaseScreen {

    private final By ratingMoviesTittle = By.id("com.imdb.mobile:id/primaryText");

    public RatingHistoryScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Check Movie Rating")
    public boolean checkMovieRating(String movieTittle){
        String result = "";
        List<MobileElement> results = waitForDisplayElements(ratingMoviesTittle,30).getActualMultipleMobileElemets();
        Logger.info("Getting the rating movies for the user");
        for (MobileElement item : results) {
            result += setActualMobileElement(item).getTextE();
            result += " ";
        }
        Logger.info("Verifying if the rating movies contains the movie");
        return result.contains(movieTittle);
    }



}
