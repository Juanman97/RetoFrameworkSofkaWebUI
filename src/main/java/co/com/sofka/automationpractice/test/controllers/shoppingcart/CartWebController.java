package co.com.sofka.automationpractice.test.controllers.shoppingcart;

import co.com.sofka.automationpractice.test.model.shoppingcart.ProductModel;
import co.com.sofka.automationpractice.test.page.shoppingcart.CartPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.sofka.automationpractice.test.helpers.Dictionary.DOLLAR_SIGN_STRING;
import static co.com.sofka.automationpractice.test.helpers.Dictionary.EMPTY_STRING;
import static co.com.sofka.automationpractice.test.helpers.Numbers.TWO;

public class CartWebController {
    private WebAction webAction;
    private ProductModel cartProductModel;

    public ProductModel getCartProductModel() {
        return cartProductModel;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void getCartProductInfo() {
        try {
            CartPage cartPage = new CartPage(webAction.getDriver());
            cartProductModel = new ProductModel();

            webAction.pause(TWO.getValue(), true);
            cartProductModel.setProductName(
                    webAction.getText(cartPage.getCartProductName(), TWO.getValue(), true)
            );
            cartProductModel.setProductUnitPrice(
                    Double.parseDouble(
                            webAction.getText(cartPage.getCartProductUnitPrice(), TWO.getValue(), true)
                                    .replace(DOLLAR_SIGN_STRING, EMPTY_STRING)
                    )
            );
            cartProductModel.setProductTotalPrice(
                    Double.parseDouble(
                            webAction.getText(cartPage.getCartProductTotalPrice(), TWO.getValue(), true)
                                    .replace(DOLLAR_SIGN_STRING, EMPTY_STRING)
                    )
            );
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al obtener la información del producto en el carrito " + e);
        }
    }
}
