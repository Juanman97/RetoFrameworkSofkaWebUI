package co.com.sofka.automationpractice.test.model.contactus;

import co.com.sofka.automationpractice.test.helpers.Subject;

import java.nio.file.Path;

public class ContactUsModel {
    private Subject subject;
    private String email;
    private String orderRef;
    private String message;
    private Path filePath;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Path getFilePath() {
        return filePath;
    }

    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }
}
