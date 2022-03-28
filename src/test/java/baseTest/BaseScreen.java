package baseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class BaseScreen {

    protected AndroidDriver<MobileElement> driver;

    private MobileElement actualMobileElement = null;
    private List<MobileElement> actualMultipleMobileElemets = null;

    public BaseScreen(AndroidDriver<MobileElement> driver){
        this.driver = driver;
    }

    public BaseScreen waitForDisplayAnElement(By element, int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        actualMobileElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return this;
    }

    public BaseScreen waitPresenceOfElement(By element, int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        actualMobileElement = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return this;
    }

    public BaseScreen waitForDisplayElements(By element, int time){
        actualMultipleMobileElemets = new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element))
                .stream()
                .map(item -> (MobileElement) item)
                .collect(Collectors.toList());
        return this;
    }

    public BaseScreen getMobileElemetFromList(int index){
        actualMobileElement = actualMultipleMobileElemets.get(index);
        return this;
    }

    public BaseScreen findMobileElement(By element){
        actualMobileElement = (MobileElement) driver.findElement(element);
        return this;
    }

    public List<MobileElement> findMobileElements(By element){
        return driver.findElements(element);
    }

    public BaseScreen clickE(){
        actualMobileElement.click();
        return this;
    }

    public BaseScreen sendKeysE(String query){
        actualMobileElement.sendKeys(query);
        return this;
    }

    public BaseScreen clearE(){
        actualMobileElement.clear();
        return this;
    }

    public String getTextE(){
        return actualMobileElement.getText();
    }

    public BaseScreen verticalScrollTo(String textToSearch){
        this.actualMobileElement = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" +
                "new UiSelector().textContains(\""+ textToSearch +"\").instance(0))");
        return this;
    }

    public BaseScreen horizontallScrollTo(String textToSearch){
        this.actualMobileElement = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.imdb.mobile:id/recycler_view\")" +
                ".scrollable(true)).setAsHorizontalList().scrollIntoView(" +
                "new UiSelector().text(\""+ textToSearch +"\").instance(0))");
        return this;
    }

    //// getters and setters

    public MobileElement getActualMobileElement() {
        return actualMobileElement;
    }

    public BaseScreen setActualMobileElement(MobileElement actualMobileElement) {
        this.actualMobileElement = actualMobileElement;
        return this;
    }

    public List<MobileElement> getActualMultipleMobileElemets() {
        return actualMultipleMobileElemets;
    }

    public BaseScreen setActualMultipleMobileElemets(List<MobileElement> actualMultipleMobileElemets) {
        this.actualMultipleMobileElemets = actualMultipleMobileElemets;
        return this;
    }



}
