package co.com.sofka.runner;

import co.com.sofka.setup.WebUI;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/practice_form.feature"},
        glue ={"co.com.sofka.StepDefinition"},
        tags = "not @ignore",
        publish = true
)

public class PracticeFormTestCucumber {
}
