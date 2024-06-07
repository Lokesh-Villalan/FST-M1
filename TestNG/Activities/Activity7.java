package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/login-form/");

    }

    @DataProvider(name = "creds")
    public Object[][] Credentials(){
        return new Object[][]{
                {"admin", "password", "Welcome Back, admin"},
                {"admin12", "password", "Invalid Credentials"},
                {"1233", "S232@", "Invalid Credentials"}

        };

    }

    @Test(dataProvider = "creds")
    public void loginTest(String username, String password, String message) throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginField = driver.findElement(By.xpath("//button[text() ='Log in']"));

        usernameField.clear();
        passwordField.clear();


        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginField.click();

        //String loginMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));

        //loginMessage.getText();
        //Assert.assertEquals(loginMessage, message);
    }


    @AfterClass
    public void tearDown(){
        Reporter.log("browser closed");
        driver.quit();
    }
}
