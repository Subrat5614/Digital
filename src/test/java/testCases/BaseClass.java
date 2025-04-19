package testCases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.BhadraSummary;
import pages.GeneralElement;
import utilities.ElementClicker;
import utilities.ExtentManager;
import utilities.Screenshots;
import utilities.ToastMessageHandler;
import utilities.WaitHelper;
import utilities.config;

public class BaseClass {
    protected static WebDriver driver; // Static ensures driver persists across test classes
    protected static ExtentReports extentReports; // Shared ExtentReports instance
    protected ExtentTest extentTest;
    protected WaitHelper wait;
    protected ToastMessageHandler toastHandler;
    protected GeneralElement ele;
    protected BhadraSummary summary;
    protected Actions action;
    protected Screenshots screenshot;
    protected ElementClicker clicker;
    private long startTime;
    protected final String EXCEL_FILE_PATH = "Configuration/Digital.xlsx";
    private static final Set<String> browserNames = Collections.synchronizedSet(new HashSet<>());

    // ========================== BEFORE SUITE ==========================
        @BeforeSuite
        @Parameters("browser")
        public void setUpSuite(@Optional("chrome") String browser) throws IOException, InterruptedException {
            // Initialize ExtentReports to generate HTML reports for one suite
            extentReports = ExtentManager.getInstance();
            addBrowserName(browser);
    
            // Detect OS
            String os = System.getProperty("os.name").toLowerCase();
            ChromeOptions options = new ChromeOptions();
    
            if (os.contains("win")) {
                // Windows ChromeDriver Path
                System.setProperty("webdriver.chrome.driver", ".\\Configuration\\chromedriver.exe");
            } else {
                // Linux (Docker) ChromeDriver Path
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
                options.addArguments("--headless");  // Headless mode for Docker
            }
    
            // Common ChromeOptions
            options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--disable-notifications");
            driver = new ChromeDriver(options);
            driver.manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(Long.parseLong(config.getProperty("implicitWaitTime"))));
            driver.manage().window().maximize();
            driver.get(config.getProperty("url"));
            driver.findElement(By.id("username")).sendKeys(config.getProperty("username"));
            driver.findElement(By.id("password")).sendKeys(config.getProperty("password"));
            driver.findElement(By.name("login")).click();
            Thread.sleep(10000); // Wait for login to complete
    
            extentReports.setSystemInfo("Browser", getBrowserNames());
        }
    

    // ========================== BEFORE CLASS ==========================
    @BeforeClass
    public void setUpExtentReports() throws IOException {
        extentReports = ExtentManager.getInstance(); // Ensure ExtentReports is initialized for each class
    }

    // ========================== BEFORE METHOD ==========================
    @BeforeMethod
    @Parameters("browser")
    public void setUpTest(Method method, String browser) throws NumberFormatException, IOException {
        // Initialize utilities
        wait = new WaitHelper(driver);
        ele = new GeneralElement(driver);
        summary = new BhadraSummary(driver);
        toastHandler = new ToastMessageHandler(driver);
        action = new Actions(driver);
        screenshot = new Screenshots(driver);
        clicker = new ElementClicker(driver);
        
        // Start test timer
        startTime = System.currentTimeMillis();

        // Create ExtentTest instance for each test method
        extentTest = extentReports.createTest(method.getName()).assignCategory("@Positive").assignDevice(browser);
    }

    // ========================== AFTER METHOD ==========================
    @AfterMethod
    public void logTestStatus(ITestResult result) {
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime) / 1000; // Convert to seconds

        String statusMessage = " ";

        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, "❌ Test Failed: " + result.getName());
            extentTest.log(Status.FAIL, "Error: " + result.getThrowable());
            screenshot.captureScreenshotOnFailure(driver, result.getName(), extentTest);
            extentTest.log(Status.FAIL, "Execution Time: " + duration + " seconds");
            statusMessage = "FAILED";
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, "✅ Test Passed: " + result.getName());
            extentTest.log(Status.PASS, "Execution Time: " + duration + " seconds");
            statusMessage = "PASSED";
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, "⚠️ Test Skipped: " + result.getName());
            extentTest.log(Status.SKIP, "Execution Time: " + duration + " seconds");
            statusMessage = "SKIPPED";
        }

        System.out.printf("--------------------------------------------------------%n");
        System.out.printf("Test '%s' %s and took %d seconds%n", result.getName(), statusMessage, duration);
        System.out.printf("--------------------------------------------------------%n");
    }

    // ========================== AFTER CLASS ==========================
    @AfterClass
    public void tearDownExtentReports() {
        if (extentReports != null) {
            extentReports.flush(); // Ensure logs are written for each class
        }
    }

    // ========================== AFTER SUITE ==========================
    @AfterSuite
    public void tearDownSuite() {
        if (driver != null) {
            driver.quit();
        }
        if (extentReports != null) {
            extentReports.flush(); // Finalize the report
        }
    }

    // ========================== GET BROWSER ==========================
    public static synchronized void addBrowserName(String browser) {
        browserNames.add(browser);
    }

    public static synchronized String getBrowserNames() {
        System.out.println("\nBrowser Names: " + browserNames);
        return String.join(", ", browserNames);
    }
}
