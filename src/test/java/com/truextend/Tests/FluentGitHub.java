package com.truextend.Tests;

import com.truextend.PageObjects.GitHubLogin;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FluentGitHub extends TestBase {
    GitHubLogin gitHubLogin;

    @BeforeClass
    public void setup(){
        gitHubLogin = new GitHubLogin();
    }

    @Test
    public void fluentGitHubHomePageVisible(){
        gitHubLogin.NavigateTo("https://github.com/login").
        setUsername("marcelogaray").
        setPassword("XXXXXXXXX").
        signIn().
        isRepositoryHeaderDisplayed();
    }
}
