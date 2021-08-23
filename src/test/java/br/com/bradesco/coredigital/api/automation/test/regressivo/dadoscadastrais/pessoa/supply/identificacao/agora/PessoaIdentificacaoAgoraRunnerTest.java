package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.pessoa.supply.identificacao.agora;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/pessoa/supply/identificacao/agora"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.supply.identificacao.agora",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:pessoaIdentificacaoAgoraSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID91984REV0.2.0"}

)
public class PessoaIdentificacaoAgoraRunnerTest {

}
