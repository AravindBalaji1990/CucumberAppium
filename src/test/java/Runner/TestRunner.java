package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/ApiDemosAndroidApp",
        glue = {"stepdef_apidemos" },
        monochrome = true,
        dryRun= false,
        plugin= {"pretty","html:HTMLReport"})
public class TestRunner {

}
