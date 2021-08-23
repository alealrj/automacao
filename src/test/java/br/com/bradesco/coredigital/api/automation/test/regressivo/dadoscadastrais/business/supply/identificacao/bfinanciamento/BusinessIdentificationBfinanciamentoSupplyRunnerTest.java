package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.business.supply.identificacao.bfinanciamento;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/business/supply/identificacao/bfinanciamento"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.business.supply.identificacao.bfinanciamento",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:businessIdentificationBfinanciamentoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95671REV0.3.0"}

)
public class BusinessIdentificationBfinanciamentoSupplyRunnerTest {

}
