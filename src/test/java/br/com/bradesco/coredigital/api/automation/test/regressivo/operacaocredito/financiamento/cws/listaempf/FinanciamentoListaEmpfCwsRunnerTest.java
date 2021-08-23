package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.financiamento.cws.listaempf;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/financiamento/cws/listaempf"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.cws.listaempf",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:listaContratoFinanciamentoEmpfCwsRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}

)
public class FinanciamentoListaEmpfCwsRunnerTest {

}
