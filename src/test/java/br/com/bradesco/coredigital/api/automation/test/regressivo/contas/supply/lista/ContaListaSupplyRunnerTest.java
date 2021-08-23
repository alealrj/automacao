package br.com.bradesco.coredigital.api.automation.test.regressivo.contas.supply.lista;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/conta/supply/lista"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.conta.supply.lista",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:listaContaSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95124REV0.2.1, @TID95058REV0.2.1"}


)

public class ContaListaSupplyRunnerTest {
}
