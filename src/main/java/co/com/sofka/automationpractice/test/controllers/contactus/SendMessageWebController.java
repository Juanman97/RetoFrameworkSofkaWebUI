package co.com.sofka.automationpractice.test.controllers.contactus;

import co.com.sofka.automationpractice.test.model.contactus.ContactUsModel;
import co.com.sofka.automationpractice.test.page.contactus.ContactUsPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.sofka.automationpractice.test.helpers.Dictionary.*;
import static co.com.sofka.automationpractice.test.helpers.Helper.generateContactUsModel;
import static co.com.sofka.automationpractice.test.helpers.Numbers.*;

public class SendMessageWebController {
    private WebAction webAction;
    private ContactUsModel contactUsModel;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void sendMessage(boolean failedMessage) {
        try {
            contactUsModel = generateContactUsModel(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

            if (!failedMessage) {
                webAction.selectByPartialText(contactUsPage.getSubjectHeading(),
                        contactUsModel.getSubject().getValue(), TWO.getValue(), false);
            }
            webAction.sendText(contactUsPage.getEmail(), contactUsModel.getEmail(), TWO.getValue(), false);
            webAction.sendText(contactUsPage.getOrder(), contactUsModel.getOrderRef(), TWO.getValue(), false);
            webAction.sendText(contactUsPage.getMessage(), contactUsModel.getMessage(), TWO.getValue(), true);

            webAction.uploadFile(contactUsPage.getUploadFile(), contactUsModel.getFilePath(), true);

            webAction.click(contactUsPage.getSubmitMessageBtn(), TWO.getValue(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un error al intentar enviar el mensaje " + e);
        }
    }
}
