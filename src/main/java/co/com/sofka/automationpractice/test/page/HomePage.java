package co.com.sofka.automationpractice.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"contact-link\"]/a")
    WebElement contactUsBtn;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    WebElement signInBtn;

    public WebElement getContactUsBtn() {
        return contactUsBtn;
    }

    public WebElement getSignInBtn() {
        return signInBtn;
    }

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
