package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        features = "src/test/resources/SampleFeature",
//        glue = {"stepdef_apidemos","stepdef_hook" },
        features = "src/test/resources/ApiDemosAndroidApp",
        glue = {"stepdef_apidemos" },
        monochrome = true,
        dryRun= false,
        tags = "@testsanity",
        plugin= {"pretty","html:HTMLReport.html"})
public class TestRunner {
    @Before
    public void start(){

    }

}
