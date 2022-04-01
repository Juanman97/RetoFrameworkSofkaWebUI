package co.com.sofka.automationpractice.test.controllers.contactus;

import co.com.sofka.automationpractice.test.page.contactus.ContactUsPage;
import co.com.sofka.test.actions.WebAction;

import static co.com.sofka.automationpractice.test.helpers.Numbers.TWO;

public class MessageSentWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public boolean successfulSendingMessageDisplayed() {
        boolean messageDisplayed;
        ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

        messageDisplayed = webAction.isVisible(contactUsPage.getMessageSent(), TWO.getValue(), true);

        return messageDisplayed;
    }

    public boolean subjectMissingMessageDisplayed() {
        boolean messageDisplayed;
        ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());

        messageDisplayed = webAction.isVisible(contactUsPage.getSubjectMissingError(), TWO.getValue(), true);

        return messageDisplayed;
    }


}
