package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.pessoa.supply.qualificacao.bradesco;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/pessoa/supply/qualificacao/bradesco"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.supply.qualificacao.bradesco",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:pessoaQualificacaoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID91994REV0.2.0"}

)
public class PessoaQualificacaoSupplyRunnerTest {

}
