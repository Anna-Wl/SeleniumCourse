package pracaDomowa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadanie7 {
    public static void main(String[] args) {
        String accessoriesLocator = "//*[@id=\"category-6\"]/a";
        String accessoriesPriceLocator = "//*[@class=\"custom-checkbox\"]/input";
        String filterByPlainLocator = "//*[@id='facet_23757']/li[2]/label/span/span/i";
        String stationeryLocator = "//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a";
        String filterByStationeryRuledLocatorCheckbox = "//*[@id=\"facet_input_66629_0\"]";

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://prod-kurs.coderslab.pl/index.php");

        WebElement accessories = driver.findElement(By.xpath(accessoriesLocator));
        accessories.click();
        WebElement accessoriesPrice = driver.findElement(By.xpath(accessoriesPriceLocator));
        accessoriesPrice.click();
//        WebElement stationery = driver.findElement(By.xpath(stationeryLocator));
//        stationery.click();
//        WebElement filterByStationeryRuled = driver.findElement(By.xpath(filterByStationeryRuledLocatorCheckbox));
//        filterByStationeryRuled.click();
//        WebElement filterByPlain = driver.findElement(By.xpath(filterByPlainLocator));
//        filterByPlain.click();

        //Select checkboxes
//        List<WebElement> allCheckboxes = driver.findElements(By.xpath("//*[starts-with(@id,'facet_input')]"));
//        System.out.println(allCheckboxes);
        List<WebElement> allCheckboxes = driver.findElements(By.xpath("//*[starts-with(@class,\"facet-label\")]/span/input"));
        System.out.println(allCheckboxes);

        for(int i = 1; i < allCheckboxes.size(); i++) {
            System.out.println(allCheckboxes.get(i).getAttribute("data-search-url"));
        }

        List<WebElement> allCatNames = driver.findElements(By.xpath("//*[starts-with(@class,\"facet-label\")]/a"));
        System.out.println(allCatNames);

        for(int i = 1; i < allCatNames.size(); i++) {
            System.out.println(allCatNames.get(i).getText());
        }


    }
}
