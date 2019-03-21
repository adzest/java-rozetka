package com.ua.rozetka.isakov.tests;

import com.ua.rozetka.isakov.common.listners.MyTestListener;
import com.ua.rozetka.isakov.helpers.App;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.lang.reflect.Method;
import java.util.Arrays;

@Listeners(MyTestListener.class)
public class BaseTest {

    protected static App app = new App();
    protected Logger log = Logger.getLogger(this.getClass().getSimpleName());


    @BeforeMethod(alwaysRun = true)
    public void initTest(Method method, Object[] p, ITestContext context) {
        app.base().startApp();
        log.info("[Framework] - Start test " + method.getName() +
                " with parameters " + Arrays.asList(p));
        context.setAttribute("app", app);
    }

    @AfterMethod
            (alwaysRun = true)
    public void stopApp(Method method) {
        app.base().stopApp();
        log.info("[Framework] - Finish testing " + method.getName());
        log.info("[Framework] - The result is - " + getTestResult(Reporter.getCurrentTestResult()));
    }

    private String getTestResult(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                return "PASSED";
            case ITestResult.FAILURE:
                return "FAILED";
            case ITestResult.SKIP:
                return "SKIP BLOCKED";
            default:
                throw new RuntimeException("Invalid status");
        }
    }
}