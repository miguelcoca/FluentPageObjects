package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;

public class GitHubLogin extends BasePage {
    private Query userName = new Query(By.id("login_field"), driver);
    private Query password = new Query(By.id("password"), driver);
    private Query signInButton = new Query(By.name("commit"), driver);

    public GitHubLogin(){}

    public GitHubLogin NavigateTo(String url){
        driver.get(url);
        return this;
    }

    public GitHubLogin setUsername(String username){
        userName.findWebElement().clear();
        userName.findWebElement().sendKeys(username);
        return this;
    }

    public GitHubLogin setPassword(String password){
        this.password.findWebElement().clear();
        this.password.findWebElement().sendKeys(password);
        return this;
    }

    public GitHubMainHome signIn(){
        signInButton.findWebElement().submit();
        return new GitHubMainHome();
    }

}
