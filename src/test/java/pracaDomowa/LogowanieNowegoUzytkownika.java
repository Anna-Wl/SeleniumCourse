package pracaDomowa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class LogowanieNowegoUzytkownika {
    public static void main(String[] args) {
        //Jestem na stronie glownej
        String signInLocator = "//*[@id=\"_desktop_user_info\"]/div/a/span";

        //Uruchamiam przegladarke i wchodze na strone
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php");

        //Wybieram przycisk rejestracji na stronie glownej
        WebElement signInButton = driver.findElement(By.xpath(signInLocator));
        signInButton.click();

        //Dane testowe
        String emailTest = "test12@test2.com";
        String passwordTest = "pass123";

        //Jestm na stronie 'Login to your account'
        String emailLoginLocator = "//*[@id=\"login-form\"]/section/div[1]/div[1]/input";
        String passwordLoginLocator = "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input";
        String signInLoginButtonLocator = "submit-login";
        WebElement emailLogin = driver.findElement(By.xpath(emailLoginLocator));
        WebElement passwordLogin = driver.findElement(By.xpath(passwordLoginLocator));
        WebElement signInLoginButton = driver.findElement(By.id(signInLoginButtonLocator));
        emailLogin.sendKeys(emailTest);
        passwordLogin.sendKeys(passwordTest);
        signInLoginButton.click();


    }
}
