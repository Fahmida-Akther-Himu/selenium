package dev.selenium.three;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class DynamicLocators {
    public static void main(String[] args) throws InterruptedException {
        //Browser Launch
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://10.140.0.166:7090/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Dynamic selectors
        WebElement username = driver.findElement(By.cssSelector("input[name*='username_']"));        //by using cssSelector * contains - name
        username.clear();
        username.sendKeys("ahsan.habib");

        WebElement password = driver.findElement(By.cssSelector("input[id^='passw']"));        //by using cssSelector ^ start with - password
        password.clear();
        password.sendKeys("abc123$");

        driver.findElement(By.cssSelector("button[type$='button']")).click();       //by using cssSelector $ end with - button
        Thread.sleep(3000);

        //Print All Links for a Single page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.print(links.size());
        if (links.size() != 0) {
            for (WebElement webElement : links) {
                String link = webElement.getAttribute("href");
                //String linkValue = link!=null?link:"";
                if (link != null && !link.isEmpty() && !link.equals(" ")) {
                    System.out.println(link);
                }

            }
        }

        driver.quit();
    }
}
