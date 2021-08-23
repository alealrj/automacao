package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.business.core.qualificacao.agora;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/business/core/qualificacao/agora"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.business.core.qualificacao.agora",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:pessoaQualificacaoBusinessAgoraCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID91987REV0.2.0"}

)
public class BusinessQualificationAgoraCoreRunnerTest {

}
