package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.emprestimo.supply.garantia;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/emprestimo/supply/garantia"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.supply.garantia",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:garantiaContratoEmprestimoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}
)

public class EmprestimoGarantiaSupplyRunnerTest {

}
