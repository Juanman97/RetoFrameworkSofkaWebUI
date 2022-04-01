package co.com.sofka.automationpractice.test.controllers.contactus;

import co.com.sofka.automationpractice.test.page.HomePage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.sofka.automationpractice.test.helpers.Numbers.*;

public class ContactUsWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void goToContactUsPage() {
        try {
            HomePage homePage = new HomePage(webAction.getDriver());

            webAction.click(homePage.getContactUsBtn(), FIVE.getValue(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al abrir la página de contact us " + e);
        }
    }
}
