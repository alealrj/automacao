package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.financiamento.cws.pagamentoempf;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/financiamento/cws/pagamentoempf"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.cws.pagamentoempf",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:pagamentoContratoFinanciamentoEmpfCwsRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}
)
public class FinanciamentoPagamentoEmpfCwsRunnerTest {

}
