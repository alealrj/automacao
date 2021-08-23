package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.business.supply.qualificacao.agora;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/business/supply/qualificacao/agora"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.business.supply.qualificacao.agora",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:businessQualificationAgoraSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID91988REV0.2.0"}

)
public class BusinessQualificationAgoraSupplyRunnerTest {

}
