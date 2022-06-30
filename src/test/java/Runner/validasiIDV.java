package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },

        features = {"src/test/resources/Features/validasi.feature"},
        glue = {"generateDefinitions"}
)

public class validasiIDV extends AbstractTestNGCucumberTests {
}
