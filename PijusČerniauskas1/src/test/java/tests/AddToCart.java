package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddToCart extends BaseTest {
    WebDriverWait wait;
    @Test(dataProvider = "products")
    public void addToCart(String productToAdd){
        String categoryToOpen = "GRIPEX";

        //Į paiešką įvesti „Nereceptiniai vaistai“
        driver.findElement(By.name("Nereceptiniai vaistai")).sendKeys();

        //Patikrinti ar gera kategorija atidaryta
        String categoryOpened = driver.findElement(By.xpath("//button[@data-filter-value=\"GRIPEX\"]")).getText();
        Assert.assertEquals(categoryOpened, categoryToOpen, "Wrong category opened");

        //Patikrinti, jog visi atvaizduojami produktai turi „GRIPEX“ žodį pavadinime (assert)
        driver.findElement(By.id("#cart-block")).click();
        String addedProductName = driver.findElement(By.cssSelector(".cart-rows .cart-item")).getText();
        Assert.assertEquals(addedProductName, productToAdd, "Wrong product has been added to cart");


        //Įdėti gerą produktą į krepšelį
        List<WebElement> products = driver.findElements(By.cssSelector(".product-thumb"));
        for (WebElement product : products) {
            String productName = product.findElement(By.tagName("h4")).getText();
            if (productName.equals(productToAdd)) {
                product.findElement(By.xpath(".//i[contains(@class, 'fa-shopping-cart')]/..")).click();
                break;
            }
        }

        //Paspausti ant krepšelio
        driver.findElement(By.id("#cart-block")).click();

    }
    @DataProvider(name = "products")
    public Object[][] products(){
        return new Object[][]{
                {"Gripex, plėvele dengtos tabletės, N12"},
                {"Gripex, plėvele dengtos tabletės, N24"}
        };
    }
}
