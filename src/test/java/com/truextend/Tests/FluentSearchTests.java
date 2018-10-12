package com.truextend.Tests;

import com.truextend.Listeners.ScreenshotListener;
import com.truextend.PageObjects.GitHubLogin;
import com.truextend.PageObjects.GoogleHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class FluentSearchTests extends TestBase {

    GoogleHomePage searchEngine;
    GitHubLogin loginGH;

    @BeforeClass
    public void setup(){
        searchEngine = new GoogleHomePage();
        loginGH = new GitHubLogin();
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
    public void fluentGitHubLogin() throws Exception{

        loginGH.NavigateTo("https://github.com/login")
                .SelectUsernameBox()
                .TypeInUsername("arnold-huanca")
                .SelectPasswordBox()
                .TypeInPassword("pass")
                .HitEnter()
                .VerifyResultsPageBodyContains("Learn Git and GitHub without any code!");
    }
}
