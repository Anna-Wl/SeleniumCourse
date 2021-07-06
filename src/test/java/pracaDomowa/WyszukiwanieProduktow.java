package pracaDomowa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class WyszukiwanieProduktow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://prod-kurs.coderslab.pl/index.php");

        String[] products = {"mug", "t-shirt", "notebook" };
        Random random = new Random();
        int randomInteger = random.nextInt(50); //losuje liczby z przedziału 0 - 49
        int seekElement = randomInteger % products.length;
        System.out.println(seekElement);

        WebElement element = driver.findElement(By.name("s"));
        element.sendKeys(products[seekElement]);
        element.submit();
    }

}
