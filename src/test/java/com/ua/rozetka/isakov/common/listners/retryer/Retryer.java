package com.ua.rozetka.isakov.common.listners.retryer;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class Retryer implements IRetryAnalyzer {
    private int retryCount = 0;
    protected Logger log = Logger.getLogger(this.getClass().getSimpleName());

    public boolean retry(ITestResult result) {
        int maxRetryCount = 5;
        if (retryCount < maxRetryCount) {
            retryCount++;
            log.info("Retryer #" + retryCount + " for test " + result.getMethod().getMethodName() + ", on thread " + Thread.currentThread().getName());
            return true;
        }
        return false;
    }

}
