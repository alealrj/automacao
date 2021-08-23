package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.business.supply.qualificacao.bradescard;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/business/supply/qualificacao/bradescard"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.business.supply.qualificacao.bradescard",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:businessQualificationBradescardSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID91989REV0.2.0"}

)
public class BusinessQualificationBradescardSupplyRunnerTest {

}
