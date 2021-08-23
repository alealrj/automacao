package br.com.bradesco.coredigital.api.automation.test.regressivo.transacionaiscartoes.supply.transacaofatura;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/transacionalcartao/supply/transacaofatura"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.supply.transacaofatura",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:transacaoFaturaCartaoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95062REV0.3.0, @TID95111REV0.3.0, @TID95150REV0.2.0"}

)
public class TransacaoFaturaCartaoSupplyRunnerTest {

}
