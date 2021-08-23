package br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.supply.relacionamento.bfinanciamento;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.supply.personalcustomerrelation.PersonalCustomerRelationSupply;
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

public class PessoaRelacionamentoSupplyBradescoFinanciamentoStepDefinitions extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseObject<PersonalCustomerRelationSupply> relacionamentoPessoaBradescoFinanciamento;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/personal/financialrelation/";

    private final String JSON_SUPPLY_SCHEMA_NAME = "personal_relation_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/personal/financialrelation/";

    private final String JSON_SUPPLY_BRADESCOFINANCIAMENTO_DATA_NAME = "personal_relation_supply_bradescofinanciamento_data";

    private final String URL_PESSOAL_RELACIONAMENTO_SUPPLY_BRADESCOFINANCIAMENTO = "/bradesco_financiamento/customers/v1/personal/financial-relations";

    @Given("seja realizada uma requisição GET no endpoint de relacionamento Pessoa Natural")
    public void seja_realizada_uma_requisição_GET_no_endpoint_de_relacionamento_Pessoa_Natural() {

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdGF0dXMiOiJBQ1RJVkUiLCJpc3MiOiJicmFkZXNjby1vYiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImV4cCI6MTQzMjE0MzIxNDMyLCJpYXQiOjU0MzIxNDUzMjEzNCwibmJmIjo0MzIxNDMyNDMyMTQsImtpZCI6IjQ3ODM5MjE3NDg5MjMiLCJqdGkiOjM0MjM0MzI1NDM0Mywic3ViIjoiY3BmLTR1M2kyMDI0ODkwMiIsInNjcCI6Im9wZW5pZCBhY2NvdW50cyBjcmVkaXQtY2FyZHMtYWNjb3VudHMiLCJjZXJ0aWZpY2F0ZS1kbiI6IkNOPVF1aWNrYm9va3MgUHJvLCBPVT1RdWlja2Jvb2tzIFByb2QsIE89SW50dWl0LCBDPUJSIiwiY29uc2VudC5kYXRhIjp7ImNvbnNlbnRJRCI6Ijk5OTk5NyIsImNsaWVudElkIjoiSXRhdSIsInBlcm1pc3Npb25zIjpbIkNVU1RPTUVSU19QRVJTT05BTF9JREVOVElGSUNBVElPTlNfUkVBRCJdfSwidXNlci5pbmZvIjp7InVzZXJJZCI6IjEwNDI4MTk5OTg0IiwiYnVzaW5lc3NJZCI6IiJ9fQ.J5YKOXTg6sgfo6FHMyBnLaodGeViDLTnG7UCFTNL1TM");

        relacionamentoPessoaBradescoFinanciamento = fornecimentoService.getResponseObject(ProjectType.REGISTRATION_DATA_LOSANGO_OR_BF_SUPPLY,
                ROOT_JSON_DATA_PATH, JSON_SUPPLY_BRADESCOFINANCIAMENTO_DATA_NAME, getHeaders(headerMap),
                PersonalCustomerRelationSupply.class, URL_PESSOAL_RELACIONAMENTO_SUPPLY_BRADESCOFINANCIAMENTO);

        printJsonBradescoReport(relacionamentoPessoaBradescoFinanciamento);
        BradescoReporter.report(ReportStatus.PASSED, "Get realizado com sucesso");
    }

    @Then("usuario deve receber os status code (\\d+)")
    public void usuario_deve_receber_os_status_code(int statusCode) {
        assertEquals(statusCode, relacionamentoPessoaBradescoFinanciamento.getHttpCode());
        BradescoReporter.report(ReportStatus.PASSED, "Status code validado com sucesso");
    }

    @Then("o retorno das requisicões deve estar de acordo com contrato definido")
    public void o_retorno_das_requisicões_deve_estar_de_acordo_com_contrato_definido() {
        boolean responseValid = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_SUPPLY_BRADESCOFINANCIAMENTO_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_SUPPLY_SCHEMA_NAME);
        BradescoReporter.report(ReportStatus.PASSED, "Contrato validado com sucesso");
    }
}
