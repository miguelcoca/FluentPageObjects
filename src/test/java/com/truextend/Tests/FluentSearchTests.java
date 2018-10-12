package com.truextend.Tests;

import com.truextend.Listeners.ScreenshotListener;
import com.truextend.PageObjects.GithubHomePage;
import com.truextend.PageObjects.GithubLoginPage;
import com.truextend.PageObjects.GoogleHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class FluentSearchTests extends TestBase {

    GoogleHomePage searchEngine;
    GithubHomePage githubHomePage;
    GithubLoginPage githubLoginPage;

    @BeforeClass
    public void setup(){
        searchEngine = new GoogleHomePage();
        githubLoginPage = new GithubLoginPage();
        githubHomePage = new GithubHomePage();
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
    public void fluentGitHubLogin() {
        githubLoginPage.NavigateTo("https://github.com/login")
                .EnterCredentials("LuisOsv", "Password")
                .HitSubmit()
                .VerifyWelcomeMessage("Repositories");
    }

}
