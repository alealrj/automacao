package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.adiantamentodepositante.supply.pagamento;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/adiantamentodepositante/supply/pagamento"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.adiantamentodepositante.supply.pagamento",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:pagamentoAdiantamentoDepositanteSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95022REV0.2.0, @TID95081REV0.2.0, @TID95162REV0.3.0, @TID95155REV0.2.0, @TID108036REV0.2.0"}
)
public class AdiantamentoDepositantePagamentoSupplyRunnerTest {
}