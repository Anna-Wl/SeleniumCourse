package pracaDomowa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Random;

public class Zadanie6b {
    public static void main(String[] args) throws InterruptedException {
        String signInButtonLocator = "hide_xs";
        String emailInputLocator = "is_required";
        String createAccountButtonLocator = "SubmitCreate";
        String firstNameLocator = "//*[@id=\"customer_firstname\"]";
        String lastNameLocator = "//*[@id=\"customer_lastname\"]";
        String emailToRegisterLocator = "//*[@id=\"email\"]";
        String passwordLocator = "//*[@id=\"passwd\"]";
        String registerButtonLocator = "//*[@id=\"submitAccount\"]";
        int numberOfUsers = 10;

        Random random = new Random();
        int indexNumRandom = random.nextInt(numberOfUsers+1); //
//        int randomInteger = random.nextInt(50); //losuje liczby z przedziału 0 - 49
//        int indexNumRandom = randomInteger % userNumbers;
        System.out.println(indexNumRandom);

        //Generuje liste maili
        String emailToTest = "testf2ds3456fd78dd12e1232d224@test2.com";
        List<String> emailList = new ArrayList<String>();
        for(int i = 0; i < numberOfUsers; i++) {
            String emailTest = "testEmail" + i + "@test2.com";
            emailList.add(emailTest);
        }
        System.out.println(emailList);
        //int indexNum = randomInteger % emailList.size();
        //System.out.println(indexNum);
       // String emailToTest = emailList.get(indexNumRandom);
        System.out.println(emailToTest);

        //Lista imion
        String[] firstNameArray = {"Aleksandra","Jan","Przemyslaw","Karol","Igor","Grzegorz", "Wlodzimierz","Bartek", "Zdzislaw", "Leon"};
        List<String> firstNameList = Arrays.asList(firstNameArray);
        String firstNameToTest = firstNameList.get(indexNumRandom);
        System.out.println(firstNameToTest);

        //Lista nazwisk
        String[] lastNameArray = {"Nowak", "Kowalski", "Wisniewski", "Szymanski", "Kozlowski", "Wojcik", "Kowalczyk", "Kaminski", "Lewandowski", "Zielinski"};
        List<String> lastNameList = Arrays.asList(lastNameArray);
        String lastNameToTest = lastNameList.get(indexNumRandom);
        System.out.println(lastNameToTest);

        //Lista hasel
        String[] passwordArray = {"pass123", "pa1234", "pp4422", "1558ep", "45454fsd", "ppaa122", "fs55fd", "sfds111", "dsfsd44", "fsdf444"};
        List<String> passworList = Arrays.asList(passwordArray);
        String passwordToTest = passworList.get(indexNumRandom);
        System.out.println(passwordToTest);



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

        //nie wylapuje
//        String msgEmailExistsLocator = "//*[@id=\"create_account_error\"]/ol/li";
//        WebElement msgEmailExists = driver.findElement(By.xpath(msgEmailExistsLocator));
//        //msgEmailExists.getText();
//        System.out.println(msgEmailExists);

        Thread.sleep(2000);
        WebElement firstName = driver.findElement(By.xpath(firstNameLocator));
        if(firstName.isDisplayed()) {
            firstName.sendKeys(firstNameToTest);
        } else {
            return;
        }

        WebElement lastName = driver.findElement(By.xpath(lastNameLocator));
        if(lastName.isDisplayed()) {
            lastName.sendKeys(lastNameToTest);
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
            password.sendKeys(passwordToTest);
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