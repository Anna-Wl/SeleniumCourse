package pracaDomowa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie1 {
    public static void main(String[] args) {
        String signInLocator = "//*[@id=\"_desktop_user_info\"]/div/a/span";
        String noAccountStringLocator = "//*[@id=\"content\"]/div/a";

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
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


//    Zadanie 1
//    Nawigacja
//    Na stronie https://prod-kurs.coderslab.pl/index.php wykonaj następującą sekwencję kroków:
//
//    1. Wejdź na stronę główną.
//    2. Przejdź do opcji 'Sign in'
//    3. Wybierz opcję 'No account? Create on here'
//    4. Za pomocą metod nawigacyjnych przejdź do strony głównej.