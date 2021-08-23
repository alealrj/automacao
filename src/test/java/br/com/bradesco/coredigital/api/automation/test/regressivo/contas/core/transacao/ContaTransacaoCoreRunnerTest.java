package br.com.bradesco.coredigital.api.automation.test.regressivo.contas.core.transacao;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/conta/core/transacao"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.conta.core.transacao",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:transacaoContaCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95064REV0.2.1, @TID95129REV0.2.1"}


)
public class ContaTransacaoCoreRunnerTest {
}
