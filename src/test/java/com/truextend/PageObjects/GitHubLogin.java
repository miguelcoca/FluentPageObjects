package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GitHubLogin extends BasePage {

    private Query inputLogin = new Query(By.name("login"),driver);
    private Query inputPassword = new Query(By.name("password"),driver);
    private Query buttonSubmit = new Query(By.name("commit"),driver);

    public GitHubLogin() { }

    public GitHubLogin NavigateTo(String url){
        driver.get(url);
        return this;
    }

    public GitHubLogin TypeLogin(String login) {
        inputLogin.findWebElement().clear();
        inputLogin.findWebElement().sendKeys(login);
        return this;
    }
    public GitHubLogin TypePassword(String password) {
        inputPassword.findWebElement().clear();
        inputPassword.findWebElement().sendKeys(password);
        return this;
    }

    public GitHubHome HitSubmit()
    {
        buttonSubmit.findWebElement().submit();
        return new GitHubHome();
    }

}
