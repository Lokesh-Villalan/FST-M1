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

import java.awt.*;
import java.util.List;

public class Activity7 {
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
    public void testMethod2(){
        List<WebElement> courseList = driver.findElements(By.xpath("//div[@class='ld_course_grid col-sm-8 col-md-4 ']"));
        System.out.println("Course List Count = " + courseList.size());
    }


    @AfterClass
    public void tearDown(){
        Reporter.log("browser closed");
        driver.quit();
    }
}




