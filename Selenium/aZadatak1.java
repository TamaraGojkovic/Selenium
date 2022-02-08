package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class aZadatak1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();  //program pokrece drajver
        driver.manage().window().maximize();    //maksimizuje
        driver.navigate().to("https://www.google.com/");

        WebElement textbox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[2]/div[2]/input"));
        //pronalazi textbox element (search polje) i unese tekst
        textbox.sendKeys("itbootcamp");
        // textbox.sendKeys(ENTER);  ako hocemo da pretrazujemo sa enter

//Thread.sleep(2000); prekriva searh button jer smo sacekali 2sek pa su izasli suggestions

        // ako hocemo da klikne na google search button (google pretraga dugme)
        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[3]/center/input[1]"));
        // pronalazi search button i radi klik
        searchButton.click();

        //da smo cekali sa thread.sleep onda bismo uzimali xpatx koji se nalazi na dnu suggestions,
        //npr naziva searchButtom nazovemo i odradimo klik na njega (al se to ne radi u praksi)
    }
}
