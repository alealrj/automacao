package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.emprestimo.cws.listaempg;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/emprestimo/cws/listaempg"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.cws.listaempg",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:listaContratoEmprestimoEmpgCwsRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}
)
public class EmprestimoListaEmpgCwsRunnerTest {

}
