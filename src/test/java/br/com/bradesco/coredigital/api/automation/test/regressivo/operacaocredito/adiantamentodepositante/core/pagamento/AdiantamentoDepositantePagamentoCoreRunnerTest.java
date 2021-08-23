package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.adiantamentodepositante.core.pagamento;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/adiantamentodepositante/core/pagamento"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.adiantamentodepositante.core.pagamento",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:adiantamentoDepositantePagamentoRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID102468REV0.2.0, @TID101836REV0.2.0, @TID102469REV0.2.0, @TID108042REV0.2.0"}
)
public class AdiantamentoDepositantePagamentoCoreRunnerTest {
}
