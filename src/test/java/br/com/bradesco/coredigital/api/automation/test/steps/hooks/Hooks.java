package br.com.bradesco.coredigital.api.automation.test.steps.hooks;


import com.bradesco.core.report.BradescoReporter;
import com.bradesco.core.sdk.enums.ReportStatus;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void before(Scenario scenario) {

//        BradescoReporter.clear();
//        BradescoReporter.applyScenario(scenario);
    }

    @After
    public static void afterClass(Scenario scenario) {

//        if(scenario.isFailed()){
//            BradescoReporter.report(ReportStatus.ERROR, "Validação acima falhou!");
//        }
//
//        BradescoReporter.generateReport();
    }
}
