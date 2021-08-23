package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.business.supply.identificacao.bradescard;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/business/supply/identificacao/bradescard"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.business.supply.identificacao.bradescard",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:businessIdentificationBradescardSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID91980REV0.2.0"}

)
public class BusinessIdentificationBradescardSupplyRunnerTest {

}
