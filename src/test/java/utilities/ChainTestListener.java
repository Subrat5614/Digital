package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ChainTestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("\nTest Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("\nTest Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("\nTest Failed: " + result.getName() + " because of " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("\nTest Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("\nTest Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("\nTest Suite Finished: " + context.getName());
    }
}
