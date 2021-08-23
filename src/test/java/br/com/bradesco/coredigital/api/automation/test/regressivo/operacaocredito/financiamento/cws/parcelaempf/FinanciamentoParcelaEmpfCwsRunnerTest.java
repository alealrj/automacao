package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.financiamento.cws.parcelaempf;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/financiamento/cws/parcelaempf"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.cws.parcelaempf",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:parcelaContratoFinanciamentoEmpfCwsRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID97474REV0.2.0, @TID97476REV0.2.0"}
)
public class FinanciamentoParcelaEmpfCwsRunnerTest {

}
