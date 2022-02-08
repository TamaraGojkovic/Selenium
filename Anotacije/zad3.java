package Anotacije;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//vise login - happy flow, prazan user, prazan pass, pogresan user, pogresan pass...

public class zad3 {

    WebDriver driver;

    @BeforeClass
    public void BeforeClass (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void BeforeMethod () {
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void HappyFlow (){
        WebElement User = driver.findElement(By.id("username"));
        User.sendKeys("student");

        WebElement Pass = driver.findElement(By.id("password"));
        Pass.sendKeys("Password123");

        WebElement Submit = driver.findElement(By.id("submit"));
        Submit.click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(actualURL, expectedURL);


    }


}
