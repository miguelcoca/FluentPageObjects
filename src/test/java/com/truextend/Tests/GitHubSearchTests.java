package com.truextend.Tests;

import com.truextend.Listeners.ScreenshotListener;
import com.truextend.PageObjects.GitHubLoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class GitHubSearchTests extends TestBase {

    GitHubLoginPage loginEngine;

    @BeforeClass
    public void setup(){
        loginEngine = new GitHubLoginPage();
    }

    @Test
    public void fluentLogingToGiHub() throws Exception{

        loginEngine.NavigateTo("https://github.com/login")
                .EnterUserName("samuelmolina677@gmail.com")
                .EnterPassword("xxxxxxxxx")
                .VerifyResultsPageH2Contains("Learn Git and GitHub")
                .HitSignIn();
    }
}
