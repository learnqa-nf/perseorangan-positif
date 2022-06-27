package Capture;

import Config.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TakeSreenshot {

    public void capture(WebDriver driver, int i) {
        ImageExcel imageExcel = new ImageExcel();

        String pthFileImageName = Constants.pthFileImage;

        String pattern = Constants.pPattern;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formattedToday = simpleDateFormat.format(new Date());

        String fullPathName = pthFileImageName + formattedToday + Constants.extPict;
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File(fullPathName));
            // insert to excel existing
            imageExcel.insertImages(fullPathName, i);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
