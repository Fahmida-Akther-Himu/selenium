package dev.testng.assignmentOne.methodTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErpTest extends BaseErpTest {
    @Test
    public void verifyLoginPageShouldSucceed() {
        String loginText = driver.findElement(By.cssSelector("#loginForm h3")).getText().trim();
        Assert.assertEquals(loginText, "Sign-in");      //Print the login text.

    }
//aa
    @Test
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

    @Test
    public void verifyTitleShouldSucceed() {
        //Assertion
        System.out.println(driver.getTitle());          //Print the title of the web site.
        Assert.assertEquals(driver.getTitle().trim(), "..::LOGIN::..");      //Assert the current URL title
        System.out.println(driver.getCurrentUrl());     //Print the current URL link
        //System.out.println(driver.getPageSource());


    }
}
