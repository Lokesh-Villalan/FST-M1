package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity21 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://v1.training-support.net/selenium/tab-opener");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());
        String handle1 = driver.getWindowHandle();
                System.out.println("Handle of the page: " + handle1);
//Find the button to open a new tab and click it.
        driver.findElement(By.id("launcher")).click();
        // print the current handle
        System.out.println("Current handle : " + driver.getWindowHandles());
//Wait for the new tab to open.
        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
//Print all the handles.
        System.out.println("Home page title: " + driver.getTitle());
        System.out.println("Handle of the page: " + driver.getWindowHandle());
        wait.until(ExpectedConditions.elementToBeClickable(By.id("actionButton"))).click();
//Switch to the newly opened tab, print it's title and heading.
        System.out.println("Current handle : " + driver.getWindowHandles());
        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }
//Repeat the steps by clicking the button in the new tab page.
        System.out.println("Home page title: " + driver.getTitle());
        System.out.println("Handle of the page: " + driver.getWindowHandle());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("i")));
        System.out.println("page content: " + driver.findElement(By.className("header")).getText());

        driver.switchTo().window(handle1);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("launcher")));
        System.out.println("Home page title: " + driver.getTitle());


        // Close the browser
        driver.quit();
    }
}
