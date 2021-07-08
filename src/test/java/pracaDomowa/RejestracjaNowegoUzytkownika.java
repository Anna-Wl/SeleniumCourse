package pracaDomowa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class RejestracjaNowegoUzytkownika {
    public static void main(String[] args) {
        String signInLocator = "//*[@id=\"_desktop_user_info\"]/div/a/span";
        String noAccountStringLocator = "//*[@id=\"content\"]/div/a";

        //Uruchamiam przegladarke i wchodze na strone
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php");

        //Wybieram przycisk rejestracji na stronie glownej
        WebElement signInButton = driver.findElement(By.xpath(signInLocator));
        signInButton.click();

        //Jestm na stronie 'Login to your account'
        //Wybieram opcje 'No account, create one here' umozliwiajaca zarejestrowanie nowego uzytkownika
        WebElement noAccountString = driver.findElement(By.xpath(noAccountStringLocator));
        noAccountString.click();

        //Jestem na stronie 'Create an account'
        String socialTitleLocator = "//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[1]/span/input";
        String firstNameLocator = "//*[@id=\"customer-form\"]/section/div[2]/div[1]/input";
        String lastNameLocator = "//*[@id=\"customer-form\"]/section/div[3]/div[1]/input";
        String emailLocator = "//*[@id=\"customer-form\"]/section/div[4]/div[1]/input";
        String passwordLocator = "//*[@id=\"customer-form\"]/section/div[5]/div[1]/div/input";
        String birthdayLocator = "//*[@id=\"customer-form\"]/section/div[6]/div[1]/input";
        String showButtonLocator = "//*[@id=\"customer-form\"]/section/div[5]/div[1]/div/span/button";
        String saveButtonLocator = "//*[@id=\"customer-form\"]/footer/button";

        WebElement socialTitle = driver.findElement(By.xpath(socialTitleLocator));
        WebElement firstName = driver.findElement(By.xpath(firstNameLocator));
        WebElement lastName = driver.findElement(By.xpath(lastNameLocator));
        WebElement email = driver.findElement(By.xpath(emailLocator));
        WebElement password = driver.findElement(By.xpath(passwordLocator));
        WebElement birthday = driver.findElement(By.xpath(birthdayLocator));
        WebElement showButton = driver.findElement(By.xpath(showButtonLocator));
        showButton.click();
        WebElement saveButton = driver.findElement(By.xpath(saveButtonLocator));

        //Dane testowe
        String firstNameTest = "Jan";
        String lastNameTest = "Kowalski";
        String emailTest = "";
        String passwordTest = "pass123";
        String userBirthdayTest = "02/22/1998";
        String userFullName = firstNameTest + " " + lastNameTest;

        //Tworzenie losowego adresu email
        Random random = new Random();
        int randomInteger = random.nextInt(50); //losuje liczby z przedziału 0 - 49
        emailTest = "testt" + randomInteger + "@test2.com";
        System.out.println(emailTest);

        firstName.sendKeys(firstNameTest);
        lastName.sendKeys(lastNameTest);
        email.sendKeys(emailTest);
        password.sendKeys(passwordTest);
        birthday.sendKeys(userBirthdayTest);
        saveButton.click();

        //Jestem na stronie glownej
        String userFullNameLocator = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span";
        String signOutLinkLocator = "//*[@id=\"_desktop_user_info\"]/div/a[1]";

        WebElement userFullNameElement = driver.findElement(By.xpath(userFullNameLocator));
        WebElement signOutLink = driver.findElement(By.xpath(signOutLinkLocator));

        String userFullNameText = userFullNameElement.getText();
        if(userFullNameText.equals(userFullName)) {
            System.out.println("Poprawna rejestracja");
        } else {
            System.out.println("Niepoprawna rejestracja");
        }

        signOutLink.click();

    }
}
