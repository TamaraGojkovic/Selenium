package POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    WebElement username;
    WebElement password;
    WebElement submitButton;
    WebElement errorMessage;

    public Loginpage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getUsername() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.id("submit"));
    }

    public WebElement getErrorMessage() {
        return driver.findElement(By.id("error"));
    }

    //----------------------------------------------

    public void insertUsername(String username) {
        this.getUsername().clear();
        this.getUsername().sendKeys(username);
    }

    public void insertPassword(String pass) {
        this.getPassword().clear();
        this.getPassword().sendKeys(pass);
    }

    public void clickOnSubmitButton() {
        this.getSubmitButton().click();
    }

    public String getErrorText() {
        return this.getErrorMessage().getText();
    }

}
