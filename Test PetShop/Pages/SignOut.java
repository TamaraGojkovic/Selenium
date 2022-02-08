package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignOut {

    public WebDriver driver;
    public WebElement signOut;
    public WebElement myAccount;

    public SignOut(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSignOut() {
        return driver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[2]"));
    }

    public WebElement getMyAccount() {
        return driver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[3]"));
    }

//----------------------------------------------------------------------------------

    public void clicksignOut (){
        this.signOut.click();
    }

    public void clickmyAccount (){
        this.myAccount.click();
    }
}
