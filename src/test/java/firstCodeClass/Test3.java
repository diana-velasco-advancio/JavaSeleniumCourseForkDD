package firstCodeClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Test3 {

    public static void main(String[] args){
        System.out.println("Third Homework part 2: Open a page, add 6 items to the cart, and print the name of the products");

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

        WebElement divProductContainer = driver.findElement(By.xpath("//*[@class=\"inventory_list\"]"));
        List<WebElement> divProductName = divProductContainer.findElements(By.xpath("//*[@class=\"inventory_item_name\"]"));
        List<WebElement> divProductButton = divProductContainer.findElements(By.xpath("//*[@class=\"btn btn_primary btn_small btn_inventory\"]"));

        if(null != divProductName && divProductName.size() > 0){
            for(int i = 0; i<divProductName.size(); i++){
                WebElement productItem = divProductButton.get(i);

                productItem.click();
            }
        }

        //Open the Cart List page and Assert the Page Title on the ShopCar
        WebElement ShopCartbutton = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        ShopCartbutton.click();

        //Print the products on the cart
        WebElement divContainer = driver.findElement(By.xpath("//*[@class=\"cart_list\"]"));
        List<WebElement> divProduct = divContainer.findElements(By.xpath("//div[@class=\"inventory_item_name\"]"));

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
