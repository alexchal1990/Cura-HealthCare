package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.edge.EdgeDriver;

import pageObjects.LandingPage;

public class BaseT {

    public WebDriver driver;
    public LandingPage landingPage;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();      // <-- Driver properly created here
    }
    
    
    
    public WebDriver initializeDriver() throws IOException {

        // Load properties file
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "/src/main/java/resources/GlobalData.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        // Browser selection
        if (browserName.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            //  Disable Chrome password save popups & notifications
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_manager_leak_detection", false);
            prefs.put("profile.default_content_setting_values.notifications", 2);

            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");

            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();
        }

        // Window and waits
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    // Launch application and return landing page object
    public LandingPage launchApplication() throws IOException {
        driver = initializeDriver();
        landingPage = new LandingPage(driver);
        landingPage.GoTo();
        return landingPage;
    }
    @AfterMethod
    // Clean close after each test
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
