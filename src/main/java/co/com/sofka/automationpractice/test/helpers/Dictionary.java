package co.com.sofka.automationpractice.test.helpers;

import java.nio.file.Path;
import java.nio.file.Paths;

import static co.com.sofka.automationpractice.test.helpers.Subject.CUSTOMER_SERVICE;

// TODO: Aqui deberian ir constantes que puedan servir para el manejo del proyecto
public class Dictionary {
    public static final String STATE_BY_DEFAULT_FLORIDA = "Florida";
    public static final String COUNTRY_BY_DEFAULT_USA = "United States";
    public static final Subject SUBJECT_BY_DEFAULT = CUSTOMER_SERVICE;
    public static final Path FILE_PATH_BY_DEFAULT = Paths.get(System.getProperty("user.dir") + "/src/main/resources/files/testFile.txt");


    public static final String EMPTY_STRING = "";
    public static final String SPACE_STRING = " ";
    public static final String DOLLAR_SIGN_STRING = "$";
    public static final String QUESTION1_SIGN_STRING = "¿";
    public static final String QUESTION2_SIGN_STRING = "?";

    public static final String SPANISH_CODE_LANGUAGE = "es";
    public static final String COUNTRY_CODE = "MX";

    public static final String EMAIL_DOMAIN = "@sofkamail.com";

    public static final String FILE_EVIDENCE_PROPERTY = "files.evidence";
    public static final String APP_URL_PROPERTY = "app.url";

    private static final String PROPERTIES_FILE_BASE_PATH = "src/main/resources/properties/";

    public static final String CONFIGURATION_PROPERTIES_FILE = System.getProperty("user.dir") +
            "/" +
            PROPERTIES_FILE_BASE_PATH + "configuration.properties";

    public static final String MAIL_PROPERTIES_FILE = System.getProperty("user.dir") +
            "/" +
            PROPERTIES_FILE_BASE_PATH +"mail.properties";
}
