package screens;

import baseTest.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginScreen extends BaseScreen {

    public LoginScreen(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
}
