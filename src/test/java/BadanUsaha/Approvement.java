package BadanUsaha;

import Config.Constants;
import TestData.ReadTestData;
import Capture.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Approvement {

    private WebDriver driver;

    By userId = By.id("username");
    By pwd = By.id("password");
    By btnLogin = By.xpath("//button[contains(.,'Sign In')]");
    By menuApproval = By.xpath("//li[11]/a/div");
    By btnBulkRecomend = By.linkText("Bulk Recommendation");
    By txtSearch = By.id("search-filter");
    By radiobtnAppAll = By.xpath("//table[@id='channelingApprovalDataTable']/thead/tr/th/div/label");
    By recomended = By.xpath("//button[@id='recommended']");
    By btnProfile = By.xpath("//a[@id='header-foto-profil']");
    By btnLogout = By.linkText("Logout");
    By btnDetails = By.id("details-button");
    By btnUnsafe = By.id("proceed-link");
    By noDataTable = By.xpath("//td[contains(.,'No matching records found')]");
    By statusForReview = By.xpath("//*[@id='select-status']/option[3]");
    By statusForApproval = By.xpath("//*[@id='select-status']/option[4]");

    int rowImages = 60;
    int iAppend = 60;

    ReadTestData readTestData = new ReadTestData();
    TakeSreenshot takeSreenshot = new TakeSreenshot();

    public void setDriver(WebDriver driver) {

        this.driver = driver;
        readTestData.testData();
    }

    // Login Maker
    public void loginMaker(String user, String pass) throws InterruptedException {

        driver.get(Constants.url);
        driver.manage().window().maximize();
        driver.findElement(btnDetails).click();
        driver.findElement(btnUnsafe).click();
        driver.findElement(userId).sendKeys(user);
        Thread.sleep(1500);
        driver.findElement(pwd).sendKeys(pass);
        //capture
        takeSreenshot.capture(driver, 2);
        driver.findElement(btnLogin).click();
    }

    public void setApproval() throws InterruptedException {

        String v = readTestData.timeStamp;
        Thread.sleep(1500);
        //capture
        takeSreenshot.capture(driver, rowImages);

        driver.findElement(menuApproval).click();
        Thread.sleep(1500);

        //capture
        rowImages = rowImages + iAppend;
        takeSreenshot.capture(driver, rowImages);
        driver.findElement(btnBulkRecomend).click();
        Thread.sleep(1500);
        Boolean status = true;

        //capture
        rowImages = rowImages + iAppend;
        takeSreenshot.capture(driver, rowImages);
        while (status.equals(true)) {
            driver.findElement(txtSearch).sendKeys(readTestData.timeStamp);
            Thread.sleep(1500);
            driver.findElement(statusForReview).click();
            Thread.sleep(1500);
            //capture
            rowImages = rowImages + iAppend;
            takeSreenshot.capture(driver, rowImages);

            if (driver.getPageSource().contains(Constants.noMatch) || driver.getPageSource().contains(Constants.noData)) {
                status = false;
                //capture
                rowImages = rowImages + iAppend;
                takeSreenshot.capture(driver, rowImages);
            } else if (status.equals(true)) {

                driver.findElement(radiobtnAppAll).click();
                Thread.sleep(1500);
                //capture
                rowImages = rowImages + iAppend;
                takeSreenshot.capture(driver, rowImages);
                driver.findElement(recomended).click();
                Thread.sleep(1500);

            }
        }
    }

    public void logout() throws InterruptedException {
        rowImages = rowImages + iAppend;

        Thread.sleep(1500);
        driver.findElement(btnProfile).click();
        Thread.sleep(1500);
        //capture
        takeSreenshot.capture(driver, rowImages);
        driver.findElement(btnLogout).click();
        Thread.sleep(1500);
        //capture
        rowImages = rowImages + iAppend;
        takeSreenshot.capture(driver, rowImages);

    }

    // Login Approver
    public void loginApprover(String userApprover, String pass) throws InterruptedException {

        rowImages = rowImages + iAppend;
        Thread.sleep(1500);
        driver.findElement(userId).sendKeys(userApprover);
        Thread.sleep(1500);
        driver.findElement(pwd).sendKeys(pass);
        //capture
        takeSreenshot.capture(driver, rowImages);
        driver.findElement(btnLogin).click();
    }


    public void setApprovement() throws InterruptedException {

        Thread.sleep(1500);
        driver.findElement(menuApproval).click();
        Thread.sleep(1500);
        //capture
        rowImages = rowImages + iAppend;
        takeSreenshot.capture(driver, rowImages);

        driver.findElement(btnBulkRecomend).click();
        Thread.sleep(1500);
        Boolean status = true;
        while (status.equals(true)) {
            driver.findElement(txtSearch).sendKeys(readTestData.timeStamp);
            Thread.sleep(1500);
            driver.findElement(statusForApproval).click();
            Thread.sleep(1500);

            //capture
            rowImages = rowImages + iAppend;
            takeSreenshot.capture(driver, rowImages);
            if (driver.getPageSource().contains(Constants.noMatch) || driver.getPageSource().contains(Constants.noData)) {
                status = false;
                //capture
                rowImages = rowImages + iAppend;
                takeSreenshot.capture(driver, rowImages);
            } else if (status.equals(true)) {
                driver.findElement(radiobtnAppAll).click();
                Thread.sleep(1500);
                //capture
                rowImages = rowImages + iAppend;
                takeSreenshot.capture(driver, rowImages);
                driver.findElement(recomended).click();
                Thread.sleep(1500);
            }
        }
        //capture
        rowImages = rowImages + iAppend;
        takeSreenshot.capture(driver, rowImages);

        Thread.sleep(1500);
        driver.findElement(btnProfile).click();
        Thread.sleep(1500);
        driver.findElement(btnLogout).click();
        Thread.sleep(1500);
        //capture
        rowImages = rowImages + iAppend;
        takeSreenshot.capture(driver, rowImages);

    }
}