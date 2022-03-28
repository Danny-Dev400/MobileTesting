package screens;

import baseTest.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.pmw.tinylog.Logger;

import java.util.List;

public class ProfileScreen extends BaseScreen {

    private final By userWatchList = By.id("com.imdb.mobile:id/main_line");
    private final By signInSignUpButton = By.id("com.imdb.mobile:id/sign_in_button");
    private final By ratingsList = By.id("com.imdb.mobile:id/ratings_parent");

    public ProfileScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean checkIfAMovieIsInTheWatchlist(){
        String result = "";
        List<MobileElement> results = waitForDisplayElements(userWatchList,30).getActualMultipleMobileElemets();
        Logger.info("Getting the movies in the watch list");
        for (MobileElement item : results) {
            result += setActualMobileElement(item).getTextE();
            result += " ";
        }
        Logger.info("Verifying if the watchlist contains the movie");
        return result.contains(MovieDetails.actualMovieSelected);
    }

    public Modals clickInSignInSignUpButton(){
        waitForDisplayAnElement(signInSignUpButton,20).clickE();
        return new Modals(driver);
    }

    public RatingHistoryScreen clickInRatingMovies(){
        waitForDisplayAnElement(ratingsList,10).clickE();
        return new RatingHistoryScreen(driver);
    }
}
