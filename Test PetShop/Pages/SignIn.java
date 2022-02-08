package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {

    public WebDriver driver;
    WebElement register;
    WebElement userID;
    WebElement newPassword;
    WebElement repeatPassword;
    WebElement firstName;
    WebElement lastName;
    WebElement email;
    WebElement phone;
    WebElement address1;
    WebElement city;
    WebElement state;
    WebElement zip;
    WebElement country;
    WebElement saveButton;
    WebElement sign;
    WebElement login;

    public SignIn(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getRegister() {
        return driver.findElement(By.xpath("//*[@id=\"Catalog\"]/a"));
    }

    public WebElement getUserID() {
        return driver.findElement(By.id("stripes-1087807198"));
    }

    public WebElement getNewPassword() {
        return driver.findElement(By.className("password"));
    }

    public WebElement getRepeatPassword() {
        return driver.findElement(By.className("repeatedPassword"));
    }

    public WebElement getFirstName() {
        return driver.findElement(By.className("account.firstName"));
    }

    public WebElement getLastName() {
        return driver.findElement(By.className("account.lastName"));
    }

    public WebElement getEmail() {
        return driver.findElement(By.className("account.email"));
    }

    public WebElement getPhone() {
        return driver.findElement(By.className("account.phone"));
    }

    public WebElement getAddress1() {
        return driver.findElement(By.className("account.address1"));
    }

    public WebElement getCity() {
        return driver.findElement(By.className("account.city"));
    }

    public WebElement getState() {
        return driver.findElement(By.className("account.state"));
    }

    public WebElement getZip() {
        return driver.findElement(By.className("account.zip"));
    }

    public WebElement getCountry() {
        return driver.findElement(By.className("account.country"));
    }

    public WebElement getSaveButton() {
        return driver.findElement(By.className("newAccount"));
    }

    public WebElement getSign () { return driver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[2]")); }

    public WebElement getLogin() {
        return driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/input"));
    }

    //------------------------------------------------------------------------------

    public void clickregister(){
        this.register.click();
    }

    //metoda za unos juzera
    public void inputuserID(String id){
        this.userID.clear();
        this.userID.sendKeys(id);
    }

    //metoda za unos sifre
    public void inputnewPassword(String pass){
        this.newPassword.clear();
        this.newPassword.sendKeys(pass);
    }

    //ponavljamo unos sifre
    public void inputrepeatPassword(String pass){
        this.repeatPassword.clear();
        this.repeatPassword.sendKeys(pass);
    }

    //metoda za unos imena
    public void inputFirstNAme(String name){
        this.firstName.clear();
        this.firstName.sendKeys(name);
    }

    public void inputlastName (String lname) {
        this.lastName.clear();
        this.lastName.sendKeys(lname);
    }

    public void inputemail (String mail) {
        this.email.clear();
        this.email.sendKeys(mail);
    }

    public void inputphone (String phone){
        this.phone.clear();
        this.phone.sendKeys(phone);
    }

    public void inputaddress1 (String adr) {
        this.address1.clear();
        this.address1.sendKeys(adr);
    }

    public void inputcity (String grad) {
        this.city.clear();
        this.city.sendKeys(grad);
    }

    public void inputstate (String state) {
        this.state.clear();
        this.state.sendKeys(state);
    }

    public void inputzip (String zip) {
        this.zip.clear();
        this.zip.sendKeys(zip);
    }

    public void inputcountry (String zemlja) {
        this.country.clear();
        this.country.sendKeys(zemlja);
    }

    public void clicksaveButton (){
        this.saveButton.click();
    }

    public void clicksign () { this.sign.click();}

    public void clicklogin () { this.login.click(); }
}
