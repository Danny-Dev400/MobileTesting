package screens;

import baseTest.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;

public class RatingHistoryScreen extends BaseScreen {

    private final By ratingMoviesTittle = By.id("com.imdb.mobile:id/primaryText");

    public RatingHistoryScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean checkMovieRating(String movieTittle){
        String result = "";
        List<MobileElement> results = waitForDisplayElements(ratingMoviesTittle,30).getActualMultipleMobileElemets();
        for (MobileElement item : results) {
            result += setActualMobileElement(item).getTextE();
            result += " ";
        }
        return result.contains(movieTittle);
    }



}
