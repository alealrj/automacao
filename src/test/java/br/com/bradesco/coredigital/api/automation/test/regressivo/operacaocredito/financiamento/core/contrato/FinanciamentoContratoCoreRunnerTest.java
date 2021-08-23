package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.financiamento.core.contrato;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/financiamento/core/contrato"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.core.contrato",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:contratoFinanciamentoCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID72382REV0.2.0, @TID71456REV0.2.0"}

)
public class FinanciamentoContratoCoreRunnerTest {

}
