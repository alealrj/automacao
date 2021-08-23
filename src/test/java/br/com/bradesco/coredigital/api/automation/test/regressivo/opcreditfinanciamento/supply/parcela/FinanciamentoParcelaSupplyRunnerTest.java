package br.com.bradesco.coredigital.api.automation.test.regressivo.opcreditfinanciamento.supply.parcela;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/financiamento/supply/parcela"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.supply.parcela",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:parcelaContratoFinanciamentoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}
//        tags = {"@TID95106REV0.2.0, @TID95047REV0.2.0"}

)
public class FinanciamentoParcelaSupplyRunnerTest {

}
