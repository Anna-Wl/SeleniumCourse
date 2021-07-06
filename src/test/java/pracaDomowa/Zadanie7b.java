package pracaDomowa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadanie7b {
    public static void main(String[] args) {
        String accessoriesLocator = "//*[@id=\"category-6\"]/a";
        String accessoriesPriceLocator = "//*[@class=\"custom-checkbox\"]/input";


        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://prod-kurs.coderslab.pl/index.php");

        WebElement accessories = driver.findElement(By.xpath(accessoriesLocator));
        accessories.click();


        List<WebElement> allCheckboxes = driver.findElements(By.xpath("//*[starts-with(@class,\"facet-label\")]/span/input"));
        System.out.println(allCheckboxes);

        for(int i = 1; i < allCheckboxes.size(); i++) {
            String urlCategory = allCheckboxes.get(i).getAttribute("data-search-url");
            System.out.println(urlCategory);

            String[] splittedUrl = urlCategory.split("=");
            int lastIndex = splittedUrl.length-1;
            String lastPart = splittedUrl[lastIndex];
            System.out.println(lastPart);
            if(lastPart.trim() == "Paper+Type-Ruled") {
                allCheckboxes.get(i).click();
                System.out.println(lastPart);
            } else {
                System.out.println("noooo");
            }

        }

//        List<WebElement> allCatNames = driver.findElements(By.xpath("//*[starts-with(@class,\"facet-label\")]/a"));
//        System.out.println(allCatNames);
//        System.out.println(driver.findElement(By.xpath("//a[contains(text(), 'Stationery')]")));
//
//        for(int i = 1; i < allCatNames.size(); i++) {
//            System.out.println(allCatNames.get(i).getText());
//
//        }


    }
}
