package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.emprestimo.cws.listaches;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/emprestimo/cws/listaches"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.cws.listaches",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:listaContratoEmprestimoChesCwsRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}

)
public class EmprestimoListaChesCwsRunnerTest {

}
