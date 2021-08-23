package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.emprestimo.supply.parcela;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/emprestimo/supply/parcela"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.supply.parcela",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:parcelaContratoEmprestimoSupplyRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}

)
public class EmprestimoParcelaSupplyRunnerTest {

}
