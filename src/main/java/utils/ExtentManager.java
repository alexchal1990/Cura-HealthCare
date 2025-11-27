package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            String path = System.getProperty("user.dir") + "/reports/Report.html";

            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("CURA Automation Results");
            reporter.config().setDocumentTitle("Test Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Alex");
        }

        return extent;
    }
}
