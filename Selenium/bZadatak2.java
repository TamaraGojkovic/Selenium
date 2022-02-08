package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class bZadatak2 {
    public static void main(String[] args) {

        // Napraviti program koji ce se ulogovati na wordpress i proveriti da li se korisnik ulogovao
        // https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//WebDriverWait kreiram na ovaj nacin i dajem mu komandu na kraju koliko ce maksimalno da ceka ispunjavanje uslova
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");

//Proveravam da li postoji neki jedinstven element, nalazim id i proverio sam da je jedinstven
// (napomena: treba da bude jedinstven KAO ID, ako postoji recimo name ili class sa tim nazivom onda nije problem,
// bitno je da ne postoji drugi ID sa tim nazivom)
        WebElement username = driver.findElement(By.id("usernameOrEmail"));
        username.sendKeys("dragoljubqa");

//Proveravam sta je jedinstveno, nalazim class da je jedinstven za ovaj element
        WebElement continueButton = driver.findElement(By.className("login__form-action"));
        continueButton.click();

//Program ce pasti kod ovog dela ako se ne ubaci cekanje jer program ide u potragu
// elementa iako nije sacekao. Tokom kreiranja testa prvo ubacujemo Thread.sleep(neko vreme)
// pa na kraju menjamo taj thread sleep sa webdriver wait-erom
// webdriver wait ce sacekati dok se ne ispune uslovi (URL bude neki odredjen, element postane
// vidljiv, element postane klikabilan itd)
        WebElement password = driver.findElement(By.id("password"));
        wdwait.until(ExpectedConditions.elementToBeClickable(By.id("password"))); //umesto thread.sleep
        password.sendKeys("Qwerty123");

//Zakomentarisao sam ovaj webelement jer je ista putanja kao za prethodno dugme pa ne moram da koristim novi webelement
//WebElement logInButton = driver.findElement(By.className("login__form-action"));
        continueButton.click();

//Ovde cekam da se URL ucita kako bih mogao da ga kasnije assertujem
        wdwait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/dragoljubqa.wordpress.com"));

//Kreiram dva stringa, koji ocekujem i koji dobijam
        String expectedURL = "https://wordpress.com/home/dragoljubqa.wordpress.com";
        String actualURL = driver.getCurrentUrl();

//Vrsim proveru
        Assert.assertEquals(actualURL, expectedURL);

//Trazim sta postoji na stranici kad smo ulogovani, a da nema na pocetnoj - profile dugme i logout dugme
//Pronalazim element koji ima jedinstven lokator za profile ikonicu
        WebElement profileButton = driver.findElement(By.className("gravatar"));
//Proveravam prvo da li je dugme prisutno
        Assert.assertTrue(profileButton.isDisplayed());
        profileButton.click();

//Cekam da logout dugme bude klikabilno pre nego sto assertujem da li je prisutno
        wdwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button.sidebar__me-signout-button.is-compact")));
        //webelement je glasio drugacije,ali posto ne mogu da postoje razmaci za class stavili smo tacku umesto
        //svakog razmaka i na pocetak, i prebacili u cssSelector
        //WebElement logOutButton = driver.findElement(By.className("button sidebar__me-signout-button is-compact"));
        WebElement logOutButton = driver.findElement(By.cssSelector(".button.sidebar__me-signout-button.is-compact"));

        Assert.assertTrue(logOutButton.isDisplayed());

//Napomena za kraj
//Tokom pravljenja testa koristite thread sleep gde mislite da je potrebno
//Kasnije pokrenite program bez thread sleepa i vidite gde je zapravo potrebno cekanje
//Na mestu gde je potrebno zamenite thread sleep sa webdriver wait-om


    }
}
