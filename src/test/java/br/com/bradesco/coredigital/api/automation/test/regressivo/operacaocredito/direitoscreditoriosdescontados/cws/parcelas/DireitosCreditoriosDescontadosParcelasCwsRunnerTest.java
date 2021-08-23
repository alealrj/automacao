package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.direitoscreditoriosdescontados.cws.parcelas;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/direitoscreditoriosdescontados/cws/parcelas"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.direitoscreditoriosdescontados.cws.parcelas",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:direitorCreditoriosDescontadosParcelasRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID100202REV0.2.0, @TID100203REV0.2.0, @TID100204REV0.2.0"}
)
public class DireitosCreditoriosDescontadosParcelasCwsRunnerTest {
}
