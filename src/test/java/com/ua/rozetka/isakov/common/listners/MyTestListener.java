package com.ua.rozetka.isakov.common.listners;

import com.ua.rozetka.isakov.common.Constants;
import com.ua.rozetka.isakov.common.issue_tracker.JiraIssue;
import com.ua.rozetka.isakov.helpers.App;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.*;

public class MyTestListener implements ITestListener, IInvokedMethodListener {

    @Attachment(value = "{0}", type = "text/plain")
    private static String saveTextLog(String message) {
        return message;
    }

    @Attachment(value = "HTML Page source", type = "text/html")
    private static String saveHTMLPage(String html) {
        return html;
    }

    @Attachment(value = "XML Page source", type = "text/xml")
    private static String saveXMLPage(String pageSource) {
        return pageSource;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(RemoteWebDriver driver) {
        return driver.getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void afterInvocation(IInvokedMethod invokedMethod, ITestResult result) {
        App app = (App) result.getTestContext().getAttribute("app");
        JiraIssue issue =
                invokedMethod.getTestMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraIssue.class);
        if (issue != null) {
            // TODO - ?: Add handler for the case when the issue is reproducible on a specific platform or environment
        }
        //TODO opposite case for reopen already existed issue
    }

    @Override
    public void beforeInvocation(IInvokedMethod invokedMethod, ITestResult result) {
        // TODO - ?: https://dzone.com/articles/how-to-automatically-skip-tests-based-on-defects-s
    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        App app = (App) result.getTestContext().getAttribute("app");
        RemoteWebDriver driver = app.base().getDriver();
        if (driver != null) {
            saveScreenshot(driver);
            if (System.getProperty("appCaps") != null) {
                saveXMLPage(driver.getPageSource());
                saveTextLog("App connects to the NMA server: " + Constants.getProperties().getProperty("nmaUri"));
            } else {
                saveHTMLPage(driver.getPageSource());
                saveTextLog("Expected stage URL: " + Constants.getProperties().getProperty("baseUrl") + "\n"
                        + "Actual stage URL: " + driver.getCurrentUrl());
            }
        }
        saveTextLog(result.getThrowable().toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
