package br.com.bradesco.coredigital.api.automation.test.regressivo.transacionaiscartoes.supply.limite;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/transacionalcartao/supply/limite"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.supply.limite",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:limiteCartaoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95054REV0.4.0, @TID95108REV0.3.0, @TID95148REV0.2.0"}

)
public class LimiteCartaoSupplyRunnerTest {

}
