package com.truextend.PageObjects;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;

public class GitHubLogin extends BasePage {

    private Query username = new Query(By.name("login"), driver);
    private Query password = new Query(By.name("password"), driver);
    private Query signIn = new Query(By.name("commit"), driver);

    public GitHubLogin (){}

    public GitHubLogin SelectUsernameBox(){
        username.findWebElement().click();
        return this;
    }

    public GitHubLogin SelectPasswordBox(){
        password.findWebElement().click();
        return this;
    }

    public GitHubLogin TypeInUsername(String data) {
        username.findWebElement().clear();
        username.findWebElement().sendKeys(data);
        return this;
    }

    public GitHubLogin TypeInPassword(String data) {
        password.findWebElement().clear();
        password.findWebElement().sendKeys(data);
        return this;
    }

    public GitHubLogin NavigateTo(String url){
        driver.get(url);
        return this;
    }

    public GitHubHomePage HitEnter() {
        signIn.findWebElement().submit();
        return new GitHubHomePage();
    }

}
