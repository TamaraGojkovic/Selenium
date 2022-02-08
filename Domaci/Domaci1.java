package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Domaci1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/login");
        Thread.sleep(2000);

        // kriram kolacic
        Cookie kolacicUser = new Cookie("userName","Sifra2domaci!");
        driver.manage().addCookie(kolacicUser);
        driver.navigate().refresh();

        Cookie kolacicId = new Cookie("userID","d582cba1-93b2-4cf5-9758-17d2b0ae81e1");
        driver.manage().addCookie(kolacicId);
        driver.navigate().refresh();

        Cookie kolacicToken = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkNoYXJseTIyIiwicGFzc3dvcmQiOiJDaGFybHkhMjIwMiIsImlhdCI6MTY0MjM0NTI4Nn0.0hHM4uYIdYA6hdc6Nt-w0Wv4JBaXy1WcE3-DhQ17Dfg");
        driver.manage().addCookie(kolacicToken);
        driver.navigate().refresh();

        Cookie kolacicExp = new Cookie("expires","2022-01-23T14%3A56%3A08.750Z");
        driver.manage().addCookie(kolacicExp);
        driver.navigate().refresh();
    }
}
