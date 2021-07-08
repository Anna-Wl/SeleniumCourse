package pracaDomowa;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadanie3 {
    public static void main(String[] args) throws InterruptedException {
        String firstNameLocator = "first-name";
        String lastNameLocator = "last-name";
        String genderLocator = "#infoForm div:nth-child(3) div div label:nth-child(1)";
        String dateOfBirthLocator = "dob";
        String addressLocator = "address";
        String emailLocator = "email";
        String passwordLocator = "password";
        String companyLocator = "company";
        String commentLocator = "comment";
        String submitButtonLocator = "submit";
        String submitMsgLocator = "submit-msg";
        String roleLocator = "role";
        String challengingJobOptionLocator = "//*[@id=\"expectation\"]/option[6]";
        String highSalaryJoOptionLocator = "//*[@id=\"expectation\"]/option[1]";
        String onlineCoursesWaysOfDevLocator = "//*[@id=\"infoForm\"]/div[11]/div/div[2]/label/input";
        String readBlogsWaysOfDevLocator = "//*[@id=\"infoForm\"]/div[11]/div/div[5]/label/input";

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");

        WebElement firstName = driver.findElement(By.id(firstNameLocator));
        firstName.sendKeys("Karol");
        WebElement lastName = driver.findElement(By.id(lastNameLocator));
        lastName.sendKeys("Kowalski");
        WebElement gender = driver.findElement(By.cssSelector(genderLocator));
        gender.click();
        WebElement dateOfBirth = driver.findElement(By.id(dateOfBirthLocator));
        dateOfBirth.sendKeys("05/22/2010");
        WebElement address = driver.findElement(By.id(addressLocator));
        address.sendKeys("Prosta 51");

        WebElement email = driver.findElement(By.id(emailLocator));
        email.sendKeys("karol.kowalski@mailinator.com");
        WebElement password = driver.findElement(By.id(passwordLocator));
        password.sendKeys("password");
        WebElement company = driver.findElement(By.id(companyLocator));
        company.sendKeys("Coders Lab");
        WebElement role = driver.findElement(By.id(roleLocator));
        Select roleSelect = new Select(role);
        roleSelect.selectByVisibleText("QA");

        WebElement challengingJobOption = driver.findElement(By.xpath(challengingJobOptionLocator));
        WebElement highSalaryJoOption = driver.findElement(By.xpath(highSalaryJoOptionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", highSalaryJoOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", challengingJobOption);
        System.out.println(highSalaryJoOption.getText());
        System.out.println(challengingJobOption.getText());
        Thread.sleep(500);

        WebElement onlineCoursesWaysOfDev = driver.findElement(By.xpath(onlineCoursesWaysOfDevLocator));
        onlineCoursesWaysOfDev.click();
        WebElement readBlogsWaysOfDev = driver.findElement(By.xpath(readBlogsWaysOfDevLocator));
        readBlogsWaysOfDev.click();

        WebElement comment = driver.findElement(By.id(commentLocator));
        comment.sendKeys("To jest mój pierwszy automat testowy");
        WebElement submitButton = driver.findElement(By.id(submitButtonLocator));
        submitButton.submit();
        WebElement submitMsg = driver.findElement(By.id(submitMsgLocator));
        String submitMsgText = submitMsg.getText().trim();
        System.out.println(submitMsgText);
        if(submitMsgText.equals("Successfully submitted!")) {
            System.out.println("Successfully submitted!");
        } else {
            System.out.println("Not submitted!");
        }
    }
}


//    Zadanie 3
//    Wyszukiwanie elementów - formularz
//    Pod linkiem https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html dostępny jest formularz, którego wypełnianie i wysyłanie należy zautomatyzować.
//
//    Wypełnij dane w formularzu:
//
//        First name: Karol
//        Last name: Kowalski
//        Gender: Male
//        Date of birth: 05/22/2010
//        Address: Prosta 51
//
//        Email: karol.kowalski@mailinator.com
//        Password: Pass123
//        Company: Coders Lab
//        Comment: To jest mój pierwszy automat testowy
//
//        Zatwierdź formularz - SUBMIT