package pracaDomowa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OperaDriver {
    public static void main(String[] args) {
        String signInLocator = "//*[@id=\"_desktop_user_info\"]/div/a/span";
        String noAccountStringLocator = "//*[@id=\"content\"]/div/a";

        System.setProperty("webdriver.opera.driver",
                "src/main/resources/drivers/operadriver.exe");

        WebDriver driver = new org.openqa.selenium.opera.OperaDriver();
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php");

        WebElement signInButton = driver.findElement(By.xpath(signInLocator));
        signInButton.click();
        WebElement noAccountString = driver.findElement(By.xpath(noAccountStringLocator));
        noAccountString.click();

        driver.navigate().back();
        driver.navigate().back();
    }
}

//    Zadanie 2
//    Inna przeglądrka
//    Ściagnij inny sterownik przeglądarki i spróbuj uruchomić dowolny test na innej przeglądarce.