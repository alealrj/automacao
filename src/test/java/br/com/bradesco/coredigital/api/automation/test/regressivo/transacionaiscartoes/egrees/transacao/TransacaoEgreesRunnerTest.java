package br.com.bradesco.coredigital.api.automation.test.regressivo.transacionaiscartoes.egrees.transacao;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/transacionalcartao/egrees/transacao"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.egrees.transacao",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:transacaoEgreesRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95073REV0.2.0, @TID95132REV0.2.0"}

)
public class TransacaoEgreesRunnerTest {

}
