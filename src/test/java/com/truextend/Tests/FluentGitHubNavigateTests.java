package com.truextend.Tests;

import com.truextend.Listeners.ScreenshotListener;
import com.truextend.PageObjects.GitHubLogin;
import com.truextend.PageObjects.GoogleHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class FluentGitHubNavigateTests extends TestBase  {
    GitHubLogin gitHubLogin;
    private String login = "pitermontesc" ;
    private String pass  = "mypass" ;

    @BeforeClass
    public void setup(){
        gitHubLogin = new GitHubLogin();
    }

    @Test
    public void fluentGoogleCheeseSearch() throws Exception{

        gitHubLogin.NavigateTo("https://github.com/login")
                .TypeLogin(login)
                .TypePassword(pass)
                .HitSubmit()
                .VerifyRepositoryTitleContains("Repository");

    }

}
