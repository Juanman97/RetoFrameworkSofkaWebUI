package co.com.sofka.automationpractice.test.page.shoppingcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(xpath = "(//td[@class=\"cart_description\"]/p[@class=\"product-name\"]/a)[1]")
    WebElement cartProductName;

    @FindBy(xpath = "(//td[@class=\"cart_unit\"]/span/span)[1]")
    WebElement cartProductUnitPrice;

    @FindBy(xpath = "(//a[@class=\"cart_quantity_up btn btn-default button-plus\"])[1]")
    WebElement cartAddQuantity;

    @FindBy(xpath = "(//td[@class=\"cart_total\"]/child::span)[1]")
    WebElement cartProductTotalPrice;

    public CartPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getCartProductName() {
        return cartProductName;
    }

    public WebElement getCartProductUnitPrice() {
        return cartProductUnitPrice;
    }

    public WebElement getCartAddQuantity() {
        return cartAddQuantity;
    }

    public WebElement getCartProductTotalPrice() {
        return cartProductTotalPrice;
    }
}
