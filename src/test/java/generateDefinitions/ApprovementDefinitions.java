package generateDefinitions;

import BadanUsaha.Approvement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class ApprovementDefinitions {
    private WebDriver driver;
    Approvement approvement = new Approvement();

    @Given("open browser and login application using {string} and {string}")
    public void open_browser_and_login_application_using_and(String userMaker, String pass) throws InterruptedException {

        EdgeOptions options = new EdgeOptions();
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

        approvement.setDriver(driver);
        approvement.loginMaker(userMaker, pass);
    }
    @And("user bulk recomendation")
    public void user_bulk_recomendation() throws InterruptedException {
        approvement.setApproval();
    }
    @Then("UserMaker logout application")
    public void user_maker_logout_application() throws InterruptedException {

        approvement.logout();
    }
    @And("login application using {string} and {string}")
    public void login_application_using_and(String userApprover, String pass) throws InterruptedException {

        approvement.loginApprover(userApprover, pass);
    }
    @Then("UserApprover logout application")
    public void user_approver_logout_application() throws InterruptedException {

        approvement.setApprovement();
    }
}
