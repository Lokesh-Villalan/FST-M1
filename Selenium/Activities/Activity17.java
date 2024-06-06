package examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity17 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        // create driver object
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // open the page
        driver.get("https://v1.training-support.net/selenium/selects");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        WebElement SelectElement = driver.findElement(By.id("single-select"));
        Select dropdown = new Select(SelectElement);
        //Select the second option using the visible text.
        dropdown.selectByVisibleText("Option 2");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        //Select the third option using the index.

        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());

        // Select the fourth option using the value.

        dropdown.selectByValue("4");
        System.out.println(dropdown.getFirstSelectedOption().getText());

       // Get all the options and print them to the console.
        System.out.println("Dropdown option are ");
        for(WebElement option : dropdown.getOptions()) {
            System.out.println(option.getText());
        }




        driver.quit();
    }
}
