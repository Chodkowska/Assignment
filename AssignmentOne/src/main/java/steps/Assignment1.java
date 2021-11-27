package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.NewAddressPage;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;


public class Assignment1 {

    WebDriver driver;
    NewAddressPage newAddressPage;

    @Given("open https://mystore-testlab.coderslab.pl/")
    public void openPrestaShop(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/");

    }

    @When("sign in")
    public void signInPresta(){

        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a"));
        signInButton.click();
        WebElement fieldEmail = driver.findElement(By.name("email"));
        fieldEmail.sendKeys("ach@ach.pl");
        WebElement fieldPassword = driver.findElement(By.name("password"));
        fieldPassword.sendKeys("Ada12345");
        WebElement loginSignIn = driver.findElement(By.id("submit-login"));
        loginSignIn.click();
    }
    @And("open addresses page")
    public void addNewAddress(){
        WebElement addAddress = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/a[2]"));
        addAddress.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @And("fill in alias (.*)")
    public void inputAlias(String Alias){
        newAddressPage = new NewAddressPage(driver);
        NewAddressPage.aliasInput(Alias);
    }
    @And("fill in address (.*)")
    public void inputAddress1(String Address){
        NewAddressPage.address1Input(Address);
    }
    @And("fill in zip/postal code (.*)")
    public void inputZipPostalCode(String ZipPostalCode){
        NewAddressPage.postCodeInput(ZipPostalCode);
    }
    @And("fill in city (.*)")
    public void inputCity(String City){
        NewAddressPage.cityInput(City);
    }
    @And("fill in country (.*)")
    public void inputCountry(String Country){
        NewAddressPage.countryInput(Country);
    }
    @And("fill in phone (.*)")
    public void inputPhone(String Phone){
        NewAddressPage.phoneInput(Phone);
    }
    @And("save new address")
    public void saveAddress(){
        NewAddressPage.saveAddress();
    }

    @Then("add new address")
    public void addedAddress(){
        WebElement addedAddress = driver.findElement(By.id("notifications"));
        assertEquals("Address successfully added!", addedAddress.getText());
        System.out.println("Test completed successfully");
    }

    @And("quit browsing")
    public void shutDown(){
        driver.quit();
    }
}
