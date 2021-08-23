package br.com.bradesco.coredigital.api.automation.test.regressivo.contas.core.lista;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/conta/core/lista"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.conta.core.lista",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:listaContaCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95057REV0.2.2, @TID95123REV0.2.2"}


)
public class ContaListaCoreRunnerTeste {
}
