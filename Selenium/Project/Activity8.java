package LMS_Project_Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://alchemy.hguy.co/lms");
        Reporter.log("Homepage loaded");


    }

    @Test
    public void testMethod1(){
        Assert.assertEquals(driver.getTitle(), "Alchemy LMS – An LMS Application");

        driver.findElement(By.xpath("//a[text()='Contact']")).click();

        Assert.assertEquals(driver.getTitle(), "Contact – Alchemy LMS");
        Reporter.log("Newpage loaded");

    }

    @Test
    public void testMethod2(){

        driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Lokesh");
        driver.findElement(By.id("wpforms-8-field_1")).sendKeys("lossss@abc.com");
        driver.findElement(By.id("wpforms-8-field_3")).sendKeys("login issue");
        driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Unable to login");
        driver.findElement(By.id("wpforms-submit-8")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Thanks for contacting us! We will be in touch with you shortly.']")));

        String contactMessage = driver.findElement(By.xpath("//p[text()='Thanks for contacting us! We will be in touch with you shortly.']")).getText();
        System.out.println(contactMessage);
        Reporter.log("Newpage loaded");

    }


    @AfterClass
    public void tearDown(){
        Reporter.log("browser closed");
        driver.quit();
    }
}

