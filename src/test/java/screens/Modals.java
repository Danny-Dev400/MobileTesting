package screens;

import baseTest.BaseScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.pmw.tinylog.Logger;

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

    @Step("Denny location")
    public Modals dennyLocation(){
        Logger.info("Waiting for denny button...");
        waitForDisplayAnElement(dennyButton,20).clickE();
        Logger.info("Click denny button");
        return this;
    }

    @Step("Accept Notifications")
    public Modals acceptNotifications(){
        Logger.info("Waiting for accept notifications button...");
        waitForDisplayAnElement(okButtonInNotifications,20).clickE();
        Logger.info("Click accept notifications button");
        return this;
    }

    @Step("Skip Login")
    public Modals skipLogin(){
        Logger.info("Waiting for not now button...");
        waitForDisplayAnElement(notNowButton,20).clickE();
        Logger.info("Click not now button");
        return this;
    }

    @Step("Login with google account")
    public void loginWithGoogle(){
        Logger.info("Waiting sign in with google button...");
        waitForDisplayAnElement(singInWithGoogle,20).clickE();
        Logger.info("Click in sign in with google");
        waitForDisplayAnElement(userName,20);
        Logger.info("Successful login");
    }

}
