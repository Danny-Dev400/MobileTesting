package screens;

import baseTest.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import jdk.internal.net.http.common.Log;
import org.openqa.selenium.By;
import org.pmw.tinylog.Logger;

public class MovieDetails extends BaseScreen {

    public static String actualMovieSelected = "";

    private final By movieDescription = By.id("com.imdb.mobile:id/plot_overview");
    private final By addToWatchListbutton = By.id("com.imdb.mobile:id/state_off");
    private final By removeFromWatchListbutton = By.id("com.imdb.mobile:id/state_on");
    private final By ratingStars = By.xpath("//android.widget.FrameLayout[@resource-id='com.imdb.mobile:id/star_row']//android.widget.ImageView");
    private final By rateButton = By.id("com.imdb.mobile:id/rate_title_button");
    private final By actorsList = By.id("com.imdb.mobile:id/info_holder");

    public MovieDetails(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Get Movie Description")
    public String getMovieDescription(){
        Logger.info("Getting the description of the movie");
        return waitForDisplayAnElement(movieDescription,20).getTextE();
    }

    @Step("Add To Watch List")
    public MovieDetails addToWatchList(){
        try {
            waitPresenceOfElement(addToWatchListbutton,20).clickE();
            Logger.info("Click in add to watchlist");
        }catch (Exception e){
            Logger.warn("This movie is already on the watchlist");
            waitForDisplayAnElement(removeFromWatchListbutton,20).clickE();
            waitForDisplayAnElement(addToWatchListbutton,20).clickE();
        }
        return new MovieDetails(driver);
    }

    @Step("Rate A Movie")
    public MovieDetails rateAMovie(int score){
        Logger.info("Scrolling up to your rating");
        verticalScrollTo("Your Rating").clickE();
        Logger.info("Rating the movie...");
        waitForDisplayElements(ratingStars,20)
                .getMobileElemetFromList(score)
                .clickE();

        waitForDisplayAnElement(rateButton,20).clickE();
        return new MovieDetails(driver);
    }

    @Step("Select An Actor From Top Billed Cast")
    public MovieDetails selectAnActorFromTopBilledCast(){
        Logger.info("Scrolling up to Cast");
        verticalScrollTo("Cast");
        waitForDisplayElements(actorsList,20)
                .getMobileElemetFromList(0)
                .clickE();
        return new MovieDetails(driver);
    }
}
