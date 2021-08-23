package br.com.bradesco.coredigital.api.automation.test.regressivo.transacionaiscartoes.egrees.identificacao;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/transacionalcartao/egrees/identificacao"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.egrees.identificacao",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:identificacaoEgreesRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95073REV0.2.0, @TID95132REV0.2.0"}

)
public class IdentificacaoEgreesRunnerTest {

}
