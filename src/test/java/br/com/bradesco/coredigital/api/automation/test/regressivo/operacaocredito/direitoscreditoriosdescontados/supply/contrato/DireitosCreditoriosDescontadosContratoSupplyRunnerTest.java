package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.direitoscreditoriosdescontados.supply.contrato;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/direitoscreditoriosdescontados/supply/contrato"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.direitoscreditoriosdescontados.supply.contrato",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:direitosCreditoriosDescontadosContratoRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95067REV0.2.0, @TID95113REV0.2.0, @TID95163REV0.4.0, @TID95156REV0.2.0, @TID108039REV0.2.0"}
)
public class DireitosCreditoriosDescontadosContratoSupplyRunnerTest { }