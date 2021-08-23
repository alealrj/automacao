package br.com.bradesco.coredigital.api.automation.test.regressivo.opcreditfinanciamento.supply.pagamento;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/financiamento/supply/pagamento"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.supply.pagamento",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:pagamentoContratoFinanciamentoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}
)
public class FinanciamentoPagamentoSupplyRunnerTest {

}
