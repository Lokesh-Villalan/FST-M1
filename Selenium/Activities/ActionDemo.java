package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        WebDriver driver = new FirefoxDriver();

        Actions builder = new Actions(driver);

        driver.get("https://duckduckgo.com/");
         WebElement searchbar = driver.findElement(By.id("searchbox_input"));

         builder
                 .sendKeys("hello")
                 .keyDown(Keys.SHIFT)
                 .sendKeys("lokesh")
                 .keyUp(Keys.SHIFT)
                 .build().perform();
    }
}
