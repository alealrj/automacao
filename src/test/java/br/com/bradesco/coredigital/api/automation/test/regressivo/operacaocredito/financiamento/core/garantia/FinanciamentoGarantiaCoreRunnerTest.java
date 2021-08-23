package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.financiamento.core.garantia;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/financiamento/core/garantia"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.core.garantia",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:garantiaContratoFinanciamentoCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID74682REV0.2.0, @TID74683REV0.2.0"}

)
public class FinanciamentoGarantiaCoreRunnerTest {

}
