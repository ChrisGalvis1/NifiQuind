package co.com.nifi.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "co.com.nifi.stepdefinition",
        plugin = {"pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunnerNifi {
}
