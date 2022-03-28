package screens;

import baseTest.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

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

    public String getMovieDescription(){
        return waitForDisplayAnElement(movieDescription,20).getTextE();
    }

    public MovieDetails addToWatchList(){
        try {
            waitPresenceOfElement(addToWatchListbutton,20).clickE();
        }catch (Exception e){
            waitForDisplayAnElement(removeFromWatchListbutton,20).clickE();
            waitForDisplayAnElement(addToWatchListbutton,20).clickE();
        }

        return new MovieDetails(driver);
    }

    public MovieDetails rateAMovie(int score){
        verticalScrollTo("Your Rating").clickE();
        waitForDisplayElements(ratingStars,20)
                .getMobileElemetFromList(score)
                .clickE();

        waitForDisplayAnElement(rateButton,20).clickE();
        return new MovieDetails(driver);
    }

    public MovieDetails selectAnActorFromTopBilledCast(){
        verticalScrollTo("Cast");
        waitForDisplayElements(actorsList,20)
                .getMobileElemetFromList(0)
                .clickE();
        return new MovieDetails(driver);
    }
}
