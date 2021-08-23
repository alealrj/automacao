package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.emprestimo.core.garantia;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/emprestimo/core/garantia"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.core.garantia",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:garantiaContratoEmprestimoCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}
)

public class EmprestimoGarantiaCoreRunnerTest {

}
