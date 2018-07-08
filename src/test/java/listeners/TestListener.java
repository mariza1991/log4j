package listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tools.Screenshot;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

public class TestListener implements ITestListener {

    private Logger logger = Logger.getLogger(TestListener.class);

    public void onTestStart(ITestResult iTestResult) {
        logger.info("Test starts...");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.warn("FAIL");
        Date failedTime = new Date(result.getEndMillis());
        logger.error("" + failedTime + result.getTestClass() + result.getTestName());
        StringWriter sb = new StringWriter();
        PrintWriter pw = new PrintWriter(sb);
        Throwable cause = result.getThrowable();
        cause.printStackTrace();
        logger.error(sb.getBuffer().toString());

        Screenshot screenshot = new Screenshot();
        screenshot.makeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
