package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.emprestimo.supply.contrato;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/emprestimo/supply/contrato"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.supply.contrato",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:contratoEmprestimoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}

)
public class EmprestimoContratoSupplyRunnerTest {

}
