package br.com.bradesco.coredigital.api.automation.test.regressivo.transacionaiscartoes.supply.lista;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/transacionalcartao/supply/lista"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.supply.lista",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:listaCartaoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95056REV0.4.0, @TID95109REV0.4.0, @TID95149REV0.2.0"}

)
public class ListaCartaoSupplyRunnerTest {

}
