package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.pessoa.core.qualificacao.next;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/pessoa/core/qualificacao/next"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.core.qualificacao.next",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:pessoaQualificacaoNextCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID106961REV0.7.0"}

)
public class PessoaQualificacaoNextCoreRunnerTest {

}
