package br.com.bradesco.coredigital.api.automation.test.regressivo.operacaocredito.emprestimo.cws.listagran;

import com.hpe.alm.octane.OctaneCucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(OctaneCucumber.class)
@CucumberOptions(
        features = {"classpath:features/operacaocredito/emprestimo/cws/listagran"},
        glue = {"br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.cws.listagran",
                "br.com.bradesco.coredigital.api.automation.test.steps.hooks"},
        plugin = {"junit:listaGarantiaContratoEmprestimoGranCwsRegressivoResults.xml",
                "com.bradesco.report.CucumberReporterPlugin"}

)
public class EmprestimoListaGranCwsRunnerTest {

}
