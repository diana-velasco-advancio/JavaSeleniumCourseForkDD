package firstCodeClass;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test1 {
    public static void main(String[] args){
        System.out.println("hello world");
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
        //Assert.assertEquals();



        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();


    }
}
