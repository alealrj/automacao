package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.financiamento.core.parcela;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/financiamento/core/parcela"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.core.parcela",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:parcelaContratoFinanciamentoCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}

)
public class FinanciamentoParcelaCoreRunnerTest {

}
