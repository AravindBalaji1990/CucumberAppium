package stepdef_apidemos;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import stepdef_hook.HooksImplementation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class StepDefPageApiDemos  {

    AndroidDriver driver;
    Scenario scenario;

    @Before
    public void start(Scenario scenario) throws MalformedURLException, InterruptedException {
        this.scenario = scenario;
        scenario.log("-------- starting my case----------");
        user_opens_the_android_app_api_demos(scenario);

    }
    @After
    public void end(){
            driver.quit();
    }

    @AfterStep
    public void teardown(Scenario scenario) {
        scenario.log("---------ending my case---------");
//        if (scenario.getStatus().toString().equals("PASSED")) {
//        if (scenario.isFailed()) {
            try {
                scenario.log("test log : " + scenario.getStatus());
                // byte[] screenshot = getScreenshotAs(OutputType.BYTES);
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

//        }
//        }
    }
    @Given("User opens the Android App Api Demos")
    public void user_opens_the_android_app_api_demos(Scenario scenario) throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("29221JEGR00379");
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//        options.setApp("/Users/aravindbalaji/Documents/Appium/Sample App/android-app.apk");
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity("io.appium.android.apis.ApiDemos");
        options.setAppWaitForLaunch(true);

        // calling the andorid driver to run the app
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        Thread.sleep(3000);
        scenario.log("------------ the appium server is started ---------");
    }

    @When("User scrolls and checks for the option Views")
    public void user_scrolls_and_checks_for_the_option_views() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Views\").instance(0))"));
        scenario.log("the visibility of element :" +driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Views']")).isDisplayed());
        Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Views']")).isDisplayed());
    }

    @Then("User clicks on the views menu")
    public void user_clicks_on_the_views_menu() {
        WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Views']"));
        element.click();
    }

    @Then("User clicks the section textfields")
    public void user_clicks_the_section_textfields() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"TextFields\").instance(0))")).click();

    }

    @Then("User enters the data {}")
    public void user_enters_the_data(String data) {
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]")).sendKeys(data);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]")).clear();
    }

    @Then("User enters the multiple set of data <data>")
    public void user_enters_the_multiple_set_of_data_data(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]")).sendKeys(data.get(i).get("data"));
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]")).clear();
        }
    }


    @Then("User enters different dataset {} and {}")
    public void user_enters_different_dataset_fname1_and_lname1(String data1, String Data1) {
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]")).sendKeys(data1 +" - " +Data1);
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"io.appium.android.apis:id/edit1\"]")).clear();
    }
}
