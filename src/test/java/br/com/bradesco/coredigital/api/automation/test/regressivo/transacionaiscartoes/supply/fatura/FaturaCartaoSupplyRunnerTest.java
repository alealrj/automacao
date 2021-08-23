package br.com.bradesco.coredigital.api.automation.test.regressivo.transacionaiscartoes.supply.fatura;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/transacionalcartao/supply/fatura"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.supply.fatura",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:faturaCartaoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95035REV0.2.0, @TID95094REV0.2.0, @TID95146REV0.2.0"}

)
public class FaturaCartaoSupplyRunnerTest {

}
