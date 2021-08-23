package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.adiantamentodepositante.cws.lista;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/adiantamentodepositante/cws/lista"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.adiantamentodepositante.cws.lista",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:adiantamentoDepositanteListaRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID96149REV0.3.0, @TID95860REV0.3.0, @TID95861REV0.3.0"}
)
public class AdiantamentoDepositanteListaCwsRunnerTest {
}
