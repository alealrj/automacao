package br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.business.supply.relacionamento.agora;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.supply.businessrelation.BusinessRelationSupply;
import br.com.bradesco.coredigital.api.automation.service.FornecimentoService;
import br.com.bradesco.coredigital.api.automation.test.steps.AbstractStepDefinition;
import com.bradesco.core.report.BradescoReporter;
import com.bradesco.core.sdk.enums.ReportStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static com.bradesco.core.report.Assert.assertEquals;
import static com.bradesco.core.report.Assert.assertTrue;

public class BusinessRelationAgoraSupplyStepsDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseObject<BusinessRelationSupply> relacionamentoAgoraJuridica;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/business/financialrelation/";

    private final String JSON_SUPPLY_SCHEMA_NAME = "business_relation_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/business/financialrelation/";

    private final String JSON_SUPPLY_DATA_NAME = "business_relation_supply_agora_data";

    private final String URL_BUSINESS_RELACIONAMENTO_SUPPLY_AGORA = "/agora/customers/v1/business/financial-relations";

    @Given("seja realizada uma requisição GET no endpoint de relacionamento Pessoa Jurídica")
    public void seja_realizada_uma_requisição_GET_no_endpoint_de_relacionamento_Pessoa_Jurídica() {

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdGF0dXMiOiJBQ1RJVkUiLCJpc3MiOiJicmFkZXNjby1vYiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImV4cCI6MTQzMjE0MzIxNDMyLCJpYXQiOjU0MzIxNDUzMjEzNCwibmJmIjo0MzIxNDMyNDMyMTQsImtpZCI6IjQ3ODM5MjE3NDg5MjMiLCJqdGkiOjM0MjM0MzI1NDM0Mywic3ViIjoiY3BmLTR1M2kyMDI0ODkwMiIsInNjcCI6Im9wZW5pZCBhY2NvdW50cyBjcmVkaXQtY2FyZHMtYWNjb3VudHMiLCJjZXJ0aWZpY2F0ZS1kbiI6IkNOPVF1aWNrYm9va3MgUHJvLCBPVT1RdWlja2Jvb2tzIFByb2QsIE89SW50dWl0LCBDPUJSIiwiY29uc2VudC5kYXRhIjp7ImNvbnNlbnRJRCI6Ijk5OTk5OCIsImNsaWVudElkIjoiSXRhdSIsInBlcm1pc3Npb25zIjpbIkNVU1RPTUVSU19QRVJTT05BTF9BRElUVElPTkFMSU5GT19SRUFEIl19LCJ1c2VyLmluZm8iOnsidXNlcklkIjoiIiwiYnVzaW5lc3NJZCI6IjQ5MDg2NTY0MDAwMTg4In19.PesBiLuwUNokdYobrr01l_IUzMoA41Dr4z3IkuUL6XU");

        relacionamentoAgoraJuridica = fornecimentoService.getResponseObject(ProjectType.REGISTRATION_DATA_AGORA_SUPPLY,
                ROOT_JSON_DATA_PATH, JSON_SUPPLY_DATA_NAME, getHeaders(headerMap),
                BusinessRelationSupply.class, URL_BUSINESS_RELACIONAMENTO_SUPPLY_AGORA);

        printJsonBradescoReport(relacionamentoAgoraJuridica);
        BradescoReporter.report(ReportStatus.PASSED, "Get realizado com sucesso");
    }

    @Then("usuario deve receber os status code (\\d+)")
    public void usuario_deve_receber_os_status_code(int statusCode) {

        assertEquals(statusCode, relacionamentoAgoraJuridica.getHttpCode());
        BradescoReporter.report(ReportStatus.PASSED, "Status code validado com sucesso");
    }

    @Then("o retorno das requisicões deve estar de acordo com contrato definido")
    public void o_retorno_das_requisicões_deve_estar_de_acordo_com_contrato_definido() {

        boolean validResponse = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_SUPPLY_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_SUPPLY_SCHEMA_NAME);
        assertTrue(validResponse);
        BradescoReporter.report(ReportStatus.PASSED, "Contrato validado com sucesso");
    }
}
