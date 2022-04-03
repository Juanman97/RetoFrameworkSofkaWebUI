package co.com.sofka.automationpractice.test.page.shoppingcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    @CacheLookup
    @FindBy(id = "email_create")
    WebElement email;

    @CacheLookup
    @FindBy(id = "SubmitCreate")
    WebElement createAccountBtn;

    @CacheLookup
    @FindBy(id = "uniform-id_gender1")
    WebElement titleMr;

    @CacheLookup
    @FindBy(id = "uniform-id_gender2")
    WebElement titleMrs;

    @CacheLookup
    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "passwd")
    WebElement password;

    @CacheLookup
    @FindBy(id = "days")
    WebElement dayBirth;

    @CacheLookup
    @FindBy(id = "months")
    WebElement monthBirth;

    @CacheLookup
    @FindBy(id = "years")
    WebElement yearBirth;

    @CacheLookup
    @FindBy(id = "address1")
    WebElement address;

    @CacheLookup
    @FindBy(id = "city")
    WebElement city;

    @CacheLookup
    @FindBy(id = "id_state")
    WebElement state;

    @CacheLookup
    @FindBy(id = "postcode")
    WebElement postCode;

    @CacheLookup
    @FindBy(id = "id_country")
    WebElement country;

    @CacheLookup
    @FindBy(id = "phone_mobile")
    WebElement phoneMobile;

    @CacheLookup
    @FindBy(id = "submitAccount")
    WebElement registerBtn;

    public SignInPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getCreateAccountBtn() {
        return createAccountBtn;
    }

    public WebElement getTitleMr() {
        return titleMr;
    }

    public WebElement getTitleMrs() {
        return titleMrs;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getDayBirth() {
        return dayBirth;
    }

    public WebElement getMonthBirth() {
        return monthBirth;
    }

    public WebElement getYearBirth() {
        return yearBirth;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getPostCode() {
        return postCode;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getPhoneMobile() {
        return phoneMobile;
    }

    public WebElement getRegisterBtn() {
        return registerBtn;
    }
}
