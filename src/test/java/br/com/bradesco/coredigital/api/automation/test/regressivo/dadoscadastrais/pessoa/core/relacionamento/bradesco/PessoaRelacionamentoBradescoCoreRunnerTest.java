package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.pessoa.core.relacionamento.bradesco;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/pessoa/core/relacionamento/bradesco"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.core.relacionamento.bradesco",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:pessoaRelacionamentoBradescoCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID100016REV0.3.0"}

)
public class PessoaRelacionamentoBradescoCoreRunnerTest {

}
