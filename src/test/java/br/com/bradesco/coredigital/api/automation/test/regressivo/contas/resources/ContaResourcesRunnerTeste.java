package br.com.bradesco.coredigital.api.automation.test.regressivo.contas.resources;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(

        features = {"classpath:features/conta/resources"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.conta.resources",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:resourcesContaRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}

)
public class ContaResourcesRunnerTeste {
}
