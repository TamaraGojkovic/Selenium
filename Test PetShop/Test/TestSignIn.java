package Test;

import Base.BasePage;
import Pages.SignOut;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSignIn extends BasePage {

    @BeforeMethod
    public void setUpPage() {
        driver.manage().window().maximize();
        driver.navigate().to(homeURL);
    }

    @Test(priority = 10)
    public void verifyThatUserCanLogIn() throws InterruptedException {

        signIn.clickregister();

        for (int i = 1; i <= excelReader.getLastRow(); i++) {

            driver.navigate().to(homeURL);
            String validID = excelReader.getStringData("SignIn", 1, 0);
            String validPassword = excelReader.getStringData("SignIn", 1, 1);
            String validName = excelReader.getStringData("SignIn", 1, 3);
            String validLastname = excelReader.getStringData("SignIn", 1, 4);
            String validEmail = excelReader.getStringData("SignIn", 1, 5);
            String validPhone = excelReader.getStringData("SignIn", 1, 6);
            String validAdd = excelReader.getStringData("SignIn", 1, 7);
            String validCity = excelReader.getStringData("SignIn", 1, 8);
            String validState = excelReader.getStringData("SignIn", 1, 9);
            String validZip = excelReader.getStringData("SignIn", 1, 10);
            String validCountry = excelReader.getStringData("SignIn", 1, 11);

            waiterVisibility(signIn.getSaveButton());
            signIn.inputuserID(validID);
            signIn.inputnewPassword(validPassword);
            signIn.inputrepeatPassword(validPassword);
            signIn.inputFirstNAme(validName);
            signIn.inputlastName(validLastname);
            signIn.inputemail(validEmail);
            signIn.inputphone(validPhone);
            signIn.inputaddress1(validAdd);
            signIn.inputcity(validCity);
            signIn.inputstate(validState);
            signIn.inputzip(validZip);
            signIn.inputstate(validState);
            signIn.clicksaveButton();

            //asertujemo da l nam se poklapa url koji smo poslali kao ocekivan, i onaj koji je driver dobio kao trenutni
            String actualURL = driver.getCurrentUrl();
            String expectedURL = logOutURL;
            Assert.assertEquals(actualURL, expectedURL);

            //Trazim sta postoji na stranici kad smo ulogovani, a da nema na pocetnoj
            //nalazim da su to sign out i my account dugme
            //proveravam da li je dugme prisutno
            WebElement signOut = driver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[2]"));
            Assert.assertTrue(signOut.isDisplayed());
            signOut.click();

            WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[3]"));
            Assert.assertTrue(myAccount.isDisplayed());
            myAccount.click();

        }
    }


    @Test(priority = 20)

    public void verifyThatUserCannotLogInWithInvalidUsername() {

        signIn.clicksign();

        for (int i = 1; i <= excelReader.getLastRow(); i++) {

            driver.navigate().to(homeURL);
            String invalidID = excelReader.getStringData("SignIn", 1, 9);
            String validPassword = excelReader.getStringData("SignIn", 1, 1);

            signIn.inputuserID(invalidID);
            signIn.inputnewPassword(validPassword);
            signIn.clicklogin();
        }
    }
}