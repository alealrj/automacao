package br.com.bradesco.coredigital.api.automation.test.regressivo.transacionaiscartoes.supply.identificacao;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/transacionalcartao/supply/identificacao"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.supply.identificacao",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:identificacaoCartaoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95051REV0.3.0, @TID95107REV0.2.0, @TID95147REV0.2.0"}

)
public class IdentificacaoCartaoSupplyRunnerTest {

}
