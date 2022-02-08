package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class vezba {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");

        WebElement mejl = driver.findElement(By.id("usernameOrEmail"));
        mejl.sendKeys("kojimejl@yahoo.com");
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div/div/form/div[1]/div[2]/button"));
        button.click();
        WebElement sifra = driver.findElement(By.id("password"));
        Thread.sleep(2000);
        sifra.sendKeys("Qwerty123");
        Thread.sleep(2000);
        WebElement login = driver.findElement(By.xpath("//*[@id=\"primary\"]/div/main/div/div/form/div[1]/div[2]/button"));
        login.click();
        Thread.sleep(2000);
        driver.quit();

        String expectedURL = "https://wordpress.com/read";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);


    }
}
