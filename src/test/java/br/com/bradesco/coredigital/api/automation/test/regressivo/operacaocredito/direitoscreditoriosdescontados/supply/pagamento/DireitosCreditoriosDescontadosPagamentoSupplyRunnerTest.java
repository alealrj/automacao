package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.direitoscreditoriosdescontados.supply.pagamento;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/direitoscreditoriosdescontados/supply/pagamento"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.direitoscreditoriosdescontados.supply.pagamento",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:direitosCreditoriosDescontadosPagamentoRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95070REV0.2.0, @TID95116REV0.2.0, @TID95159REV0.2.0, @TID95165REV0.2.0, @TID108041REV0.2.0"}
)
public class DireitosCreditoriosDescontadosPagamentoSupplyRunnerTest {
}
