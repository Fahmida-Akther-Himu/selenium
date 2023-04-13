package three;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class InteractingWebElements {
    public static void main(String[] args) throws InterruptedException {
        //Browser Launch
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://10.140.0.166:7090/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Interacting with 5 web elements
        WebElement username = driver.findElement(By.cssSelector("input[id$='username_txt']"));        //by using cssSelector * contains - name
        username.clear();       //clear - only applies to text fields and content editable elements
        username.sendKeys("ahsan.habib");       //send keys - only applies to text fields and content editable elements

        WebElement password = driver.findElement(By.cssSelector("input[type^='password']"));        //by using cssSelector ^ start with - password
        password.clear();
        password.sendKeys("abc123$");

        //driver.findElement(By.cssSelector("button[type$='button']")).click();       //by using cssSelector $ end with - button and click - applies to any element
        driver.findElement(By.cssSelector("form[id='loginForm']")).submit();          //submit use only applies to form elements
        //driver.findElement(By.id("loginForm")).submit();

        //Information about web elements
        //Print boolean value for .isDisplayed(), .isEnabled(), .isSelected()
        System.out.println(username.isDisplayed());     //Print the Element is displayed on a webpage by using .isDisplayed()
        System.out.println(username.isEnabled());       //Print the Element is enabled or disabled on a webpage by using .isEnabled()
        System.out.println(username.isSelected());      //Print the referenced Element is Selected or not by using .isSelected()
        System.out.println(username.getTagName());      //Print the tag name by using .getTagName()
        System.out.println(username.getRect().x + " " + username.getRect().y);          //Print the dimensions and coordinates by using .getRect()
        System.out.println(username.getCssValue("font-size").trim());       //Print the value of specified computed style property by using .getCssValue("color")
        System.out.println(driver.findElement(By.cssSelector(".copyright")).getText().trim());      //Print the Text Content by using .getText()
        System.out.println(driver.findElement(By.cssSelector("img[class$='img-responsive center']")).getAttribute("src"));      //Print the URL by using .getAttribute()

        Thread.sleep(3000);
        driver.quit();
    }
}
