package br.com.bradesco.coredigital.api.automation.test.regressivo.transacionaiscartoes.egrees.fatura;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/transacionalcartao/egrees/fatura"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.egrees.fatura",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:faturaEgreesRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"},
        tags = {"@TID95072REV0.2.0, @TID95131REV0.2.0"}

)
public class FaturaEgreesRunnerTest {

}
