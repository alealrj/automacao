package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.preconsentimento;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/preconsentimento"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.preconsentimento",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:preConsentimentoOperacaoCreditoRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}

)
public class OperacaoCreditoPreConsentimentoCoreRunnerTest {

}
