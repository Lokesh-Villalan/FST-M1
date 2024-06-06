package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity19 {
    public static void main(String[] args) {
        // Set up Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        // Print the title of the page
        System.out.println("Home page title: " + driver.getTitle());
        //Find the button to open a CONFIRM alert and click it.
        driver.findElement(By.id("confirm")).click();

        //Switch the focus from the main window to the Alert box and get the text in it and print it.
        Alert confirmalert = driver.switchTo().alert();
        System.out.println("Title of alert: " + confirmalert.getText());

        //Close the alert once with Ok and again with Cancel.
        confirmalert.accept();


        // Close the browser
        driver.quit();
    }
}
