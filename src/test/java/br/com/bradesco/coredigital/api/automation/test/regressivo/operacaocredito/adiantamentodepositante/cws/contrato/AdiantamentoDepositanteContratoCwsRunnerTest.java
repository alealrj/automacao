package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.adiantamentodepositante.cws.contrato;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/adiantamentodepositante/cws/contrato"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.adiantamentodepositante.cws.contrato",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:adiantamentoDepositanteContratoRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID96041REV0.3.1, @TID96042REV0.3.1, @TID95758REV0.3.0"}
)
public class AdiantamentoDepositanteContratoCwsRunnerTest {
}