package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //-----------------Locators-------------
    By loginForm = By.cssSelector();
    By continueButton = By.cssSelector();
    By loginButton = By.xpath("//button[@data-click-disable]");
    By passwordInputField = By.name("customer_registration[user][plainPassword][second]");
    By passwordInputField2 = By.name("customer_registration[user][plainPassword][second]");
    By emailInputField = By.id("customer_registration_email");
    By checkBox = By.name("customer_registration[marketing][generalOffers]");
    By checkBox2 = By.name("customer_registration[marketing][personalOffers]");

    public boolean joinBlockVisible() {
        return driver.findElement(continueButton).isDisplayed();
    }

    public boolean registerBlockVisible() {
        return driver.findElement(loginForm).isDisplayed();
    }
    public void loginWithCredentials(String email, String password) {
        driver.findElement(emailInputField).sendKeys(email);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(passwordInputField2).sendKeys(password);
        driver.findElement(checkBox).click();
        driver.findElement(checkBox2).click();
        driver.findElement(loginButton).click();

    }

}
