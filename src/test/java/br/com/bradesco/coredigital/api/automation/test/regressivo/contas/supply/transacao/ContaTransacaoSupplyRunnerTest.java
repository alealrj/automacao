package br.com.bradesco.coredigital.api.automation.test.regressivo.contas.supply.transacao;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/conta/supply/transacao"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.conta.supply.transacao",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:transacaoContaSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95128REV0.2.2, @TID95063REV0.2.1"}



)
public class ContaTransacaoSupplyRunnerTest {
}
