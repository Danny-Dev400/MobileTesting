package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseTest.Hooks;

public class IMDBTests extends Hooks {

    @Test
    public void searchAMovieAndCheckTheOverviewed(){
        String movieDescription = "An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.";
        navbar.goToSearchScreen();
        searchScreen.tapInSearchInput()
                .typeAMovie("fight club");
        searchScreen.selectAMovieFromTheResults(0);

        Assert.assertEquals(movieDetails.getMovieDescription(),movieDescription);
    }

    @Test
    public void addAMovieInTheWatchListAndVerify(){
        navbar.goToProfileScreen();

        profileScreen.clickInSignInSignUpButton();
        modals.loginWithGoogle();

        navbar.goToSearchScreen();
        searchScreen.tapInSearchInput()
                .typeAMovie("Avengers")
                .selectARandomMovieFromTheResults();

        movieDetails.addToWatchList();

        navbar.goToProfileScreen();

        Assert.assertTrue(profileScreen.checkIfAMovieIsInTheWatchlist());
    }

    @Test
    public void rateAMovieAndVerify(){
        navbar.goToProfileScreen();

        profileScreen.clickInSignInSignUpButton();
        modals.loginWithGoogle();

        navbar.goToSearchScreen();
        searchScreen.tapInSearchInput()
                .typeAMovie("Men in Black")
                .selectAMovieFromTheResults(0);

        movieDetails.rateAMovie(6);
        navbar.goToProfileScreen();

        profileScreen.clickInRatingMovies();

        Assert.assertTrue(ratingHistoryScreen.checkMovieRating("Men in Black"));
    }

    @Test
    public void checkAMovieInTheActorTimeLine(){
        navbar.goToSearchScreen();
        searchScreen.tapInSearchInput()
                .typeAMovie("The Conjuring")
                .selectAMovieFromTheResults(0);

        movieDetails.selectAnActorFromTopBilledCast();

        Assert.assertTrue(actorsScreen.checkAMovieInTheActorTimeLine("The Conjuring"));
    }
}
