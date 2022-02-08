package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.openqa.selenium.Keys.ENTER;

public class aTeorija {
    public static void main(String[] args) {

        //System.setProperty("webdriver.chrome.driver", "C:/chromdriver.exe");

        //pokrecemo drajver
        WebDriverManager.chromedriver().setup();
        //taj drajver kreira novi objekat hromdrajver
        WebDriver driver = new ChromeDriver();
        //povecavamo prozor pretrazivaca, svi linkovi ce biti otvoreni u povecanom prozoru
        driver.manage().window().maximize();

        // driver.get("https://www.google.com/"); jedan od nacina al je bolji sa navigate

        driver.navigate().to("https://www.google.com/");   //ide na gugl
        driver.navigate().to("https://www.youtube.com/"); //ide na yt
        driver.navigate().refresh();                         //radimo refresh
        driver.navigate().back();                           //vraca nazad na prethodnu stranicu
        driver.navigate().forward();                       //ide na sledecu stranicu
        driver.navigate().refresh();                      //refresuje stranicu


        //Zadatak 1 - Otici na Google, povecati prozor, odraditi refresh, otici na youtube, vratiti se nazad
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().back();


        // xpath
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[2]/div[2]/input"))
                .sendKeys("itbootcamp");

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[2]/div[2]/input"))
                .sendKeys(ENTER);  //instrukcija sa tastature

        //2. nacin, pravimo promenljivu
        WebElement textbox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div[2]/div[2]/input"));

        textbox.sendKeys("itbootcamp");
        textbox.sendKeys(ENTER);


        /*
         lokatori, od najboljeg ka najgorem:
         id
         name
         class
         css
         relative xpath
         absolute xpath

        relative xpath // ove kose crte u xpath - nadji mi element koji se zavrsava sa ovim delom
        driver.findElement(By.xpath("//*[@id=\"searchButton\"]"));

        absolute xpath  (copy full xpath)
        driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[2]/div/div/form/div/input[3]"));
         */


        // Assert je svrha testiranja, radimo uporedjivanje, utvrdjujemo da smo na pravoj stranici, nasli smo
        // pravi element
        // Assert.assertEquals(actualURL, expectedURL);
        // Assert.assertEquals(actualtitle, expectedTitle);
        // Assert.assertTrue(picture.isDisplayed());

        //driver.close();  zatvara samo trenutni tab
        //driver.quit();   zatvara ceo prozor
    }
}
