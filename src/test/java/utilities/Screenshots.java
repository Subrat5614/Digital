package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.util.FileCopyUtils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class Screenshots {

    public Screenshots(WebDriver driver) {
    }
    public String timestamp() {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH-mm-ss");// include upto seconds
		// String timestamp = LocalDateTime.now().toString().replace(":", "-");
		String timestamp = LocalDateTime.now().format(formatter);
		return timestamp;
	}
     public void captureScreenshotOnFailure(WebDriver driver, String testName, ExtentTest extentTest) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File sourceFile = ts.getScreenshotAs(OutputType.FILE);
            String screenshotDir = System.getProperty("user.dir") + "/Screenshots/";
            File dir = new File(screenshotDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String screenshotPath = screenshotDir + testName + "_" + timestamp() + "_failure.png";
            File destinationFile = new File(screenshotPath);
            FileUtils.copyFile(sourceFile, destinationFile);
            if (destinationFile.exists()) {
                extentTest.fail("Test Failed: " + testName,
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                extentTest.fail("Screenshot file not found: " + screenshotPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public void captureElementScreenshotOnFailure(WebDriver driver,WebElement element,ExtentTest extentTest) {
		try {
			File sourceFile = element.getScreenshotAs(OutputType.FILE);
			String screenshotPath = System.getProperty("user.dir") +"Screenshots/"
					+"_"+ timestamp() + "_failure.png";
			File destinationFile = new File(screenshotPath);
			FileCopyUtils.copy(sourceFile, destinationFile);
//			FileUtils.copyFile(sourceFile, destinationFile);
			// extentTest.log(Status.FAIL, "Screenshot: " + screenshotPath);
			// extentTest.addScreenCaptureFromPath(screenshotPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
