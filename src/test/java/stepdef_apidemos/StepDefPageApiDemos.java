package stepdef_apidemos;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class StepDefPageApiDemos {

    AndroidDriver driver;

    @Given("User opens the Android App Api Demos")
    public void user_opens_the_android_app_api_demos() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("emulator-5554");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
        options.setAppWaitForLaunch(true);

        // calling the andorid driver to run the app
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(3000);
    }

    @When("User scrolls and checks for the option Views")
    public void user_scrolls_and_checks_for_the_option_views() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Views\").instance(0))"));
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Views']")).isDisplayed());
    }

    @Then("User clicks on the views menu")
    public void user_clicks_on_the_views_menu() {
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Views']"));
        element.click();
    }

}
