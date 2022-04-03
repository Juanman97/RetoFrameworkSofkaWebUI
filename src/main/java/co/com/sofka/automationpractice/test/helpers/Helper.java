package co.com.sofka.automationpractice.test.helpers;

import co.com.sofka.automationpractice.test.model.contactus.ContactUsModel;
import co.com.sofka.automationpractice.test.model.shoppingcart.RegisterModel;
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
                faker
                        .name()
                        .username()
                        .concat(emailDom)
                        .replace(SPACE_STRING, EMPTY_STRING)
        );
        contactUsModel.setOrderRef(
                String.valueOf(
                        faker
                                .number()
                                .digits(EIGHT.getValue())));
        contactUsModel.setMessage(faker.lorem().sentence(TEN.getValue()));

        contactUsModel.setFilePath(FILE_PATH_BY_DEFAULT);
        contactUsModel.setSubject(SUBJECT_BY_DEFAULT);

        return contactUsModel;
    }

    public static RegisterModel generateRegisterModel(String language, String country, String emailDom) {
        Faker faker = Faker.instance(
                new Locale(language, country),
                new Random()
        );

        RegisterModel registerModel = new RegisterModel();

        registerModel.setEmail(
                faker
                        .name()
                        .username()
                        .concat(emailDom)
                        .replace(SPACE_STRING, EMPTY_STRING)
        );
        registerModel.setFirstName(faker.name().firstName());
        registerModel.setLastName(faker.name().lastName());
        registerModel.setPassword(
                String.valueOf(
                        faker
                                .number()
                                .digits(EIGHT.getValue())
        ));
        registerModel.setDayBirth(
                String.valueOf(
                        faker
                                .number()
                                .numberBetween(ONE.getValue(), TWENTY_EIGHT.getValue()))
        );
        registerModel.setMonthBirth(
                String.valueOf(
                        faker
                                .number()
                                .numberBetween(ONE.getValue(), TWELVE.getValue()))
        );
        registerModel.setYearBirth(
                String.valueOf(
                        faker
                                .number()
                                .numberBetween(NINETEEN_TWENTY_TWO.getValue(), TWO_THOUSAND_THREE.getValue()))
        );
        registerModel.setAddress(faker.address().fullAddress()
                .replace(QUESTION1_SIGN_STRING, EMPTY_STRING)
                .replace(QUESTION2_SIGN_STRING, EMPTY_STRING));
        registerModel.setCity(faker.address().city());
        registerModel.setZipCode(faker.address().zipCode());
        registerModel.setMobilePhone(
                String.valueOf(
                        faker
                                .number()
                                .numberBetween(THREE_ZEROES.getValue(), THREE_NINES.getValue())
                )
                        .concat(
                                String.valueOf(
                                        faker
                                                .number()
                                                .numberBetween(ONE.getValue(), NINE.getValue())
                                )
                        )
        );

        registerModel.setState(STATE_BY_DEFAULT_FLORIDA);
        registerModel.setCountry(COUNTRY_BY_DEFAULT_USA);
        return registerModel;
    }
}
