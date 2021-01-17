package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage {
    WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }

    //----------Locators---------------------
    By loginLink = By.xpath("//div[contains(@class, 'loggin-hdr fal fa-user first last')]");
    By messageBlock = By.cssSelector("Norėdami tęsti, privalote sutikti su taisyklėmis ir privatumo politika.");


    //----------Methods----------------------
    public void openLoginPage() {
        driver.findElement(loginLink).click();
    }

    public String getMessageText() {
        return driver.findElement(messageBlock).getText();
    }

}
