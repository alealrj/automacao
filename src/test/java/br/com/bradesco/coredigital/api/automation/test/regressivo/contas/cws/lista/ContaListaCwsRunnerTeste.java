package br.com.bradesco.coredigital.api.automation.test.regressivo.contas.cws.lista;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/conta/cws/lista"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.conta.cws.lista",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:listaContaCwsRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95055REV0, @TID95122REV0"}
)
public class ContaListaCwsRunnerTeste {
}
