package pracaDomowa;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;

public class Zadanie8b {
    public static void main(String[] args) throws InterruptedException {
        //Wartosci testowe
        String productNameTestRaw = "Hummingbird Printed T-Shirt";
        String sizeTest = "M";
        String colorTest = "Black";
        String priceEmbeded = "";


        //Wartosci testowe lowercase
        String productNameTest = productNameTestRaw.toLowerCase();

        //Uruchomienie przegladarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://prod-kurs.coderslab.pl/index.php");





        //Wybieram produkt ze strony, zapisuje jego cene
        //Wybieram produkt ze strony
        String productTitlesLocator = "//*[@id=\"content\"]/section/div/article[1]/div/div[1]/h3/a";
        List<WebElement> productTitles = driver.findElements(By.xpath(productTitlesLocator));
        System.out.println(productTitles);
        int titleIndex = 0;
        for (int i = 0; i <productTitles.size(); i++) {
            String singleProductName = productTitles.get(i).getText();
            if(singleProductName.toLowerCase().equals(productNameTest) ) {
                System.out.println(singleProductName);
                titleIndex = i;
                productTitles.get(i).click();
            }
        }

        //Zapisuje cene wybranego produktu w pamieci
        String itemPropPriceLocator = "//*[@itemprop='price']";
        List<WebElement> itemPropPrice = driver.findElements(By.xpath(itemPropPriceLocator));
        System.out.println(itemPropPrice);
        WebElement seekPrice = itemPropPrice.get(titleIndex);
        priceEmbeded = seekPrice.getText();
        System.out.println(seekPrice.getText());


        //Jestem na stronie produktu
        String sizeDropdownLocator = "group_1";
        String colorLocator = "//*[@id=\"group_2\"]/li[2]/label/input";
        // String qtyUpButtonLocator = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[1]/div/span[3]/button[1]";
        String qtyFieldLocator = "quantity_wanted";
        String qtyUpButtonLocator = "#add-to-cart-or-refresh div.product-add-to-cart div div.qty div span.input-group-btn-vertical button.btn.btn-touchspin.js-touchspin.bootstrap-touchspin-up";
        String addToCartLocator = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button";
        String proceedToCheckoutLocator = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a";
        String productSizeModalLocator = "#blockcart-modal div div div.modal-body div div.col-md-5.divide-right div div:nth-child(2) span:nth-child(3)";
        String productNameModalLocator = "product-name";
        String productPriceModalLocator = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p[1]";
        String productColorModalLocator = "#blockcart-modal > div > div > div.modal-body > div > div.col-md-5.divide-right > div > div:nth-child(2) > span:nth-child(5)";
        String cartItemsTotalLocator = "//*[@id=\"_desktop_cart\"]/div/div/a/span[2]";
        String productNameCartLocator = "//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[1]/a";
        String productPriceCartLocator = "//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]";

        //Wybieram rozmiar
        WebElement sizeDropdown = driver.findElement(By.id(sizeDropdownLocator));
        Select sizeDropdownSelect = new Select(sizeDropdown);
        sizeDropdownSelect.selectByVisibleText(sizeTest);


        // Wybieram color
        //wybieram ktory kolor
        String colorsLocator = "sr-only";
        List<WebElement> colors = driver.findElements(By.className(colorsLocator));
        System.out.println(colors);
        int colorIndex = 0;
        for (int i = 0; i <colors.size(); i++ ) {
            String singleColor = colors.get(i).getText();
            System.out.println(singleColor);
            System.out.println(i);
            if(singleColor.equals(colorTest)) {
                colorIndex = i;
            }
        }
        System.out.println(colorIndex);

        //Klikam na input tego koloru
        String colorNamesLocator = "input-color";
        List<WebElement> colorsInput = driver.findElements(By.className(colorNamesLocator));
        WebElement seekColorInput = colorsInput.get(colorIndex);
        seekColorInput.click();
        System.out.println(colorsInput.get(colorIndex).getAttribute("value"));

       // Wybieram ilosc
//            WebElement qtyUpButton = driver.findElement(By.xpath(qtyUpButtonLocator));
//            qtyUpButton.click();
        WebElement qtyUpButton = driver.findElement(By.cssSelector(qtyUpButtonLocator));
        qtyUpButton.click();
        qtyUpButton.click();

//        WebElement qtyField = driver.findElement(By.id(qtyFieldLocator));
//        qtyField.getAttribute("value");
//        qtyField.sendKeys(Keys.BACK_SPACE);
//        qtyField.sendKeys("22");
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("document.getElementById('quantity_wanted').setAttribute('value', '22')");
//        qtyField.sendKeys(Keys.DELETE);
//        qtyField.sendKeys(Keys.BACK_SPACE);
//        qtyField.sendKeys(Keys.ARROW_UP);
//        qtyField.sendKeys(Keys.ARROW_UP);

        //Dodaje do karty
        WebElement addToCart = driver.findElement(By.xpath(addToCartLocator));
        addToCart.click();
        Thread.sleep(2000);

        //Ilosc produktow w koszyku
        WebElement cartItemsTotal = driver.findElement(By.xpath(cartItemsTotalLocator));
        String cartItemsTotalText = cartItemsTotal.getText();
        String cartItemsTotalTextWanted= cartItemsTotalText.replaceAll("[\\(\\)\\[\\]\\{\\}]","");



        //Otwiera sie modal window
        //LEWA STRONA
        //Sprawdzam czy wartosci dodane do karty sa poprawne
        //Sprawdzenie czy poprawna jest nazwa
        WebElement productNameModal = driver.findElement(By.className(productNameModalLocator));
        System.out.println(productNameModal);
        String productNameModalText = productNameModal.getText().toLowerCase();
        System.out.println(productNameModalText);
        if(productNameModalText.equals(productNameTest)) {
            System.out.println("productNameTest on modal window pass");
        } else {
            System.out.println("productNameTest on modal window  fail");
        }

        //Sprawdzenie czy poprawna jest cena wyjsciowa pojedynczego produktu
        WebElement productPriceModal = driver.findElement(By.xpath(productPriceModalLocator));
        System.out.println(productPriceModal);
        String productPriceModalText = productPriceModal.getText();
        System.out.println("product price modal text " + productPriceModalText);
        if(priceEmbeded.equals(productPriceModalText)) {
            System.out.println("priceEmbeded on modal window correct");
        } else {
            System.out.println("priceEmbeded on modal window incorrect");
        }


        //Strawdzenie czy poprawny jest rozmiar
        WebElement productSizeModal = driver.findElement(By.cssSelector(productSizeModalLocator));
        String productSizeModalText = productSizeModal.getText();
        String productSizeModalTextLast = getLastText(productSizeModalText, " ");
        System.out.println(productSizeModalTextLast);
//        String[] bits = productSizeModalText.split(" ");
//        String productSizeModalTextLast = bits[bits.length-1];
        if(sizeTest.equals(productSizeModalTextLast)) {
            System.out.println("sizeTest on modal window pass");
        } else {
            System.out.println("sizeTest on modal window fail");
        }

        //Sprawdzenie czy poprawny jest kolor
        WebElement productColorModal = driver.findElement(By.cssSelector(productColorModalLocator));
        String productColorModalText = productColorModal.getText();
        System.out.println(productColorModalText);
        String productColorModalTextLast = getLastText(productColorModalText, " ");
        if(productColorModalTextLast.equals(colorTest)) {
            System.out.println("colorTest on modal window pass");
        } else {
            System.out.println("colorTest on modal window fail");
        }

        //Sprawdzenie czy poprawna jest ilosc
        //Jak to przetestowac ?????? To czyta z local storage

        //PRAWA STRONA
        //Sprawdzenie poprawnosci ilosci rzeczy w koszyku
        String cartItemsTotalModalLocator = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[1]";
        WebElement cartItemsTotalModal = driver.findElement(By.xpath(cartItemsTotalModalLocator));
        String cartItemsTotalModalText = cartItemsTotalModal.getText();
        System.out.println(cartItemsTotalModalText);
        String cartItemsTotalModalTextWanted = getWantedText(cartItemsTotalModalText, " ", 2);
        System.out.println(cartItemsTotalModalTextWanted);
        if(cartItemsTotalTextWanted.equals(cartItemsTotalModalTextWanted)) {
            System.out.println("cartItemsTotalText on modal window is correct");
        } else {
            System.out.println("cartItemsTotalText on modal window is incorrect");
        }

        //Klikam na proceed to checkout
        WebElement proceedToCheckout = driver.findElement(By.xpath(proceedToCheckoutLocator));
        proceedToCheckout.click();
        Thread.sleep(2000);

        //Jestem na stronie karty
        //LEWA STRONA

        //Wybieram jeden produkt ze strony po nazwie oraz znajduje jego index
        String productTitlesCartLocator = "//*[@data-id_customization=\"0\"]";
        List<WebElement> productTitlesCart = driver.findElements(By.xpath(productTitlesCartLocator));
        System.out.println(productTitlesCart);
        int titleIndexCart = 0;
        for (int i = 0; i <productTitlesCart.size(); i++) {
            String singleProductNameInCart = productTitles.get(i).getText();
            if(singleProductNameInCart.toLowerCase().equals(productNameTest) ) {
                System.out.println("wybrany produkt w karcie" + singleProductNameInCart);
                titleIndexCart = i;
            }
        }


        //Sprawdzenie czy poprawna jest nazwa
        WebElement productNameCart = driver.findElement(By.xpath(productNameCartLocator));
        System.out.println(productNameCart);
        String productNameCartText = productNameCart.getText().toLowerCase();
        System.out.println(productNameCartText);
        if(productNameCartText.equals(productNameTest)) {
            System.out.println("productNameTest on cart page pass");
        } else {
            System.out.println("productNameTest on cart page fail");
        }

        //Sprawdzenie czy poprawna jest cena wysciowa pojedynczego produktu
        WebElement productPriceCart = driver.findElement(By.xpath(productPriceCartLocator));
        System.out.println(productPriceCart);
        String productPriceCartText = productPriceCart.getText();
        System.out.println("product price cart text " + productPriceCartText);
        if(priceEmbeded.equals(productPriceCartText)) {
            System.out.println("priceEmbeded on modal window correct");
        } else {
            System.out.println("priceEmbeded on modal window incorrect");
        }

        //Sprawdzenie czy poprawny jest rozmiar
//        WebElement productSizeCart = driver.findElement(By.cssSelector(productSizeCartLocator));
//        String productSizeCartText = productSizeModal.getText();
//        String productSizeCartTextLast = getLastText(productSizeModalText, " ");
//        System.out.println(productSizeCartTextLast);
////        String[] bits = productSizeModalText.split(" ");
////        String productSizeModalTextLast = bits[bits.length-1];
//        if(sizeTest.equals(productSizeCartTextLast)) {
//            System.out.println("sizeTest on modal window pass");
//        } else {
//            System.out.println("sizeTest on modal window fail");
//        }

        //Sprawdzenie czy poprawny jest color

        //Sprawdzenie czy poprawna jest ilosc

        //Sprawdzenie czy poprawan jest cena calkowita dla pojedynczego produktu


        //PRAWA STRONA
        //Sprwadzenie calkowitej iloci produktow
        //Sprawdzenie calkowitej ceny prze shipping
        //Sprawdzneie calkowitej ceny po shipping
    }


    public static String getLastText(String text, String separator) {
        String[] bits = text.split(separator);
        String lastText = bits[bits.length-1];
        return lastText;
    }

    public static String getWantedText(String text, String separator, int index) {
        String[] bits = text.split(separator);
        String wantedText = bits[index];
        return wantedText;
    }
}
