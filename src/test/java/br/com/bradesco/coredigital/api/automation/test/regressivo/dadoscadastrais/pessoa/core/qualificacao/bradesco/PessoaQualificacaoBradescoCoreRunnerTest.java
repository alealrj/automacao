package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.pessoa.core.qualificacao.bradesco;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/pessoa/core/qualificacao/bradesco"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.core.qualificacao.bradesco",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:pessoaQualificacaoBradescoCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID106962REV0.6.0"}

)
public class PessoaQualificacaoBradescoCoreRunnerTest {

}
