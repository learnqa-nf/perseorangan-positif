package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-report/cucumber.html",
                "json:target/cucumber-report/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        tags = "@approvementApproval",
        features = {"src/test/resources/Features/dataDummyApprove.feature"},
        glue = {"generateDefinitions"}
)

public class Approvement extends AbstractTestNGCucumberTests {
}