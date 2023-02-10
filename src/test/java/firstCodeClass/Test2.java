package firstCodeClass;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Optional;

public class Test2 {
    public static void main(String[] args){
        System.out.println("Third Homework: Open a page, add 2 items to the cart, validate them on the Shopping cart");

        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe"  );
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement usernameInput = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));

        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();

        // Adding the products to the cartShop
        WebElement addCartButton1 = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]"));
        WebElement addCartButton2 = driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]"));

        addCartButton1.click();
        addCartButton2.click();

        WebElement shopCartBadge = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
        String productsNumber = "";
        productsNumber = shopCartBadge.getText();

        //System.out.println("number " + productsNumber);

        Assert.assertEquals("2", productsNumber);

        System.out.println("Two products added correctly to the cart");

        //Open the Cart List page and Assert the Page Title on the ShopCar
        WebElement ShopCartbutton = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        ShopCartbutton.click();

        WebElement carPageTitle = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
        String pageTitle = carPageTitle.getText();

        //we can corroborate we are on the Car List page
        Assert.assertEquals("YOUR CART", pageTitle);
        System.out.println("Two products in your Cart List");

        //Corroborate the two items previously selected are on the cart
        WebElement divProductContainer = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]"));
        List<WebElement> divProduct = divProductContainer.findElements(By.xpath("//div[@class=\"inventory_item_name\"]"));

        for(int i = 0; i<divProduct.size(); i++){
            WebElement productItem = divProduct.get(i);
            System.out.println("Product " + i + " " + productItem.getText());
        }


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
