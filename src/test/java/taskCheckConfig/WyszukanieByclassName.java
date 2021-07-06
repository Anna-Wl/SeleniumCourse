package taskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WyszukanieByclassName {
    public static void main(String[] args) {
        String signInButtonLocator = "hide_xs";
        String emailInputLocator = "is_required";
        String createAccountButtonLocator = "SubmitCreate";
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qloapps.coderslab.pl/en/");
        WebElement signInButton = driver.findElement(By.className(signInButtonLocator));
        signInButton.click();

        WebElement emailInput = driver.findElement(By.className(emailInputLocator));
        emailInput.sendKeys("test@test1.com");

        WebElement createAccountButton = driver.findElement(By.id(createAccountButtonLocator));
        createAccountButton.click();
    }
}


//    Zadanie 3 - By.className
//      Wyszukaj elementy za pomocą lokalizatora by.className
//      Na stronie https://qloapps.coderslab.pl/en/ zidentyfikuj następująca pola/przyciski za pomocą lokalizatora by.id:
//
//        (przycisk) Sign In
//        (pole tekstowe) Email address
//      Po zidentyfikowaniu elementów kliknij przycisk Sign In i wpisz dowolny adres e-mail w pole Email address.
//      Rozpocznij tworzenie nowego użytkownika za pomocą kliknięcia przycisku Create an account (nie musi być z wykorzystaniem lokalizatora by.className)