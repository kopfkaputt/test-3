import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class testik {


    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://kursk.hh.ru/");
        driver.manage().window().maximize();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@data-qa='supernova-navi-dashboard']//a[@data-qa='login']")).isDisplayed());

        driver.findElement(By.xpath("//div[@data-qa='supernova-navi-dashboard']//a[@data-qa='login']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@data-qa='account-signup-email']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='account-login-actions']//button[@data-qa='account-signup-submit']")).isDisplayed());


        driver.findElement(By.xpath("//input[@data-qa='account-signup-email']")).sendKeys("qwe");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@data-qa='account-signup-email']")).getAttribute("value"),"qwe");


        driver.findElement(By.xpath("//div[@class='account-login-actions']//button[@data-qa='account-signup-submit']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@data-qa='field-error-login field-error-login_BAD_LOGIN']")).getText(),"Пожалуйста, укажите email или телефон");

    }
}