package co.com.sofka.automationpractice.test.page.shoppingcart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
    WebElement imgToHover;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[2]")
    WebElement moreProductDetailsBtn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div/div[3]/h1")
    WebElement productName;

    @FindBy(id = "our_price_display")
    WebElement productUnitPrice;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
    WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement goToCartBtn;

    public ShoppingPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getImgToHover() {
        return imgToHover;
    }

    public WebElement getMoreProductDetailsBtn() {
        return moreProductDetailsBtn;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductUnitPrice() {
        return productUnitPrice;
    }

    public WebElement getAddToCartBtn() {
        return addToCartBtn;
    }

    public WebElement getGoToCartBtn() {
        return goToCartBtn;
    }
}
