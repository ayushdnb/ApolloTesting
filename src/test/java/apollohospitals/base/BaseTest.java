package apollohospitals.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import apollohospitals.urology.pageobjects.UrologyLanding;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public Log LOGGER=LogFactory.getLog(this.getClass());
	public WebDriver driver;
	Dimension windowSize = new Dimension(1440, 900);
	public UrologyLanding landingPage;
	
	public WebDriver initializeDriver() throws IOException {
		LOGGER.info("🧠🧠Starting WebDriver initialization method: `initializeDriver()` in apollohospitals.base.class🧠🧠");
		// Load global configuration
		 LOGGER.info("📥📥Loading properties from GlobalData.properties📥📥");
		Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                "\\src\\main\\java\\apollohospitals\\urology\\properties\\GlobalData.properties");
        prop.load(fis);
        LOGGER.info("✅✅Properties file loaded successfully✅✅");
        // Decide browser to use
        // First check system property (for CI/CD overrides), else use properties file value
        String browserName = System.getProperty("browser") != null
                ? System.getProperty("browser")
                : prop.getProperty("browser");
        LOGGER.info("🌍🌍Browser Configured:🌍🌍 " + browserName);
        if (browserName.contains("chrome")) {
        	LOGGER.info("🧩🧩Initializing Chrome browser🧩🧩");
            ChromeOptions options = new ChromeOptions();
            // If "headless" is in browser name, enable headless mode
            if (browserName.contains("headless")) {
            	LOGGER.info("👻👻Headless mode detected - enabling headless configuration👻👻");
                options.addArguments("headless");
                LOGGER.info("✅✅Chrome Headless mode configured successfully✅✅");
            }
            // Setup Chrome driver using WebDriverManager
            LOGGER.info("📦📦Setting up WebDriverManager for Chrome📦📦");
            WebDriverManager.chromedriver().setup();
            LOGGER.info("✅✅ChromeDriver setup via WebDriverManager✅✅");
            // Launch Chrome with desired options
            driver = new ChromeDriver(options);
            LOGGER.info("🖥️🖥️ChromeDriver launched successfully🖥️🖥️");
            // For headless mode or consistent viewports, set specific screen size
            driver.manage().window().setSize(windowSize);
            LOGGER.info("🪟🪟Browser dimensions set successfully to: " + 
            					windowSize.getWidth() + "x" + windowSize.getHeight()+"🪟🪟");
        // Step 4: Handle Firefox browser
        } else if (browserName.equalsIgnoreCase("firefox")) {
        	LOGGER.info("🧩🧩Initializing Firefox browser🧩🧩");
        	// Setup and launch FirefoxDriver
            WebDriverManager.firefoxdriver().setup();
            LOGGER.info("✅✅FirefoxDriver setup via WebDriverManager✅✅");
            driver = new FirefoxDriver();
            LOGGER.info("🦊🦊FirefoxDriver launched successfully🦊🦊");
        // Step 5: Handle Edge browser
        } else if (browserName.equalsIgnoreCase("edge")) {
        	LOGGER.info("🧩🧩Initializing Edge browser🧩🧩");
            // Setup and launch EdgeDriver
            WebDriverManager.edgedriver().setup();
            LOGGER.info("✅✅EdgeDriver setup via WebDriverManager✅✅");
            driver = new EdgeDriver();
            LOGGER.info("🪟🪟EdgeDriver launched successfully🪟🪟");
        }
        // Step 6: Apply browser settings (waits, window size)
        // Set implicit wait globally for all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LOGGER.info("⏱️⏱️Implicit wait set to 10 seconds successfully⏱️⏱️");
        // Maximize browser window (except when headless where it's already set)
        driver.manage().window().maximize();
        LOGGER.info("🖥️🖥️Browser window maximized successfully🖥️🖥️");
        // Final log indicating successful setup
        LOGGER.info("✅✅WebDriver initialization completed successfully✅✅");
        LOGGER.info("🏁🏁Exiting method: `initializeDriver()` in apollohospitals.base.class🏁🏁");
        return driver;
    }
	@BeforeMethod(alwaysRun = true)
	public UrologyLanding launchApplication() throws IOException {
	    LOGGER.info("🚀🚀Starting method: `launchApplication()` before test execution in apollohospitals.base.class🚀🚀");
	    // Step 1: Initialize the WebDriver using our configured browser setup
	    driver = initializeDriver();
	    LOGGER.info("🧠🧠WebDriver initialized successfully for LandingPage test🧠🧠");
	    // Step 2: Create an instance of the LandingPage with the initialized driver
	    landingPage = new UrologyLanding(driver);
	    LOGGER.info("📄 LandingPage object created");
	    // Step 3: Navigate to the application’s main URL
	    landingPage.goTo();
	    LOGGER.info("🌐🌐Navigated to LandingPage successfully🌐🌐");
	    LOGGER.info("✅✅`launchApplication()` completed and ready for test execution✅✅\n");
	    LOGGER.info("🏁🏁Exiting method: `launchApplication()` before test execution in apollohospitals.base.class🏁🏁");
	    return landingPage;
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
	    LOGGER.info("🧪🧪Test execution completed - entering teardown phase🧪🧪");
	    if (driver != null) {
	        driver.close(); // Close the browser window, not quitting the driver entirely
	        LOGGER.info("🧹🧹Browser window closed successfully after test🧹🧹");
	    } else {
	        LOGGER.warn("⚠️⚠️WebDriver was null during teardown⚠️⚠️");
	    }
	    LOGGER.info("🏁🏁Exiting method: `tearDown()` after test execution🏁🏁\n");
	}

}
