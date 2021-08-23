package br.com.bradesco.coredigital.api.automation.test.regressivo.opcreditfinanciamento.supply.contrato;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/financiamento/supply/contrato"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.supply.contrato",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:contratoFinanciamentoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95038REV0.2.0, @TID99597REV0.2.0, @TID95097REV0.2.0, @TID98798REV0.3.0"}
)
public class FinanciamentoContratoSupplyRunnerTest {

}
