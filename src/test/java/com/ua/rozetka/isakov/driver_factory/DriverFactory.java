package com.ua.rozetka.isakov.driver_factory;

import com.ua.rozetka.isakov.common.Constants;
import org.apache.commons.exec.OS;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static RemoteWebDriver webDriver;

    public static RemoteWebDriver getDriver() {
        String target = System.getProperty("target".toLowerCase(), "local");
        if (target.equals("local")) {
            String osSensitiveBinaryPath;
            if (OS.isFamilyMac()) {
                osSensitiveBinaryPath = "drivers/mac/%s";
            } else if (OS.isFamilyWindows()) {
                osSensitiveBinaryPath = "drivers/win/%s.exe";
            } else {
                osSensitiveBinaryPath = "drivers/unix/%s";
            }

            String webDriverPath;
            switch (System
                    .getProperty("browser", "chrome")) {
                case BrowserType.FIREFOX:
                    webDriverPath = String.format(osSensitiveBinaryPath, "geckodriver");
                    System.setProperty("webdriver.gecko.driver", webDriverPath);
                    webDriver = new FirefoxDriver();
                    break;
                case BrowserType.CHROME:
                    webDriverPath = String.format(osSensitiveBinaryPath, "chromedriver");
                    System.setProperty("webdriver.chrome.driver", webDriverPath);
                    webDriver = new ChromeDriver();
                    break;
                case BrowserType.IE:
                    webDriverPath = String.format(osSensitiveBinaryPath, "IEDriverServer");
                    System.setProperty("webdriver.ie.driver", webDriverPath);
                    webDriver = new InternetExplorerDriver();
                    break;
                case BrowserType.EDGE:
                    webDriverPath = String.format(osSensitiveBinaryPath, "MicrosoftWebDriver");
                    System.setProperty("webdriver.edge.driver", webDriverPath);
                    webDriver = new EdgeDriver();
                    break;
                case BrowserType.SAFARI:
                    webDriverPath = String.format(osSensitiveBinaryPath, "safaridriver");
                    System.setProperty("webdriver.safari.driver", webDriverPath);
                    webDriver = new SafariDriver();
                    break;
            }
        } else if (target.equalsIgnoreCase("Jenkins")) {
            System.out.println("Not implemented.");
        }
        if(webDriver != null){
            webDriver.manage().timeouts().implicitlyWait(Constants.INT_WEB_TIMEOUT, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
        }

        return webDriver;
    }
}