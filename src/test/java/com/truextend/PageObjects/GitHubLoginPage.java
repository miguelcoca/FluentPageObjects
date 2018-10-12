package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GitHubLoginPage extends BasePage {

    private Query login = new Query(By.name("login"), driver);
    private Query password = new Query(By.name("password"), driver);
    private Query loginButton = new Query(By.name("commit"), driver);

    public GitHubLoginPage() { }

    public GitHubLoginPage EnterUserName(String userName){
        login.findWebElement().clear();
        login.findWebElement().sendKeys(userName);
        return this;
    }

    public GitHubLoginPage EnterPassword(String pwd){
        password.findWebElement().clear();
        password.findWebElement().sendKeys(pwd);
        return this;
    }

    public GitHubLoginPage HitSignIn() {
        login.findWebElement().click();
        return new GitHubHomePage();
    }

    public GitHubLoginPage NavigateTo(String url){
        driver.get(url);
        return this;
    }

    public GitHubLoginPage VerifyResultsPageH2Contains(String expected){
        Assert.assertTrue(driver.getTitle().contains(expected));
        return this;
    }



}