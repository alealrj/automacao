package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.business.supply.relacionamento.bfinanciamento;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/business/supply/relacionamento/bfinanciamento"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.business.supply.relacionamento.bfinanciamento",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:businessRelationBfinanciamentoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID96025REV0.3.0"}

)
public class BusinessRelationBfinanciamentoSupplyRunnerTest {

}
