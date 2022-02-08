package POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logoutpage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement logOutButton;

    public Logoutpage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getLogOutButton() {
        return driver.findElement(By.linkText("Log out"));
    }
}

