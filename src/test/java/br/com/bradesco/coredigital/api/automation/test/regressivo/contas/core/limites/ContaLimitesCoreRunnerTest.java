package br.com.bradesco.coredigital.api.automation.test.regressivo.contas.core.limites;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/conta/core/limite"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.conta.core.limites",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:limitesContaCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95053REV0.2.2, @TID95120REV0.2.2"}


)
public class ContaLimitesCoreRunnerTest {

}