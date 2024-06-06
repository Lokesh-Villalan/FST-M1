package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        // create driver object
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // open the page
        driver.get("https://v1.training-support.net/selenium/ajax");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        //Find and click the "Change content" button on the page.
        driver.findElement(By.className("violet")).click();

        //Wait for the text to say "HELLO!". Print the message that appears on the page.
        String heading1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))).getText();
        System.out.println("Heading 1 is :" + heading1);
                //Wait for the text to change to contain "I'm late!". Print the new message on the page
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));
        String heading3 = driver.findElement(By.tagName("h3")).getText();
        System.out.println("Heading 3 is : "+ heading3);
                driver.quit();
    }
}
