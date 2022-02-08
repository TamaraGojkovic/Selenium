package Anotacije;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class zad4 {

    WebDriver driver;
    WebDriverWait wdwait;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");

    }

    public void goToLogin() {
        WebElement practice = driver.findElement(By.id("menu-item-20"));
        practice.click();
        WebElement testLoginPage = driver.findElement(By.linkText("Test Login Page"));
        testLoginPage.click();
    }

    @Test
    public void userCanLogIn() {
        goToLogin();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submit = driver.findElement(By.id("submit"));

        String validUsername = "student";
        String validPassword = "Password123";

        username.clear();
        username.sendKeys(validUsername);
        password.clear();
        password.sendKeys(validPassword);
        submit.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());

    }

    @Test
    public void userCannotLogInWithInvalidUsername() throws InterruptedException {
        goToLogin();

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submit = driver.findElement(By.id("submit"));

        String invalidUsername = "wrong";
        String validPassword = "Password123";

        username.clear();
        username.sendKeys(invalidUsername);
        password.clear();
        password.sendKeys(validPassword);
        submit.click();
        Thread.sleep(2000);
        String loggedInURL = "https://practicetestautomation.com/logged-in-successfully/";
        String actualURL = driver.getCurrentUrl();

        Assert.assertNotEquals(actualURL, loggedInURL);

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";

        Assert.assertEquals(actualURL, expectedURL);

        WebElement errorMessage = driver.findElement(By.id("error"));

        Assert.assertTrue(errorMessage.isDisplayed());

        String validErrorMessage = "Your username is invalid!";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertEquals(actualErrorMessage, validErrorMessage);


        //----------------------------

        /*
        boolean logOut = false;
        try {
            WebElement logOutButton = driver.findElement(By.linkText("Log out"));
            logOut = logOutButton.isDisplayed();
        } catch (NoSuchElementException ey) {

        }

        Assert.assertFalse(logOut);
         */

    }
}
