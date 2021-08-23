package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.adiantamentodepositante.cws.pagamento;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/adiantamentodepositante/cws/pagamento"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.adiantamentodepositante.cws.pagamento",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:adiantamentoDepositantePagamentoRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID101731REV0.2.0, @TID102376REV0.2.0, @TID102378REV0.2.0"}
)
public class AdiantamentoDepositantePagamentoCwsRunnerTest {
}
