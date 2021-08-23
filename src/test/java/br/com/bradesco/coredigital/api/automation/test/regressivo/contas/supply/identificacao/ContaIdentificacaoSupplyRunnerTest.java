package br.com.bradesco.coredigital.api.automation.test.regressivo.contas.supply.identificacao;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/conta/supply/identificacao"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.conta.supply.identificacao",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:identificacaoContaSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95050REV0.4.2, @TID95119REV0.3.1"}

)
public class ContaIdentificacaoSupplyRunnerTest {
}
