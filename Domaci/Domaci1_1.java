package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class Domaci1_1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wdwait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();


        driver.navigate().to("https://demoqa.com/profile");

        Cookie kolacic1 = new Cookie("userID", "9ebf2f55-7178-4f8e-82cc-8be4524ca341");
        driver.manage().addCookie(kolacic1);

        Cookie kolacic2 = new Cookie("token", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6Ik5hdGEiLCJwYXNzd29yZCI6IlF3ZXJ0eTEyMyMiLCJpYXQiOjE2NDIzNDk4MjR9.xfpq_6w45GCNninwYyNxofwyJzU4AvapM3yIkOluNBg");
        driver.manage().addCookie(kolacic2);

        Cookie kolacic3 = new Cookie("userName", "Sifra1");
        driver.manage().addCookie(kolacic3);

        Cookie kolacic4 = new Cookie("expires", "2022-01-23T16%3A17%3A04.380Z");
        driver.manage().addCookie((kolacic4));


        // nisam nasla ID pa sam koristila linkText
        WebElement loginLink = driver.findElement(By.linkText("login"));
        loginLink.click();
        // wdwait.until(ExpectedConditions.elementToBeClickable(By.linkText("login")));

        Thread.sleep(2000);

        WebElement logoutButton = driver.findElement(By.id("submit"));
        logoutButton.click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://demoqa.com/login";

        WebElement loginButton = driver.findElement(By.id("login"));

        Assert.assertEquals(actualURL, expectedURL); // proveravam da li se poklapaju addrese
        //Assert.assertNotEquals(actualURL, expectedURL);

        Assert.assertTrue(loginButton.isDisplayed()); // proveravam da li postoji login button
        // jer kad smo ulogovani ono ne moze da postoji
        //Assert.assertFalse(loginButton.isDisplayed());

        //driver.close(); dok testiramo zakomentarisano je
        //driver.quit(); dok testiramo zakomentarisano je

    }
}
