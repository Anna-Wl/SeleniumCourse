package taskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WyszukanieisDisplayed {
    public static void main(String[] args) throws InterruptedException {
        String signInButtonLocator = "hide_xs";
        String emailInputLocator = "is_required";
        String createAccountButtonLocator = "SubmitCreate";
        String firstNameLocator = "//*[@id=\"customer_firstname\"]";
        String lastNameLocator = "//*[@id=\"customer_lastname\"]";
        String emailToRegisterLocator = "//*[@id=\"email\"]";
        String passwordLocator = "//*[@id=\"passwd\"]";
        String registerButtonLocator = "//*[@id=\"submitAccount\"]";

        String emailToTest = "testf2ds3456fd78dd12e1232d224@test2.com";

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
        emailInput.sendKeys(emailToTest);
        WebElement createAccountButton = driver.findElement(By.id(createAccountButtonLocator));
        createAccountButton.click();

        Thread.sleep(2000);
        WebElement firstName = driver.findElement(By.xpath(firstNameLocator));
        if(firstName.isDisplayed()) {
            firstName.sendKeys("Jann");
        } else {
            return;
        }

        WebElement lastName = driver.findElement(By.xpath(lastNameLocator));
        if(lastName.isDisplayed()) {
            lastName.sendKeys("Kowalskii");
        } else {
            return;
        }

        WebElement emailToRegister = driver.findElement(By.xpath(emailToRegisterLocator));

        emailToRegister.sendKeys("");
        if(emailToRegister.isDisplayed()) {
            if(emailToRegister.getAttribute("value") == "") {
              return;
            }
        } else {
            emailToRegister.sendKeys(emailToTest);
        }

        WebElement password = driver.findElement(By.xpath(passwordLocator));
        if(password.isDisplayed()) {
            password.sendKeys("pass123");
        } else {
            return;
        }

        WebElement registerButton = driver.findElement(By.xpath(registerButtonLocator));
        WebElement signUpforNewsletterBox = driver.findElement(By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[7]/label"));
        if(signUpforNewsletterBox.isSelected() && registerButton.isDisplayed()) {
                registerButton.click();
        } else {
          signUpforNewsletterBox.click();
            if(registerButton.isDisplayed()) {
                registerButton.click();
            } else {
                return;
            }
        }

        WebElement myPersonalInformation = driver.findElement(By.cssSelector(myPersonalInformationLocator));
        WebElement myAddress = driver.findElement(By.cssSelector(myAddressLocator));
    }
}

//    Zadanie 1
//      Funkcje
//      Będą na stronie rejestracji nowego użytkownika https://qloapps.coderslab.pl/en/ , wyszukaj za wszystkie pola oraz zweryfikuj za pomocą odpowiednich metod czy są one widoczne, aby wpisać tam wartości.
//
//        First Name
//        Last Name
//        Email
//        Password
//      Potwierdź rejestrację nowego użytkownika (wcześniej sprawdzając, czy przycisk jest widoczny).