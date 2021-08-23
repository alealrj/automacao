package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.emprestimo.cws.contratoempg;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/emprestimo/cws/contratoempg"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.cws.contratoempg",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:contratoEmprestimoEmpgCwsRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}
)
public class EmprestimoContratoEmpgCwsRunnerTest {

}
