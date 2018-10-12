package com.truextend.Tests;

import com.truextend.Listeners.ScreenshotListener;
import com.truextend.PageObjects.GITLogin;
import com.truextend.PageObjects.GoogleHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class FluentSearchTests extends TestBase {

    GoogleHomePage searchEngine;
    GITLogin login;

    @BeforeClass
    public void setup(){

        searchEngine = new GoogleHomePage();
        login = new GITLogin();
    }

    @Test
    public void fluentGoogleCheeseSearch() throws Exception{

        searchEngine.NavigateTo("http://www.google.com")
                .SelectSearchBox()
                .TypeIn("Cheese!")
                .HitEnter()
                .VerifyResultsPageTitleContains("Cheese");
    }

    @Test
    public void fluentGITLogin() throws Exception{

        login.NavigateTo("https://github.com/login").FillUsername().FillPassword().HitSignIn().VerifyResultsPageTitleContains();
    }

}
