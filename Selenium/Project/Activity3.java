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

public class Activity3 {
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
        Assert.assertEquals(driver.findElement(By.xpath("//h3[text()=' Actionable Training ']")).getText(), "Actionable Training");

    }


    @AfterClass
    public void tearDown(){
        Reporter.log("browser closed");
        driver.quit();
    }
}


