package co.com.sofka.automationpractice.test.page.contactus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    @CacheLookup
    @FindBy(id = "id_contact")
    WebElement subjectHeading;

    @CacheLookup
    @FindBy(id = "email")
    WebElement email;

    @CacheLookup
    @FindBy(id = "id_order")
    WebElement order;

    @CacheLookup
    @FindBy(id = "fileUpload")
    WebElement uploadFile;

    @CacheLookup
    @FindBy(id = "message")
    WebElement message;

    @CacheLookup
    @FindBy(id = "submitMessage")
    WebElement submitMessageBtn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p")
    WebElement messageSent;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol/li")
    WebElement subjectMissingError;

    public WebElement getSubjectHeading() {
        return subjectHeading;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getOrder() {
        return order;
    }

    public WebElement getUploadFile() {
        return uploadFile;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getSubmitMessageBtn() {
        return submitMessageBtn;
    }

    public WebElement getMessageSent() {
        return messageSent;
    }

    public WebElement getSubjectMissingError() {
        return subjectMissingError;
    }

    public ContactUsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
