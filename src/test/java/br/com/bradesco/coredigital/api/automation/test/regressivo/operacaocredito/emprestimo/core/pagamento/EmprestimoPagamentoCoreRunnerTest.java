package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.emprestimo.core.pagamento;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/emprestimo/core/pagamento"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.core.pagamento",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:pagamentoContratoEmprestimoCoreRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}

)
public class EmprestimoPagamentoCoreRunnerTest {

}
