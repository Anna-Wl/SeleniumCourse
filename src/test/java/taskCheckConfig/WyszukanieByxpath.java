package taskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WyszukanieByxpath {
    public static void main(String[] args) throws InterruptedException {
        String signInButtonLocator = "hide_xs";
        String emailInputLocator = "is_required";
        String createAccountButtonLocator = "SubmitCreate";
        String firstNameLocator = "//*[@id=\"customer_firstname\"]";
        String lastnameLocator = "//*[@id=\"customer_lastname\"]";
        String emailToRegisterLocator = "//*[@id=\"email\"]";
        String passwordLocator = "//*[@id=\"passwd\"]";
        String registerButtonLocator = "//*[@id=\"submitAccount\"]";

        String myPersonalInformationLocator = "#center_column div div ul li:nth-child(4) a span";
        String myAddressLocator = "#center_column div div ul li:nth-child(5) a span";

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qloapps.coderslab.pl/en/");
        WebElement signInButton = driver.findElement(By.className(signInButtonLocator));
        signInButton.click();
        WebElement emailInput = driver.findElement(By.className(emailInputLocator));
        emailInput.sendKeys("test23456sf789e@test2.com");
        WebElement createAccountButton = driver.findElement(By.id(createAccountButtonLocator));
        createAccountButton.click();

        Thread.sleep(2000);
        WebElement firstName = driver.findElement(By.xpath(firstNameLocator));
        firstName.sendKeys("Jann");
        WebElement lastname = driver.findElement(By.xpath(lastnameLocator));
        lastname.sendKeys("Kowalskii");
        WebElement emailToRegister = driver.findElement(By.xpath(emailToRegisterLocator));
       // emailToRegister.sendKeys("");
        WebElement password = driver.findElement(By.xpath(passwordLocator));
        password.sendKeys("pass123");
        WebElement registerButton = driver.findElement(By.xpath(registerButtonLocator));
        registerButton.click();

        WebElement myPersonalInformation = driver.findElement(By.cssSelector(myPersonalInformationLocator));
        WebElement myAddress = driver.findElement(By.cssSelector(myAddressLocator));
    }
}


//    Zadanie 4 - By.xpath
//      Wyszukaj elementy za pomocą lokalizatora by.xpath
//      Będą na stronie rejestracji nowego użytkownika (patrz zadanie 3), wyszukaj za pomocą lokalizatorów xpath wszystkie wymagane pola tekstowe oraz wypełnij je dowolnymi danymi:
//
//        First Name
//        Last Name
//        Email
//        Password
//      Kliknij przycisk Register, który również wyszukaj przy pomocy lokalizatora by.xpath.

//     Zadanie 5 - By.cssSelector
//       Wyszukaj elementy za pomocą lokalizatora by.cssSelector
//       Po utworzeniu konta na stronie https://qloapps.coderslab.pl/en zidentyfikuj następujące pola korzystając z lokalizatora by.cssSelector:
//
//        MY PERSONAL INFORMATION
//        MY ADDRESSES