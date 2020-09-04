package net.diegoquirino.calculadora;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty","html:target/html-report","json:target/cucumber.json"},
        glue = "net.diegoquirino.calculadora.ux.passos.req001",
        features = "src/test/resources/features",
        tags = "@req001"
)
public class CucumberTestSuite {
}
