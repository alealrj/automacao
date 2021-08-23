package br.com.bradesco.coredigital.api.automation.test.regressivo.transacionaiscartoes.supply.transacao;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/transacionalcartao/supply/transacao"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.supply.transacao",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:transacaoCartaoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95066REV0.2.0, @TID95112REV0.2.0, @TID95150REV0.2.0"}

)
public class TransacaoCartaoSupplyRunnerTest {

}
