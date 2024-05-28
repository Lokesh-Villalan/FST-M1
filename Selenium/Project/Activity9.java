package LMS_Project_Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity9 {
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

        driver.findElement(By.xpath("//a[text()='All Courses']")).click();

        Assert.assertEquals(driver.getTitle(), "All Courses – Alchemy LMS");
        Reporter.log("Newpage loaded");
    }

    @Test
    public void testMethod2() {
        driver.findElement(By.xpath("//p//a[@href='https://alchemy.hguy.co/lms/courses/social-media-marketing/']")).click();
        Assert.assertEquals(driver.getTitle(), "Social Media Marketing – Alchemy LMS");
        driver.findElement(By.xpath("//a[text()='Login to Enroll']")).click();

        WebElement userName = driver.findElement(By.id("user_login"));
        WebElement passWord = driver.findElement(By.id("user_pass"));
        WebElement loginButton = driver.findElement(By.id("wp-submit"));

        userName.clear();
        userName.sendKeys("root");
        passWord.clear();
        passWord.sendKeys("pa$$w0rd");
        loginButton.click();
    }

    @Test
    public void testMethod3(){
        WebElement contentLink = driver.findElement(By.xpath("//div//a[@href='https://alchemy.hguy.co/lms/lessons/developing-strategy/']"));
        contentLink.click();
        Assert.assertEquals(driver.getTitle(), "Developing Strategy – Alchemy LMS");

        String completionStatus  = driver.findElement(By.xpath("//span[@class='ld-lesson-list-progress']")).getText();
        Assert.assertEquals(completionStatus, "100% COMPLETE");


        //logout
        driver.findElement(By.xpath("//span//img[contains(@class,'avatar-96')]")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        Reporter.log("Newpage loaded");
    }


    @AfterClass
    public void tearDown(){
        Reporter.log("browser closed");
        driver.quit();
    }
}





