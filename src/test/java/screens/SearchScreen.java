package screens;

import baseTest.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.pmw.tinylog.Logger;

import java.util.Random;

public class SearchScreen extends BaseScreen {

    private final By searchTextBox = By.id("com.imdb.mobile:id/search_src_text");
    private final By movieListResult = By.id("com.imdb.mobile:id/holder");

    public SearchScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Tap In Search Input")
    public SearchScreen tapInSearchInput(){
        waitForDisplayAnElement(searchTextBox,20).clickE();
        return new SearchScreen(driver);
    }

    @Step("Type A Movie")
    public SearchScreen typeAMovie(String query){
        Logger.info("Search the movie " + query);
        waitForDisplayAnElement(searchTextBox,20)
                .clearE()
                .sendKeysE(query);
        return new SearchScreen(driver);
    }

    @Step("Select A Movie From The Results")
    public MovieDetails selectAMovieFromTheResults(int movieId){
        waitForDisplayElements(movieListResult,30)
                .getMobileElemetFromList(movieId)
                .clickE();
        Logger.info("Click in the result " + (movieId+1));
        return new MovieDetails(driver);
    }

    @Step("Select A Random Movie From The Results")
    public MovieDetails selectARandomMovieFromTheResults(){
        Random r = new Random();
        String movieSelected = waitForDisplayElements(movieListResult,30)
                .getMobileElemetFromList(r.nextInt(getActualMultipleMobileElemets().size()))
                .getTextE();
        Logger.info("Click in in a random movie");
        getActualMobileElement().click();

        MovieDetails.actualMovieSelected = movieSelected;

        return new MovieDetails(driver);
    }
}
