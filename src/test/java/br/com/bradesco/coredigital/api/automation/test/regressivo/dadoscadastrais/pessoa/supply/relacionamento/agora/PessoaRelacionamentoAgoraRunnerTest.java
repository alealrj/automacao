package br.com.bradesco.coredigital.api.automation.test.regressivo.dadoscadastrais.pessoa.supply.relacionamento.agora;


import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/dadoscadastrais/pessoa/supply/relacionamento/agora"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.supply.relacionamento.agora",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:pessoaRelacionamentoSupplyAgoraRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95001REV0.2.0"}

)

public class PessoaRelacionamentoAgoraRunnerTest {
}
