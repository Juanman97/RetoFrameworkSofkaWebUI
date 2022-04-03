package co.com.sofka.automationpractice.test.controllers.shoppingcart;

import co.com.sofka.automationpractice.test.page.shoppingcart.CartPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.sofka.automationpractice.test.helpers.Numbers.FIVE;

public class AddProductUnitWebController {
    WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void addProductUnit() {
        try {
            CartPage cartPage = new CartPage(webAction.getDriver());
            webAction.click(cartPage.getCartAddQuantity(), FIVE.getValue(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al sumar una unidad de producto " + e);
        }
    }
}
