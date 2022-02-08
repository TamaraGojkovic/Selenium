package POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practicepage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement testLoginPage;

    public Practicepage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getTestLoginPage() {
        return driver.findElement(By.linkText("Test Login Page"));
    }

    //--------------------------

    public void clickOnTestLoginPage() {
        this.getTestLoginPage().click();
    }

}
