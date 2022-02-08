package Base;

import Pages.SignIn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

// pravimo Base page koju cemo kasnije ekstendovati u Test klasi
public class BasePage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public SignIn signIn;
    public ExcelReader excelReader;
    public String homeURL;
    public String logOutURL;

    //BeforClass se uvek izvrsava prva
    @BeforeClass
    public void setUp() throws IOException {

        WebDriverManager.chromedriver().setup();  //setujem drajver
        driver = new ChromeDriver();
        //kreiram WebDriverWait i dajem mu komandu na koliko ce maksimalno da ceka ispunjavanje uslova
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        excelReader = new ExcelReader("C:\\Users\\Tamara\\Desktop\\petstore.xlsx");  //odajem putanju eksel fajla
        //citamo URL iz eksel fajla
        homeURL = excelReader.getStringData("URL", 1, 0);
        logOutURL = excelReader.getStringData("URL",1,1);
    }


    public void waiterVisibility(WebElement element){
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waiterClickability(WebElement element){
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //AfterClass se izvrsava posle svakog testa
    //Brisem sve kolacice, iskljucujem tabove i gasim browser
    //zakomentarisano dok testiramo
   @AfterClass
    public void tearDown(){
        //driver.manage().deleteAllCookies();
       // driver.close();
        //driver.quit();
    }

}