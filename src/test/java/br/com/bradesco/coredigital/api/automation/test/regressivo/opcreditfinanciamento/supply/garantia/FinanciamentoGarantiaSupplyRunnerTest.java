package br.com.bradesco.coredigital.api.automation.test.regressivo.opcreditfinanciamento.supply.garantia;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/financiamento/supply/garantia"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.supply.garantia",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:garantiaContratoFinanciamentoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}

)
public class FinanciamentoGarantiaSupplyRunnerTest {

}
