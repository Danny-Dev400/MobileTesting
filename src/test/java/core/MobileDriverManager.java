package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileDriverManager {

    private static AndroidDriver<MobileElement> driver;

    public static AndroidDriver<MobileElement> setupDriver(String pathCapabilities ,String jsonFileName){
        String path = pathCapabilities + jsonFileName;
        try {
            ConfigCapabilities capabilities = new ConfigCapabilities(path);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<MobileElement>(url,capabilities.getCapabilities());
        } catch ( MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
