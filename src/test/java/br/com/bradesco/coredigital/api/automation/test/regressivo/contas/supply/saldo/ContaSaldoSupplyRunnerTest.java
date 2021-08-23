package br.com.bradesco.coredigital.api.automation.test.regressivo.contas.supply.saldo;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/conta/supply/saldo"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.conta.supply.saldo",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:saldoContaSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95127REV0.2.2, @TID95061REV0.2.2"}

)
public class ContaSaldoSupplyRunnerTest {

}
