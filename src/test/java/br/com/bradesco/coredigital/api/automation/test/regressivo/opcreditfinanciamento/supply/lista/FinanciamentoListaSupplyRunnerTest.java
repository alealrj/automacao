package br.com.bradesco.coredigital.api.automation.test.regressivo.opcreditfinanciamento.supply.lista;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/financiamento/supply/lista"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.supply.lista",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:listaContratoFinanciamentoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}
//        tags = {"@TID71963REV0.2.0, @TID72879REV0.2.0"}

)
public class FinanciamentoListaSupplyRunnerTest {

}
