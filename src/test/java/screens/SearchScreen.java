package screens;

import baseTest.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.Random;

public class SearchScreen extends BaseScreen {

    private final By searchTextBox = By.id("com.imdb.mobile:id/search_src_text");
    private final By movieListResult = By.id("com.imdb.mobile:id/holder");

    public SearchScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public SearchScreen tapInSearchInput(){
        waitForDisplayAnElement(searchTextBox,20).clickE();
        return new SearchScreen(driver);
    }

    public SearchScreen typeAMovie(String query){
        waitForDisplayAnElement(searchTextBox,20)
                .clearE()
                .sendKeysE(query);
        return new SearchScreen(driver);
    }

    public MovieDetails selectAMovieFromTheResults(int movieId){
        waitForDisplayElements(movieListResult,30)
                .getMobileElemetFromList(movieId)
                .clickE();
        return new MovieDetails(driver);
    }

    public MovieDetails selectARandomMovieFromTheResults(){
        Random r = new Random();
        String movieSelected = waitForDisplayElements(movieListResult,30)
                .getMobileElemetFromList(r.nextInt(getActualMultipleMobileElemets().size()))
                .getTextE();

        getActualMobileElement().click();

        MovieDetails.actualMovieSelected = movieSelected;

        return new MovieDetails(driver);
    }
}
