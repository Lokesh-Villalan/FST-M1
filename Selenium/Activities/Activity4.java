package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://v1.training-support.net/selenium/target-practice");
        System.out.println("Home page title: " + driver.getTitle());
        System.out.println("3rd header: " + driver.findElement(By.xpath("//h3[@id='third-header']")).getText());
        System.out.println("5th header color: " + driver.findElement(By.xpath("//h5[text()='Fifth header']")).getCssValue("color"));
        String violetbutton = driver.findElement(By.xpath("//button[text()='Violet']")).getAttribute("class");
        System.out.println("Violet button classes: " + violetbutton);
        String greybutton = driver.findElement(By.xpath("//button[text()='Grey']")).getText();
        System.out.println("Grey button name: " + greybutton);

        driver.quit();
    }
}
