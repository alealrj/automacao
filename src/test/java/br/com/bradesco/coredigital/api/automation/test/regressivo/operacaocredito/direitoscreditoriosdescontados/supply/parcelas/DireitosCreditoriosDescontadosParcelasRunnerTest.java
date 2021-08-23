package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.direitoscreditoriosdescontados.supply.parcelas;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/direitoscreditoriosdescontados/supply/parcelas"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.direitoscreditoriosdescontados.supply.parcelas",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:direitosCreditoriosDescontadosParcelasRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95068REV0.4.0, @TID95114REV0.4.0, @TID95157REV0.4.0, @TID95164REV0.6.0, @TID108040REV0.2.0"}
)
public class DireitosCreditoriosDescontadosParcelasRunnerTest { }
