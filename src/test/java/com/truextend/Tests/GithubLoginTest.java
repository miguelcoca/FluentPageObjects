package com.truextend.Tests;

import com.truextend.PageObjects.GithubLoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GithubLoginTest extends TestBase {

    GithubLoginPage logGitpage;

    @BeforeClass
    public void setup(){
        logGitpage = new GithubLoginPage();
    }

    @Test
    public void gitLogin() throws Exception{

        logGitpage.NavigateTo("https://github.com/login")
                .FillName("AnnelP")
                .FillPassword("Control12345!")
                .HitEnter()
                .VerifyResultsPageSubTitleContains("Learn Git and GitHub without any code!");

    }
}
