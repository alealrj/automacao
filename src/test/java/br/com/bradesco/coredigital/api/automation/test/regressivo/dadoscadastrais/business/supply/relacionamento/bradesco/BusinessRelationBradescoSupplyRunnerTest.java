package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.business.supply.relacionamento.bradesco;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/business/supply/relacionamento/bradesco"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.business.supply.relacionamento.bradesco",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:businessRelationBradescoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID100017REV0.2.0"}

)
public class BusinessRelationBradescoSupplyRunnerTest {

}
