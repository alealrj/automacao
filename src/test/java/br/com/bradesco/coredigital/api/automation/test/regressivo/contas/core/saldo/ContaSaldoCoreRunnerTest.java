package br.com.bradesco.coredigital.api.automation.test.regressivo.contas.core.saldo;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/conta/core/saldo"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.conta.core.saldo",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:saldoContaCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95126REV0.2.2, @TID95060REV0.2.2"}

)
public class ContaSaldoCoreRunnerTest {

}