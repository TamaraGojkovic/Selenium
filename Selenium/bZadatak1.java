package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class bZadatak1 {
    public static void main(String[] args) throws InterruptedException {

        // Otvoriti 3 taba, svaki tab treba da odlazi na poseban URL (po vasoj zelji koji), sacekati 2 sekunde u svakom
        // tabu i zatvoriti sve tabove

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> listaTabova = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(listaTabova.get(1));
        driver.navigate().to("https://www.facebook.com");
        Thread.sleep(2000);

        driver.switchTo().window(listaTabova.get(2));
        driver.navigate().to("https://www.youtube.com");
        Thread.sleep(2000);

        driver.switchTo().window(listaTabova.get(3));
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);

        /*
        driver.close();
        driver.switchTo().window(listaTabova.get(2));
        driver.close();
        driver.switchTo().window(listaTabova.get(1));
        driver.close();
        driver.switchTo().window(listaTabova.get(0));
        driver.close();
        */

        //da zatvori sve otvorene tabove
        for (int i = 1 ; i < listaTabova.size() ; i++) {
            driver.switchTo().window(listaTabova.get(i));
            driver.close();
        }

    }
}
