package POMtest;

import POMbase.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin extends BasePage {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @Test
    public void homeTextTest() {
        String expectedText = "HOME";
        Assert.assertEquals(sidebarpage.getHomeText(), expectedText);
    }

    public void goToLoginPage() {
        sidebarpage.clickPractice();
        practicepage.clickOnTestLoginPage();
    }

    @Test
    public void userCanLogIn() {
        String validUsername = "student";
        String validPassword = "Password123";

        goToLoginPage();
        loginpage.insertUsername(validUsername);
        loginpage.insertPassword(validPassword);
        loginpage.clickOnSubmitButton();

        Assert.assertTrue(logoutpage.getLogOutButton().isDisplayed());
    }

    @Test
    public void userCannotLogInWithInvalidUsernam() {
        String invalidUsername = "wrong";
        String validPassword = "Password123";
        String expectedErrorMessage = "Your username is invalid!";

        goToLoginPage();
        loginpage.insertUsername(invalidUsername);
        loginpage.insertPassword(validPassword);
        loginpage.clickOnSubmitButton();
        //wdwait.until(ExpectedConditions.visibilityOf(loginpage.getErrorMessage()));
        waiter(loginpage.getErrorMessage());
        Assert.assertTrue(loginpage.getErrorMessage().isDisplayed());
        Assert.assertEquals(loginpage.getErrorText(), expectedErrorMessage);
    }

}
