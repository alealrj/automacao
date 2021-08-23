package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.business.supply.qualificacao.bfinanciamento;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/business/supply/qualificacao/bfinanciamento"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.business.supply.qualificacao.bfinanciamento",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:businessQualificationBfinanciamentoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID96019REV0.4.0"}

)
public class BusinessQualificationBfinanciamentoSupplyRunnerTest {

}
