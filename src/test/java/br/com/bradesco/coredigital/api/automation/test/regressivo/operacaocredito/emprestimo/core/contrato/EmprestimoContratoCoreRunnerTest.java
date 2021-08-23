package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.emprestimo.core.contrato;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/emprestimo/core/contrato"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.core.contrato",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:contratoEmprestimoCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}

)
public class EmprestimoContratoCoreRunnerTest {

}
