package co.com.sofka.automationpractice.test.controllers.shoppingcart;

import co.com.sofka.automationpractice.test.page.HomePage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.sofka.automationpractice.test.helpers.Numbers.FIVE;

public class SignInWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void goToSignInPage() {
        try {
            HomePage homePage = new HomePage(webAction.getDriver());

            webAction.click(homePage.getSignInBtn(), FIVE.getValue(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al navegar hacia la página de signIn " + e);
        }
    }
}
