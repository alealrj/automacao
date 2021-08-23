package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.pessoa.core.identificacao.next;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/pessoa/core/identificacao/next"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.core.identificacao.next",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:pessoaIdentificacaoCoreNextServiceRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID106960REV0.5.0"}

)
public class PessoaIdentificationServiceNextRunnerTest {

}
