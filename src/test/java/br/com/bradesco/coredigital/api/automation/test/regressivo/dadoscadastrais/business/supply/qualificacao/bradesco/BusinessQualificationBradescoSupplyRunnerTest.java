package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.business.supply.qualificacao.bradesco;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/business/supply/qualificacao/bradesco"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.business.supply.qualificacao.bradesco",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:businessQualificationBradescoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID99162REV0.3.0"}

)
public class BusinessQualificationBradescoSupplyRunnerTest {

}
