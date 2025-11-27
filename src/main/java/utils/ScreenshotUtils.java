package utils;

import java.io.File;
import java.nio.file.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String testName) {

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String dest = System.getProperty("user.dir") + "/reports/screenshots/" + testName + ".png";
            File file = new File(dest);

            file.getParentFile().mkdirs();
            Files.copy(src.toPath(), file.toPath());

            return dest;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
