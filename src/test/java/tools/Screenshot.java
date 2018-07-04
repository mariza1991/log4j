package tools;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Screenshot {

    private static final String PATH_TO_SCRENSHOT = "src/main/output/";

    public void makeScreenshot(WebDriver driver)
    {
        DateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = dateFormat.format(today);

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(PATH_TO_SCRENSHOT + "screenshot." + reportDate + ".png"));
        } catch (IOException e) {}
    }
}
