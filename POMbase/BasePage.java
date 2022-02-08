package POMbase;

import POMpages.Loginpage;
import POMpages.Logoutpage;
import POMpages.Practicepage;
import POMpages.Sidebarpage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public Sidebarpage sidebarpage;
    public Practicepage practicepage;
    public Loginpage loginpage;
    public Logoutpage logoutpage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        sidebarpage = new Sidebarpage(driver, wdwait);
        practicepage = new Practicepage(driver, wdwait);
        loginpage = new Loginpage(driver, wdwait);
        logoutpage = new Logoutpage(driver, wdwait);


    }

    public void waiter(WebElement element) {
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }

    @AfterClass
    public void tearDown() {
        //driver.manage().deleteAllCookies();
        //driver.close();
        //driver.quit();
    }

}