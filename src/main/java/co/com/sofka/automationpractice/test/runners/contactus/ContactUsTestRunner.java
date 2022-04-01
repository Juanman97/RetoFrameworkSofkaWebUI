package co.com.sofka.automationpractice.test.runners.contactus;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/main/resources/features/contactus/contactUs.feature"},
        glue = {"co.com.sofka.automationpractice.test.stepdefinition.contactus"},
        tags = "",
        publish = true
)
public class ContactUsTestRunner {
}
