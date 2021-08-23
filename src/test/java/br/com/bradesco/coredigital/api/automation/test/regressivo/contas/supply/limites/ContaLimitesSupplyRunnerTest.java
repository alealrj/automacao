package br.com.bradesco.coredigital.api.automation.test.regressivo.contas.supply.limites;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/conta/supply/limite"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.conta.supply.limites",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:limitesContaSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95121REV0.2.2, @TID95052REV0.2.2"}


)
public class ContaLimitesSupplyRunnerTest {

}
