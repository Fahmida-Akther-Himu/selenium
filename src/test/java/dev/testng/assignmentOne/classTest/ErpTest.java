package dev.testng.assignmentOne.classTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErpTest extends BaseErpTest {

    @Test(priority = 0)
    public void verifyLoginPageShouldSucceed() {
        String loginText = driver.findElement(By.cssSelector("#loginForm h3")).getText().trim();
        Assert.assertEquals(loginText, "Sign-in");      //Print the login text.

    }

    @Test(priority = 1)
    public void verifyLoginShouldSucceed() throws InterruptedException {
        WebElement usernameEl = driver.findElement(By.name("j_username_txt"));
        usernameEl.clear();
        usernameEl.sendKeys("00000761");

        WebElement passwordEl = driver.findElement(By.name("j_password"));
        passwordEl.clear();
        passwordEl.sendKeys("abc123$");

        driver.findElement(By.cssSelector("#loginForm button")).click();
        Thread.sleep(1000);

    }

    @Test(priority = 2)
    public void verifyTitleShouldSucceed() {
        //Assertion
        System.out.println(driver.getTitle());          //Print the title of the web site.
        Assert.assertEquals(driver.getTitle().trim(), "My Dashboard");      //Assert the current URL title
        System.out.println(driver.getCurrentUrl());     //Print the current URL link
        //System.out.println(driver.getPageSource());


    }

}
