package co.com.sofka.automationpractice.test.helpers;

import co.com.sofka.automationpractice.test.model.contactus.ContactUsModel;
import co.com.sofka.test.evidence.reports.Report;
import com.github.javafaker.Faker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import static co.com.sofka.automationpractice.test.helpers.Dictionary.*;
import static co.com.sofka.automationpractice.test.helpers.Numbers.*;

public class Helper {

    public static String getProperty(String property) {
        Properties properties = new Properties();

        try (FileReader fileReader = new FileReader(CONFIGURATION_PROPERTIES_FILE)) {
            properties.load(fileReader);
        } catch (IOException e) {
            Report.reportFailure("Fallo al consultar una propiedad del archivo "
                    + CONFIGURATION_PROPERTIES_FILE, e);
        }

        return properties.getProperty(property);
    }

    public static ContactUsModel generateContactUsModel(String language, String country, String emailDom) {
        Faker faker = Faker.instance(
                new Locale(language, country),
                new Random()
        );

        ContactUsModel contactUsModel = new ContactUsModel();
        contactUsModel.setEmail(
                faker.name()
                .username()
                .concat(emailDom)
                .replace(SPACE_STRING, EMPTY_STRING)
        );
        contactUsModel.setOrderRef(String.valueOf(faker.number().digits(EIGHT.getValue())));
        contactUsModel.setMessage(faker.lorem().sentence(TEN.getValue()));

        contactUsModel.setFilePath(FILE_PATH_BY_DEFAULT);
        contactUsModel.setSubject(SUBJECT_BY_DEFAULT);

        return contactUsModel;
    }
}
