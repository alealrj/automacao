package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.business.core.identificacao.agora;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/business/core/identificacao/agora"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.business.core.identificacao.agora",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:pessoaIdentificationBusinessAgoraCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID91979REV0.2.0"}

)
public class BusinessdentificationAgoraCoreRunnerTest {

}
