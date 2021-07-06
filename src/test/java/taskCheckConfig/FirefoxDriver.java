package taskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirefoxDriver {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver",
                "src/main/resources/drivers/geckodriver.exe");

        WebDriver driver = new org.openqa.selenium.firefox.FirefoxDriver();
        driver.manage().window().maximize();
        //driver.get("http://www.google.com");
        driver.get("http://www.bing.com");
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys("Coderslab");
        element.submit();
        driver.quit();
    }
}
//   Zadanie 2
//   Ściagnij inny sterownik przeglądarki i spróbuj uruchomić dowolny test na innej przeglądarce.