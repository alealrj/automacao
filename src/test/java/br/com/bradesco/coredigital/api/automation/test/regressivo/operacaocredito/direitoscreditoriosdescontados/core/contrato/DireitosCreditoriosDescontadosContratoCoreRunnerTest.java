package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.direitoscreditoriosdescontados.core.contrato;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/direitoscreditoriosdescontados/core/contrato"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.direitoscreditoriosdescontados.core.contrato",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:direitorCreditoriosDescontadosContratoRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID97487REV0.2.0, @TID96950REV0.2.0, @TID107903REV0.3.0"}
)
public class DireitosCreditoriosDescontadosContratoCoreRunnerTest {
}
