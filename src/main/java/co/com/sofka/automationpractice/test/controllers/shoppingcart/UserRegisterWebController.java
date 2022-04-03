package co.com.sofka.automationpractice.test.controllers.shoppingcart;

import co.com.sofka.automationpractice.test.model.shoppingcart.RegisterModel;
import co.com.sofka.automationpractice.test.page.shoppingcart.SignInPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.sofka.automationpractice.test.helpers.Dictionary.*;
import static co.com.sofka.automationpractice.test.helpers.Helper.generateRegisterModel;
import static co.com.sofka.automationpractice.test.helpers.Numbers.*;

public class UserRegisterWebController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void registerUser() {
        try {
            RegisterModel registerModel = generateRegisterModel(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
            SignInPage signInPage = new SignInPage(webAction.getDriver());

            webAction.sendText(signInPage.getEmail(), registerModel.getEmail(), true);
            webAction.click(signInPage.getCreateAccountBtn(), FIVE.getValue(), true);

            webAction.click(signInPage.getTitleMr(), TEN.getValue(), true);
            webAction.sendText(signInPage.getFirstName(), registerModel.getFirstName(), TWO.getValue(), true);
            webAction.sendText(signInPage.getLastName(), registerModel.getLastName(), TWO.getValue(), true);
            webAction.sendText(signInPage.getPassword(), registerModel.getPassword(), TWO.getValue(), true);

            webAction.selectByValue(signInPage.getDayBirth(), registerModel.getDayBirth(), TWO.getValue(), true);
            webAction.selectByValue(signInPage.getMonthBirth(), registerModel.getMonthBirth(), TWO.getValue(), true);
            webAction.selectByValue(signInPage.getYearBirth(), registerModel.getYearBirth(), TWO.getValue(), true);

            webAction.sendText(signInPage.getAddress(), registerModel.getAddress(), TWO.getValue(), true);
            webAction.sendText(signInPage.getCity(), registerModel.getCity(), TWO.getValue(), true);

            webAction.selectByPartialText(signInPage.getState(), registerModel.getState(), TWO.getValue(), true);

            webAction.sendText(signInPage.getPostCode(), registerModel.getZipCode(), TWO.getValue(), true);

            webAction.selectByPartialText(signInPage.getCountry(), registerModel.getCountry(), TWO.getValue(), true);

            webAction.sendText(signInPage.getPhoneMobile(), registerModel.getMobilePhone(), TWO.getValue(), true);

            webAction.click(signInPage.getRegisterBtn(), TWO.getValue(), true);
        } catch (WebActionsException e) {
            Report.reportFailure("Ocurrió un mensaje al registrar el usuario " + e);
        }
    }
}
