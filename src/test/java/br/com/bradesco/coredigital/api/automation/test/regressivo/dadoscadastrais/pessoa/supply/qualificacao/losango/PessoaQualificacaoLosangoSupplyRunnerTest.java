package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.pessoa.supply.qualificacao.losango;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/pessoa/supply/qualificacao/losango"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.supply.qualificacao.losango",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:pessoaQualificacaoLosangoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID96089REV0.2.0"}

)
public class PessoaQualificacaoLosangoSupplyRunnerTest {

}
