package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.pessoa.supply.identificacao.bfinanciamento;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/pessoa/supply/identificacao/bfinanciamento"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.supply.identificacao.bfinanciamento",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:pessoaIdentificacaoBradescoFinanciamentoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID109021REV0.2.0"}

)
public class PessoaIdentificacaoBradescoFinanciamentoRunnerTest {

}
