package firstCodeClass;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class test1 {
    public static void main(String[] args){
        System.out.println("Second Homework: Open a page, and compare the name of the first Item");
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

        //Use the code below, to match the expected text of the first item in the shop
        // Second Homework------------------------------------------------------------------------------------
        String strProductNameExpected = "Sauce Labs Backpack";
        String strProductNameSelected = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
        Assert.assertEquals(strProductNameExpected,strProductNameSelected);
        System.out.println("Assert passed");

        //Assert.assertEquals("Sauce Labs Backpack", driver.findElement(by.xpath("//*[@id=\"item_4_title_link\"]/div")).getText());
        //------------------------------------------------------------------------------------


        //------------------------------------------------------------------------------------
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();


    }
}
