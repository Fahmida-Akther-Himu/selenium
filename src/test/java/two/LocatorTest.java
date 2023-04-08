package two;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class LocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //driver.findElement(By.id("userName")).clear();
        driver.findElement(By.id("userName")).sendKeys("Fahmida Akther");
        driver.findElement(By.id("userEmail")).sendKeys("fahmida.himu0904@gmail.com");
        driver.findElement(By.tagName("textarea")).sendKeys("Please enter your current address in this description box.");
        //driver.findElement(By.className("btn btn-primary")).click();                             //not working cz found multiple class

        /* WebElement element= driver.findElement(By.id("userName"));
        element.clear();
        element.sendKeys("Fahmida Akther"); */

        Thread.sleep(3000);
        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");                 //jump to other/new page
        driver.findElement(By.name("username")).sendKeys("Fahmida");                              //name
        driver.findElement(By.name("password")).sendKeys("1234");                                 //name
        driver.findElement(By.className("Solutions")).click();                                    //className
        driver.findElement(By.linkText("Services")).click();                                      //linkText
        driver.findElement(By.partialLinkText("Admin ")).click();                                 //partialLinkText
        driver.findElement(By.cssSelector("a[href='services.htm']")).click();                     //cssSelector
        driver.findElement(By.cssSelector(".leftmenu a[href='http://www.parasoft.com/jsp/products.jsp']")).click();     //cssSelector redirect to other page or by using link
        Thread.sleep(3000);

        driver.quit();
    }
}
