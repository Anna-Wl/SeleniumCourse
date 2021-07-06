package taskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WyszukanieByName {
    public static void main(String[] args) {
        String hotelInputLocator = "hotel_location";
        String searchNowButtonLocator = "search_room_submit";
        String emailInputLocator = "email";
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qloapps.coderslab.pl/en/");
        WebElement hotelLocationInput = driver.findElement(By.name(hotelInputLocator));
        WebElement searchNowButton = driver.findElement(By.name(searchNowButtonLocator));
        WebElement emailInput = driver.findElement(By.name(emailInputLocator));
        // dalej możemy pracować z elementami

        hotelLocationInput.sendKeys("Warsaw");
        emailInput.sendKeys("test@test.com");
        searchNowButton.submit();
    }
}

//    Zadanie 2 - By.name
//      Wyszukaj elementy za pomocą lokalizatora by.name
//      Na stronie https://qloapps.coderslab.pl/en/ zidentyfikuj następująca pola/przyciski za pomocą lokalizatora by.id:
//
//      (pole tekstowe) Hotel Location
//      (przycisk) Search Now
//      (pole tekstowe) Enter your e-mail (pole na dole stron)
//      (przycisk) Subscribe
//    Po zidentyfikowaniu elementów wpisz następujące wartości w pola tekstowe:
//
//    Hotel Location - Warsaw
//      Enter your e-mail - test@test.com
//    Dodatkowo kliknij przycisk Serach Now, używając metody Submit np.
//      findElement(By.name("q")).submit();
