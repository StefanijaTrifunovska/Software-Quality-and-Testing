package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lab3.LoginPage;
import lab3.ProductPage;

public class Tests {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }

    @Test
    public void InvalidLogIn(){
        driver.get("https://cas.finki.ukim.mk/cas/login?service=https%3A%2F%2Fcourses.finki.ukim.mk%2Flogin%2Findex.php");

        final WebElement username = driver.findElement(By.id("username"));
        final WebElement password = driver.findElement(By.id("password"));
        final WebElement login = driver.findElement(By.ByClassName.className("btn-submit"));

        username.sendKeys("testUsername");
        password.sendKeys("invalidPassword");

        login.click();
    }
    @Test
    public void EmptyUserNameLogIn(){
        driver.get("https://cas.finki.ukim.mk/cas/login?service=https%3A%2F%2Fcourses.finki.ukim.mk%2Flogin%2Findex.php");

        final WebElement username = driver.findElement(By.id("username"));
        final WebElement password = driver.findElement(By.id("password"));
        final WebElement login = driver.findElement(By.ByClassName.className("btn-submit"));


        username.sendKeys("");
        password.sendKeys("12345678");

        login.click();
    }
    @Test
    public void SuccessfulLogIn(){
        driver.get("https://cas.finki.ukim.mk/cas/login?service=https%3A%2F%2Fcourses.finki.ukim.mk%2Flogin%2Findex.php");

        final WebElement username = driver.findElement(By.id("username"));
        final WebElement password = driver.findElement(By.id("password"));
        final WebElement login = driver.findElement(By.ByClassName.className("btn-submit"));


        username.sendKeys("181562");
        //It works
        password.sendKeys("S");

        login.click();
    }

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/Stefanija/Documents/lab3 sqat/lab3/src/main/resources/drivers/chromedriver");
        return new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
