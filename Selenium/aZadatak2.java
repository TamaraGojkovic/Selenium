package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/*
Otici na sajt wikipedia i pronaci clanak o Nikoli Tesli
Desni klik na element -> Inspect (ponoviti ponovo da vam izabere zeljeni element)
-> U inspectu desni klik na 'plavi' deo -> Copy -> Copy Xpath
       */

public class aZadatak2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"searchInput\"]"));
        searchBox.sendKeys("Nikola Tesla");
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"searchButton\"]"));
        searchButton.click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";

        String actualtitle = driver.findElement(By.xpath("//*[@id=\"firstHeading\"]")).getText();
        String expectedTitle = "Nikola Tesla";

        WebElement picture = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[3]/td/a/img"));

        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualtitle, expectedTitle);
        Assert.assertTrue(picture.isDisplayed());  // slika je prikazana

        //driver.close();  zatvara samo trenutni tab
        //driver.quit();   zatvara ceo prozor

    }
}
