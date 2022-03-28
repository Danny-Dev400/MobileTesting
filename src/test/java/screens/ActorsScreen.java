package screens;

import baseTest.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.pmw.tinylog.Logger;

public class ActorsScreen extends BaseScreen {
    public ActorsScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Check A Movie In TheActor Time Line...")
    public boolean checkAMovieInTheActorTimeLine(String movieTittle){
        try {
            Logger.info("Scrolling to the actor's movies...");
            verticalScrollTo("Videos");
            Logger.info("Scrolling through the actor's movies until you find" + movieTittle + "...");
            horizontallScrollTo(movieTittle);
            return true;
        }catch(Exception e){
            Logger.error("Can't find the elements");
            e.printStackTrace();
            return false;
        }
    }


}
