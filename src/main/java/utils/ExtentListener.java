package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReport();
    ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testThread.set(test);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest test = testThread.get();
        test.fail(result.getThrowable());

        try {
            WebDriver driver = (WebDriver) result.getTestClass()
                    .getRealClass()
                    .getField("driver")
                    .get(result.getInstance());

            String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName());
            test.addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
