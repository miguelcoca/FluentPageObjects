package com.truextend.Tests;

import com.truextend.Config.DriverFactory;
import com.truextend.Listeners.ScreenshotListener;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(ScreenshotListener.class)
public class TestBase {

    RemoteWebDriver driver;

    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<DriverFactory> driverThread;

    TestBase() {
        if(webDriverThreadPool == null) {
            webDriverThreadPool = Collections.synchronizedList(new ArrayList<>());
        }

        if(driverThread==null) {
            driverThread = ThreadLocal.withInitial(() -> {
                DriverFactory webDriverThread = new DriverFactory();
                webDriverThreadPool.add(webDriverThread);
                return webDriverThread;
            });
        }
        try {
            driver = getDriver();
        }catch (Exception e){
            //continue
        }
    }

    @BeforeSuite(alwaysRun = true)
    public static void instantiateDriverObject() {
            driverThread = ThreadLocal.withInitial(() -> {
                DriverFactory webDriverThread = new DriverFactory();
                webDriverThreadPool.add(webDriverThread);
                return webDriverThread;
            });
    }

    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver = getDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public static void setTestName(Method method) {
    driverThread.get().setTestName(method.getName());
}

    public static RemoteWebDriver getDriver() throws MalformedURLException {
        return driverThread.get().getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public static void clearCookies() {
        try {
            getDriver().manage().deleteAllCookies();
        } catch (Exception ignored) {
            System.out.println("Unable to clear cookies, driver object is not viable...");
        }
    }

    @AfterSuite(alwaysRun = true)
    public static void closeDriverObjects() {
    for (DriverFactory webDriverThread : webDriverThreadPool) {
        webDriverThread.quitDriver();
    }
}
}