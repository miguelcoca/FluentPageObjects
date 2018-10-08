package com.truextend.PageObjects;

import com.truextend.Tests.TestBase;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

abstract class BasePage {

    RemoteWebDriver driver;

    BasePage() {
        try {
            driver = TestBase.getDriver();
        } catch (MalformedURLException ignored) {
            //This will be be thrown when the test starts if it cannot connect to a RemoteWebDriver Instance
        }
    }
}