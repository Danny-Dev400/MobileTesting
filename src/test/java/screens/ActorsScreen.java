package screens;

import baseTest.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ActorsScreen extends BaseScreen {
    public ActorsScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean checkAMovieInTheActorTimeLine(String movieTittle){
        try {
            verticalScrollTo("Videos");
            horizontallScrollTo(movieTittle);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
