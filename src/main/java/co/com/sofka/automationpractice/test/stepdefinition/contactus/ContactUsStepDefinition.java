package co.com.sofka.automationpractice.test.stepdefinition.contactus;

import co.com.sofka.automationpractice.test.controllers.contactus.ContactUsWebController;
import co.com.sofka.automationpractice.test.controllers.contactus.MessageSentWebController;
import co.com.sofka.automationpractice.test.controllers.contactus.SendMessageWebController;
import co.com.sofka.automationpractice.test.controllers.openwebpage.StartBrowserWebController;
import co.com.sofka.automationpractice.test.data.objects.TestInfo;
import co.com.sofka.automationpractice.test.stepdefinition.Setup;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class ContactUsStepDefinition extends Setup {
    private WebAction webAction;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("que el usuario se encuentra en la pagina de contact us")
    public void queElUsuarioSeEncuentraEnLaPaginaDeContactUs() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeatue(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();
    }
    @Cuando("el usuario envia un mensaje llenando todos los campos")
    public void elUsuarioEnviaUnMensajeLlenandoTodosLosCampos() {
        ContactUsWebController contactUsWebController = new ContactUsWebController();
        contactUsWebController.setWebAction(webAction);
        contactUsWebController.goToContactUsPage();

        SendMessageWebController sendMessageWebController = new SendMessageWebController();
        sendMessageWebController.setWebAction(webAction);
        sendMessageWebController.sendMessage(false);
    }
    @Entonces("el sistema mostara un mensaje de envio exitoso")
    public void elSistemaMostaraUnMensajeDeEnvioExitoso() {
        MessageSentWebController messageSentWebController = new MessageSentWebController();
        messageSentWebController.setWebAction(webAction);

        Assert
                .Hard
                .thatBoolean(messageSentWebController.successfulSendingMessageDisplayed())
                .isTrue();
    }
    @Cuando("el usuario intenta enviar un mensaje sin seleccionar un tema")
    public void elUsuarioIntentaEnviarUnMensajeSinSeleccionarUnTema() {
        ContactUsWebController contactUsWebController = new ContactUsWebController();
        contactUsWebController.setWebAction(webAction);
        contactUsWebController.goToContactUsPage();

        SendMessageWebController sendMessageWebController = new SendMessageWebController();
        sendMessageWebController.setWebAction(webAction);
        sendMessageWebController.sendMessage(true);
    }
    @Entonces("el sistema mostrara un mensaje de error")
    public void elSistemaMostraraUnMensajeDeError() {
        MessageSentWebController messageSentWebController = new MessageSentWebController();
        messageSentWebController.setWebAction(webAction);

        Assert
                .Hard
                .thatBoolean(messageSentWebController.subjectMissingMessageDisplayed())
                .isTrue();
    }

    @After
    public void cerrarDriver() {
        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
