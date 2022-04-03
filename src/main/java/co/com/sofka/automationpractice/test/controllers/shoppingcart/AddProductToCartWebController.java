package co.com.sofka.automationpractice.test.controllers.shoppingcart;

import co.com.sofka.automationpractice.test.model.shoppingcart.ProductModel;
import co.com.sofka.automationpractice.test.page.shoppingcart.AccountPage;
import co.com.sofka.automationpractice.test.page.shoppingcart.ShoppingPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.sofka.automationpractice.test.helpers.Dictionary.DOLLAR_SIGN_STRING;
import static co.com.sofka.automationpractice.test.helpers.Dictionary.EMPTY_STRING;
import static co.com.sofka.automationpractice.test.helpers.Numbers.FIVE;
import static co.com.sofka.automationpractice.test.helpers.Numbers.TWO;

public class AddProductToCartWebController {
    private WebAction webAction;
    private ProductModel productModel;

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void addToCart() {
        try {
            productModel = new ProductModel();
            AccountPage accountPage = new AccountPage(webAction.getDriver());
            ShoppingPage shoppingPage = new ShoppingPage(webAction.getDriver());

            webAction.click(accountPage.getDresses(), FIVE.getValue(), true);

            webAction.moveTo(shoppingPage.getImgToHover(), FIVE.getValue(), true);
            webAction.click(shoppingPage.getMoreProductDetailsBtn(), FIVE.getValue(), true);

            productModel.setProductName(
                    webAction.getText(shoppingPage.getProductName(), FIVE.getValue(), true)
            );
            productModel.setProductUnitPrice(
                    Double.parseDouble(
                            webAction.getText(shoppingPage.getProductUnitPrice(), TWO.getValue(), true)
                                    .replace(DOLLAR_SIGN_STRING, EMPTY_STRING)
                    )
            );
            webAction.click(shoppingPage.getAddToCartBtn(), FIVE.getValue(), true);

            webAction.click(shoppingPage.getGoToCartBtn(), FIVE.getValue(), true);

        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al agregar un producto al carrito " + e);
        }
    }
}
