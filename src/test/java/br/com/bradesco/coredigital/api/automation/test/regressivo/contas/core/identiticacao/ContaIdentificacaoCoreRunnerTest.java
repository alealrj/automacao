package br.com.bradesco.coredigital.api.automation.test.regressivo.contas.core.identiticacao;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/conta/core/identificacao"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.conta.core.identificacao",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:identificacaoContaCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95048REV0.2.2.1, @TID95117REV0.2.2"}

)
public class ContaIdentificacaoCoreRunnerTest {
}
