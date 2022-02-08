package Selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class bTeorija {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");

        //otvaranje novog taba
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        //imamo ukupno 4 taba - google i 3 sad otvorena

        ArrayList<String> listaTabova = new ArrayList<String>(driver.getWindowHandles());  //handle je uvek jedinstven
        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to("https://www.youtube.com/");

        //tabovi se redjaju: 0 3 2 1
        // gugl - prazan - facebook - youtube

        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.facebook.com/");

        driver.switchTo().window(listaTabova.get(3));
        Thread.sleep(2000);
        driver.close();
        driver.switchTo().window(listaTabova.get(2));
        driver.close();
        //za zatvaranje tabova

        //ispravno
        //WebElement logOutButton = driver.findElement(By.cssSelector(".button.sidebar__me-signout-button.is-compact"));
        // neispravno
        //WebElement logOutButton = driver.findElement(By.className("button sidebar__me-signout-button is-compact"));


        //Desni klik -> Inspect -> Klik na strelice -> Application -> Cookies -> odaberete koji cookie vam treba
        // i bice prikazani svi na toj stranici

        Cookie kolacic = new Cookie("naziv kolacica", "vrednost kolacica");
        driver.manage().addCookie(kolacic);
        driver.navigate().refresh();  //mora da bi se ucitao kolacic

    }
}
