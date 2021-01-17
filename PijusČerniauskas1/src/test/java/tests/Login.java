package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Login extends BaseTest {
    @Test
    public void login() {
        String email = "testas@testas.com";
        String password = "Testauskas10";
        String expectedErrorText = "Norėdami tęsti, privalote sutikti su taisyklėmis ir privatumo politika.";
        CommonPage commonPage = new CommonPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //Paspausti „PRISIJUNGIMAS“, kuris yra viršuje
        commonPage.openLoginPage();

        //Patikrinti, jog matoma prisijungimo forma (assert). Patikrinti, jog matoma registracijos forma (assert)
        boolean joinVisible = loginPage.joinBlockVisible();
        boolean registerVisible = loginPage.registerBlockVisible();
        assertTrue(joinVisible, "New customer block is not visible");
        assertTrue(registerVisible, "Returning customer block is not visible");

        //Įrašyti login ir password ir paspausti login mygtuką
        loginPage.loginWithCredentials(email, password);


        //Patikrinti ar error tekstas yra geras
        String actualErrorText = commonPage.getMessageText();
        assertEquals(actualErrorText, expectedErrorText, "Text was different than expected");

    }

}
