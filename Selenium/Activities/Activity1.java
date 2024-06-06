package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) throws InterruptedException {
        // Get Firefox driver
        WebDriverManager.firefoxdriver().setup();
        // create driver object
        WebDriver driver = new FirefoxDriver();

        // open the page
        driver.get("https://training-support.net/");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        Thread.sleep(2000);
        // find and interact with the element
        driver.findElement(By.linkText("About Us")).click();
        String newPageTitle = driver.getTitle();
        System.out.println(newPageTitle);
        Thread.sleep(2000);
        driver.quit();

    }
}
