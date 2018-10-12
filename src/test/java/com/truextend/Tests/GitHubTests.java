package com.truextend.Tests;


import com.truextend.Listeners.ScreenshotListener;
import com.truextend.PageObjects.GitHubHomePage;
import com.truextend.PageObjects.GitHubLogin;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)

public class GitHubTests extends TestBase{
    GitHubLogin gitHubLoginPage;

    @BeforeClass
    public void setup(){
        gitHubLoginPage = new GitHubLogin();
    }

    @Test
    public void fluentGoogleCheeseSearch() throws Exception{

        gitHubLoginPage.NavigateTo("https://github.com/login")
                .SelectLoginField()
                .TypeInLoginField("Aleli03")
                .SelectPassField()
                .TypeInPassField("")
                .HitEnter()
                .VerifyTextInBanner("Learn Git and GitHub without any code!");
    }
}
