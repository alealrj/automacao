package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.emprestimo.core.parcela;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/emprestimo/core/parcela"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.core.parcela",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:parcelaContratoEmprestimoCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}

)
public class EmprestimoParcelaCoreRunnerTest {

}
