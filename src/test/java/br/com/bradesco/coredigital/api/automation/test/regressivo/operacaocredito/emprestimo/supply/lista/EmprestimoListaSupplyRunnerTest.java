package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.emprestimo.supply.lista;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/emprestimo/supply/lista"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.supply.lista",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:listaContratoEmprestimoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}

)
public class EmprestimoListaSupplyRunnerTest {

}
