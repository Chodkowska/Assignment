package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAddressPage {

    private WebDriver driver;

    @FindBy(name = "alias")
    public static WebElement aliasInput;

    @FindBy(name = "address1")
    public static WebElement address1Input;

    @FindBy(name = "postcode")
    public static WebElement postCodeInput;

    @FindBy(name = "city")
    public static WebElement cityInput;

    @FindBy(name = "id_country")
    public static WebElement countryInput;

    @FindBy(name = "phone")
    public static WebElement phoneInput;

    @FindBy(className = "btn-primary")
    public static WebElement saveAddress;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public static void aliasInput(String Alias){
        aliasInput.sendKeys(Alias);
    }

    public static void address1Input(String Address) {
        address1Input.sendKeys(Address);
    }

    public static void postCodeInput(String ZipPostalCode){
        postCodeInput.sendKeys(ZipPostalCode);
    }

    public static void cityInput(String City){
        cityInput.sendKeys(City);
    }

    public static void countryInput(String Country){
        countryInput.sendKeys(Country);
    }

    public static void phoneInput(String Phone){
        phoneInput.sendKeys(Phone);
    }

    public static void saveAddress(){
        saveAddress.click();
    }
}
