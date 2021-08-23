package br.com.bradesco.coredigital.api.automation.test.regressivo.contas.cws.transacao;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/conta/cws/transacao"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.conta.cws.transacao",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:transacaoTypeContaCwsRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}

)
public class ContaTransacaoTypeCwsRunnerTeste {
}
