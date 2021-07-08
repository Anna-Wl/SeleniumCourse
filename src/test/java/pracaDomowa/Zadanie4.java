package pracaDomowa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadanie4 {
    public static void main(String[] args) {
        String socialTitleLocator = "//*[@id='customer-form']/section/div[1]/label";
        String firstNameLocator = "//*[@id='customer-form']/section/div[2]/label";
        String lastNameLocator = "//*[@id='customer-form']/section/div[3]/label";
        String emailLocator = "//*[@id=\"customer-form\"]/section/div[4]/label";
        String passwordLocator = "//*[@id=\"customer-form\"]/section/div[5]/label";
        String showButtonLocator = "//*[@id=\"customer-form\"]/section/div[5]/div[1]/div/span/button";
        String birthdayLocator = "//*[@id=\"customer-form\"]/section/div[6]/label";

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&create_account=1");

        WebElement socialTitle = driver.findElement(By.xpath(socialTitleLocator));
        WebElement firstName = driver.findElement(By.xpath(firstNameLocator));
        WebElement lastName = driver.findElement(By.xpath(lastNameLocator));
        WebElement email = driver.findElement(By.xpath(emailLocator));
        WebElement password = driver.findElement(By.xpath(passwordLocator));
        WebElement showButton = driver.findElement(By.xpath(showButtonLocator));
        showButton.click();
        WebElement birthday = driver.findElement(By.xpath(birthdayLocator));
    }
}

//    Zadanie 4 - xPath
//    Ćwiczenia z wyszukiwania xPath
//    Na portalu sklepu internetowego https://prod-kurs.coderslab.pl/index.php?controller=authentication&create_account=1 wyszukaj następujące elementy:
//
//       social title
//       First name
//       Last name
//       Email
//       Password
//       Show
//       Birthdate