package LMS_Project_Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms");
        Reporter.log("Homepage loaded");


    }

    @Test
    public void testMethod1(){
        Assert.assertEquals(driver.getTitle(), "Alchemy LMS – An LMS Application");

        driver.findElement(By.xpath("//a[text()='My Account']")).click();

        Assert.assertEquals(driver.getTitle(), "My Account – Alchemy LMS");
        Reporter.log("Newpage loaded");

    }

    @Test
    public void testMethod2(){

        driver.findElement(By.xpath("//a[contains(@class, 'ld-login-button')]")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys(" pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//a[contains(@class, 'ab-item')]//span[@class='display-name']")).getText(), "root");
        Reporter.log("Newpage loaded");

    }


    @AfterClass
    public void tearDown(){
        Reporter.log("browser closed");
        driver.quit();
    }
}


