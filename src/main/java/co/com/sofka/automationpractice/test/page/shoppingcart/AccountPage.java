package co.com.sofka.automationpractice.test.page.shoppingcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    WebElement dresses;

    public AccountPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getDresses() {
        return dresses;
    }
}
