package co.com.sofka.automationpractice.test.page;


import co.com.sofka.automationpractice.test.internalaction.InternalActionWeb;
import org.openqa.selenium.support.PageFactory;


// Implementación del patron PageFactory y PageObject
public class PageDefinition {

    private static final int DEFAULT_TIMEOUT = 30;
    private InternalActionWeb internalActionWeb;

    public PageDefinition(InternalActionWeb internalActionWeb) {
        PageFactory.initElements(internalActionWeb.getDriver(), this);
        this.internalActionWeb = internalActionWeb;
    }

}
