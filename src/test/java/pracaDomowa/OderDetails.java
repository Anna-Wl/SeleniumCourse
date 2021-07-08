package pracaDomowa;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;
import java.util.Random;

class OrderDetails {
    public static void main(String[] args) throws InterruptedException {
        //Wartosci testowe dla produktu
        String productNameTestRaw = "Hummingbird Printed T-Shirt";
        String sizeTest = "M";
        String colorTest = "Black";
        String priceEmbeded = "";
        int numberOfItemsTest = 2;

        //Wartosci testowe lowercase
        String productNameTest = productNameTestRaw.toLowerCase();

        //Wartosci testowe do sekcji 1  - Personal Information
        String firstNameTest = "Jan";
        String lastNameTest = "Kowalski";
        String emailTest = "";
        String passwordTest = "pass123";
        String userBirthdayTest = "02/22/1998";

        //Wartosci testowe do sekcji 2 'Address'
        String companyNameTest = "ABC";
        String numberVATTest = " PL1234567890";
        String addressTest = "Polna 12";
        String zipPostalCodeTest = "88-100";
        String cityTest = "Warszawa";
        String countryTest = "United Kingdom";
        String phoneTest = "775-55-555";

        //Wartosci testowe do sekcji 3 'Shipping Method'
        String commentTest = "Black color please";

        //Losowy email address
        Random random = new Random();
        int randomInteger = random.nextInt(50); //losuje liczby z przedziału 0 - 49
        emailTest = "test" + randomInteger + "@test2.com";
        System.out.println(emailTest);


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

        //Wybieram ilosc
        WebElement qtyUpButton = driver.findElement(By.cssSelector(qtyUpButtonLocator));
        for(int i = 0; i < numberOfItemsTest-1 ; i++) {
            qtyUpButton.click();
        }

        //Dodaje do karty
        WebElement addToCart = driver.findElement(By.xpath(addToCartLocator));
        addToCart.click();
        Thread.sleep(2000);

        //Zapisuje w zmiennej calkowita ilosc produktow w koszyku
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

        //Sprawdzenie czy ilosc wybranych produktow jest zgodna z danymi testowymi
        String productQtyModalLocator = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p[2]";
        WebElement productQtyModal = driver.findElement(By.xpath(productQtyModalLocator));
        String productQtyModalText = productQtyModal.getText();
        System.out.println("QTY" + productQtyModal.getText());
        String productQtyModalTextLast =  getLastText(productQtyModalText, "");
        System.out.println(productQtyModalTextLast);
        int productQtyModalTextLastToNumber = Integer.parseInt(productQtyModalTextLast);
        if(productQtyModalTextLastToNumber == numberOfItemsTest) {
            System.out.println("Product qty correct");
        } else {
            System.out.println("Product qty incorrect");
        }

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

        //Jestem na stronie karty
        //LEWA STRONA
        //Wybieram jeden produkt ze strony po nazwie oraz znajduje jego index
        //Sprawdzam czy poprawna jest nazwa produktu
        String productTitlesCartLocator = "//*[@data-id_customization=\"0\"]";
        List<WebElement> productTitlesCart = driver.findElements(By.xpath(productTitlesCartLocator));
        System.out.println(productTitlesCart);
        int titleIndexCart = -1;
        for (int i = 0; i <productTitlesCart.size(); i++) {
            String singleProductNameInCart = productTitlesCart.get(i).getText();
            if(singleProductNameInCart.toLowerCase().equals(productNameTest) ) {
                System.out.println("wybrany produkt w karcie" + singleProductNameInCart);
                titleIndexCart = i;
                System.out.println("productNameTest on cart page pass");
            } else {
                System.out.println("productNameTest on cart page fail");
            }
        }
        System.out.println(titleIndexCart);


        //Sprawdzenie czy poprawna jest cena wyjsciowa pojedynczego produktu
        String productPriceCartLocator = "current-price";
        List<WebElement> productPriceCart = driver.findElements(By.className(productPriceCartLocator));
        int priceIndexCart = -1;
        for (int i = 0; i <productPriceCart.size(); i++) {
            String singleProductPriceInCart = productPriceCart.get(i).getText();
            System.out.println(singleProductPriceInCart);
            System.out.println(priceEmbeded);
            if(singleProductPriceInCart.equals(priceEmbeded) ) {
                System.out.println("wybrany produkt w karcie" + singleProductPriceInCart);
                priceIndexCart = i;
                System.out.println("productPriceTest on cart page pass");
            } else {
                System.out.println("productPriceTest on cart page fail");
            }
        }

        //Sprawdzenie czy poprawny jest rozmiar
        String productSizeCartLocators = "div:nth-child(4) > span.value";
        List<WebElement> productSizeCart = driver.findElements(By.cssSelector(productSizeCartLocators));
        System.out.println(productSizeCart);
        int sizeIndexCart = -1;
        for (int i = 0; i <productSizeCart.size(); i++) {
            String singleProductSizeInCart = productSizeCart.get(i).getText();
            System.out.println(singleProductSizeInCart);
            System.out.println(sizeTest);
            if(singleProductSizeInCart.equals(sizeTest) ) {
                System.out.println("wybrany produkt w karcie" + singleProductSizeInCart);
                sizeIndexCart = i;
                System.out.println("productSizeTest on cart page pass");
            } else {
                System.out.println("productSizeTest on cart page fail");
            }
        }

        //Sprawdzenie czy poprawny jest color

        //Sprawdzenie czy poprawna jest ilosc

        //Sprawdzenie czy poprawan jest cena calkowita dla pojedynczego produktu


        //PRAWA STRONA
        //Sprwadzenie calkowitej iloci produktow
        //Sprawdzenie calkowitej ceny przed shipping
        //Sprawdzneie calkowitej ceny po shipping


        //Klikniecie przycisku 'Proceed to checkout' na stronie Karty
        String proceedToCeckoutButtonCartLocator = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a";
        WebElement proceedToCeckoutButtonCart = driver.findElement(By.xpath(proceedToCeckoutButtonCartLocator));
        proceedToCeckoutButtonCart.click();

        //Jestem na stronie order details
        //Wypelniam Sekcja 1 - 'Personal Information Details' za pomoca danych testowych
        String socialTitleOrderLocator = "//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[1]/span/input";
        String firstNameOrderLocator = "//*[@id=\"customer-form\"]/section/div[2]/div[1]/input";
        String lastNameOrderLocator = "//*[@id=\"customer-form\"]/section/div[3]/div[1]/input";
        String emailOrderLocator = "//*[@id=\"customer-form\"]/section/div[4]/div[1]/input";
        String passwordOrderLocator = "//*[@id=\"customer-form\"]/section/div[5]/div[1]/div/input";
        String userBirthdayOrderLocator = "//*[@id=\"customer-form\"]/section/div[6]/div[1]/input";
        String receiveOffersCheckboxOrderLocator = "//*[@id=\"customer-form\"]/section/div[7]/div[1]/span/label/input";
        String signUpForNewsletterOrderLocator = "//*[@id=\"customer-form\"]/section/div[8]/div[1]/span/label/input";
        String continuePersolanInfoButtonOrderLocator = "//*[@id=\"customer-form\"]/footer/button";

        WebElement socialTitleOrder = driver.findElement(By.xpath(socialTitleOrderLocator));
        socialTitleOrder.click();
        WebElement firstNameOrder = driver.findElement(By.xpath(firstNameOrderLocator));
        firstNameOrder.sendKeys(firstNameTest);
        WebElement lastNameOrder = driver.findElement(By.xpath(lastNameOrderLocator));
        lastNameOrder.sendKeys(lastNameTest);
        WebElement emailOrder = driver.findElement(By.xpath(emailOrderLocator));
        emailOrder.sendKeys(emailTest);
        WebElement passwordOrder = driver.findElement(By.xpath(passwordOrderLocator));
        passwordOrder.sendKeys(passwordTest);
        WebElement userBirthdayOrder = driver.findElement(By.xpath(userBirthdayOrderLocator));
        userBirthdayOrder.sendKeys(userBirthdayTest);
        WebElement receiveOffersCheckboxOrder = driver.findElement(By.xpath(receiveOffersCheckboxOrderLocator));
        receiveOffersCheckboxOrder.click();
        WebElement signUpForNewsletterOrder = driver.findElement(By.xpath(signUpForNewsletterOrderLocator));
        signUpForNewsletterOrder.click();
        WebElement continuePersolanInfoButtonOrder = driver.findElement(By.xpath(continuePersolanInfoButtonOrderLocator));
        continuePersolanInfoButtonOrder.click();

        //Wypelniam Sekcja 2 - address details za pomoca danych testowych
        String companyOrderLocator = "//*[@id=\"delivery-address\"]/div/section/div[3]/div[1]/input";
        String numberVATOrderLocator = "//*[@id=\"delivery-address\"]/div/section/div[4]/div[1]/input";
        String addressOrderLocator = "//*[@id=\"delivery-address\"]/div/section/div[5]/div[1]/input";
        String zipPostalCodeOrderLocator = "//*[@id=\"delivery-address\"]/div/section/div[7]/div[1]/input";
        String cityOrderLocator = "//*[@id=\"delivery-address\"]/div/section/div[8]/div[1]/input";
        String countryOrderLocator = "//*[@id=\"delivery-address\"]/div/section/div[9]/div[1]/select";
        String phoneOrderLocator = "//*[@id=\"delivery-address\"]/div/section/div[10]/div[1]/input";
        String useThisAddressCheckboxOrderLocator = "#checkout-addresses-step div div form section div:nth-child(16) div input";
        String continueAddressButtonOrderLocator = "#checkout-addresses-step  div div form footer button";
        String cancelAddressButtonOrderLocator = "//*[@id=\"invoice-address\"]/div/footer/a";
        String continueAddressButtonSecondOrderLocator = "#checkout-addresses-step div div form div.clearfix button";
        String commentTextareaOrderLocator = "delivery_message";
        String continueShippingMethodButtonOrderLocator = "//*[@id=\"js-delivery\"]/button";
        String payByBankWireCheckboxOrderLocator = "//*[@id=\"payment-option-2-container\"]/label";
        String termsOfServiceCheckboxOrderLocator = "//*[@id=\"conditions_to_approve[terms-and-conditions]\"]";
        String orderWithAnObligationButtonOrderLocator = "//*[@id=\"payment-confirmation\"]/div[1]/button";

        WebElement companyOrder = driver.findElement(By.xpath(companyOrderLocator));
        companyOrder.sendKeys(companyNameTest);
        WebElement numberVATOrder = driver.findElement(By.xpath(numberVATOrderLocator));
        numberVATOrder.sendKeys(numberVATTest);
        WebElement addressOrder = driver.findElement(By.xpath(addressOrderLocator));
        addressOrder.sendKeys(addressTest);
        WebElement zipPostalCodeOrder = driver.findElement(By.xpath(zipPostalCodeOrderLocator));
        zipPostalCodeOrder.sendKeys(zipPostalCodeTest);
        WebElement cityOrder = driver.findElement(By.xpath(cityOrderLocator));
        cityOrder.sendKeys(cityTest);
        Select countryOrderSelect = new Select(driver.findElement(By.xpath(countryOrderLocator)));
        countryOrderSelect.selectByVisibleText(countryTest);
        WebElement phoneOrder = driver.findElement(By.xpath(phoneOrderLocator));
        phoneOrder.sendKeys(phoneTest);
        WebElement useThisAddressCheckboxOrder = driver.findElement(By.cssSelector(useThisAddressCheckboxOrderLocator));
        if(useThisAddressCheckboxOrder.isSelected()) {
            System.out.println("is selected");
            useThisAddressCheckboxOrder.click();
        } else {
            System.out.println("Keep checkbox unchecked");
        }
        WebElement continueAddressButtonOrder = driver.findElement(By.cssSelector(continueAddressButtonOrderLocator));
        continueAddressButtonOrder.click();
        WebElement cancelAddressButtonOrder =driver.findElement(By.xpath(cancelAddressButtonOrderLocator));
        cancelAddressButtonOrder.click();
        WebElement continueAddressButtonSecondOrder = driver.findElement(By.cssSelector(continueAddressButtonSecondOrderLocator));
        continueAddressButtonSecondOrder.click();

        //Jestem w Sekcji - Shipping Method

        WebElement commentTextareaOrder = driver.findElement(By.id(commentTextareaOrderLocator));
        commentTextareaOrder.sendKeys(commentTest);
        WebElement continueShippingMethodButtonOrder = driver.findElement(By.xpath(continueShippingMethodButtonOrderLocator));
        continueShippingMethodButtonOrder.click();

        //Jestem w Sekcji - Payment
        WebElement payByBankWireCheckbox = driver.findElement(By.xpath(payByBankWireCheckboxOrderLocator));
        payByBankWireCheckbox.click();
        WebElement termsOfServiceCheckboxOrder = driver.findElement(By.xpath(termsOfServiceCheckboxOrderLocator));
        WebElement orderWithAnObligationButtonOrder = driver.findElement(By.xpath(orderWithAnObligationButtonOrderLocator));

        if(!orderWithAnObligationButtonOrder.isEnabled()) {
            termsOfServiceCheckboxOrder.click();
            orderWithAnObligationButtonOrder.click();
        } else {
            System.out.println("niedziala order");
        }

        //Jestem na stronie 'Your Order is Confirmed'
        //Sprawdzenie czy jest poprawny image
        //Sprawdzenie czy jest poprawna nazwa
        //Sprawdzenie czy jest poprawny rozmiar
        //Sprawdzenie czy jest poprawny kolor
        //Sprawdzneie czy jest poprawna cena wyjsciowa produktu
        //Sprawdzenie czy jest poprawna ilosc danego produktu
        //Spradzenie czy jest poprawna calkowita cena dla produktu



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
