package utilities;

import java.io.IOException;

import org.apache.commons.lang3.time.FastDateFormat;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extentReports;
     public static ExtentReports getInstance() throws IOException {
        if (extentReports == null) {
            extentReports = new ExtentReports();
            FastDateFormat dateFormat = FastDateFormat.getInstance("yyyy_MM_dd_HH_mm");
            String dateTime = dateFormat.format(System.currentTimeMillis());
            String fileName = "./OutputReport/extent-report_" + dateTime + ".html";
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
            htmlReporter.config().setReportName("Automated Test Execution Report");
            htmlReporter.config().setDocumentTitle("ChainTest Execution Report");
            htmlReporter.config().setTheme(Theme.DARK);
             // Display category/tag information in the report
             htmlReporter.config().setEncoding("UTF-8");
             htmlReporter.config().setTimelineEnabled(true);
            extentReports.attachReporter(htmlReporter);
            extentReports.setSystemInfo("Test Environment", config.getProperty("url"));
            extentReports.setSystemInfo("Tester", System.getProperty("user.name"));
            extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
            extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        }
        return extentReports;
    }
}
