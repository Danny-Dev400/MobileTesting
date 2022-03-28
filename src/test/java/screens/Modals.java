package screens;

import baseTest.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class Modals extends BaseScreen {

    private final By dennyButton = By.id("com.android.permissioncontroller:id/permission_deny_button");
    //private final By dennyButton = By.id("com.android.packageinstaller:id/permission_deny_button");
    private final By okButtonInNotifications = By.id("android:id/button2");
    private final By notNowButton = By.id("com.imdb.mobile:id/splash_not_now");
    private final By singInWithGoogle = By.id("com.imdb.mobile:id/google_oauth");
    private final By userName = By.id("com.imdb.mobile:id/user_name");

    public Modals(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public Modals dennyLocation(){
        waitForDisplayAnElement(dennyButton,20).clickE();
        return this;
    }

    public Modals acceptNotifications(){
        waitForDisplayAnElement(okButtonInNotifications,20).clickE();
        return this;
    }

    public Modals skipLogin(){
        waitForDisplayAnElement(notNowButton,20).clickE();
        return this;
    }

    public void loginWithGoogle(){
        waitForDisplayAnElement(singInWithGoogle,20).clickE();
        waitForDisplayAnElement(userName,20);
    }

}
