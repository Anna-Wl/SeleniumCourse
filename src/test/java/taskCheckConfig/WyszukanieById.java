package taskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WyszukanieById {
    public static void main(String[] args) {
        String hotelInputLocator = "hotel_location";
        String searchNowButtonLocator = "search_room_submit";
        String emailInputLocator = "newsletter-input";
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qloapps.coderslab.pl/en/");
        WebElement hotelLocationInput = driver.findElement(By.id(hotelInputLocator));
        WebElement searchNowButton = driver.findElement(By.id(searchNowButtonLocator));
        WebElement emailInput = driver.findElement(By.id(emailInputLocator));
        // dalej możemy pracować z elementami

        hotelLocationInput.sendKeys("Warsaw");
        emailInput.sendKeys("test@test.com");

    }
}

//    Zadanie 1 - By.id
//    Wyszukaj elementy za pomocą lokalizatora by.id
//    Na stronie https://qloapps.coderslab.pl/en/ zidentyfikuj następująca pola/przyciski za pomocą lokalizatora by.id:
//
//      (pole tekstowe) Hotel Location
//      (przycisk) Search Now
//      (pole tekstowe) Enter your e-mail (pole na dole stron)
//    Po zidentyfikowaniu elementów wpisz następujące wartości w pola tekstowe:
//
//      Hotel Location - Warsaw
//      Enter your e-mail - test@test.com
//    Użyj metody sendKeys np.
//      findElement(By.id("q")).sendKeys("Coderslab");

