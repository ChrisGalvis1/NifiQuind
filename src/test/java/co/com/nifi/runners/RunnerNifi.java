package co.com.nifi.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "co.com.nifi.stepdefinition",
        plugin = {"pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunnerNifi {
}
