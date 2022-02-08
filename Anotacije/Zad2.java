package Anotacije;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zad2 {

    WebDriver driver;

    @BeforeClass
    public void BeforeClass (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void BeforeMethod () {
        driver.manage().window().maximize();
        driver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
    }

    @Test
    public void Test (){
        WebElement searchBox = driver.findElement(By.className("vector-search-box-input"));
        searchBox.sendKeys("Nikola Tesla");

        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";
        Assert.assertEquals(actualURL, expectedURL);
    }


    @AfterClass
    public void Kraj() {
        driver.close();
    }
}
