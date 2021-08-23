package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.cws.contratoempf;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.factory.cws.EmpfContractFactory;
import br.com.bradesco.coredigital.api.automation.model.request.cws.EmpfContractRequest;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.cws.ResponseEmpfContractCwsObject;
import br.com.bradesco.coredigital.api.automation.service.CwsTokenService;
import br.com.bradesco.coredigital.api.automation.service.FornecimentoService;
import br.com.bradesco.coredigital.api.automation.test.steps.AbstractStepDefinition;
import com.bradesco.core.report.BradescoReporter;
import com.bradesco.core.sdk.enums.ReportStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Headers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static com.bradesco.core.report.Assert.assertEquals;
import static com.bradesco.core.report.Assert.assertTrue;

public class EmprestimoContratoEmpfCwsStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private CwsTokenService cwsTokenService;

    @Autowired
    private EmpfContractFactory empfContractFactory;

    private ResponseObject<ResponseEmpfContractCwsObject> responseEmpfContractCwsObject;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/loans/";

    private final String JSON_CWS_EMPF_SCHEMA_NAME = "contract_empf_loans_cws_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/loans/";

    private final String JSON_CWS_EMPF_DATA_NAME = "contract_empf_loans_cws_data";

    private final String URL_EMPRESTIMO_CONTRATO_EMPF_CWS = "/rest/cws/v1/contract";

    @Given("que seja feito uma requisição POST no endpoint de Empréstimos - Contrato EMPF")
    public void que_seja_feito_uma_requisicao_post_no_endpoint_de_emprestimos_contrato_empf() {

        final long contractNumber = 290127565;
        final long productCode = 12;
        final long familyContractCode = 3;
        final String requestDate = "13.04.2021";
        final String startConsentDate = "13.04.2021";
        final String endConsentDate = "13.04.2021";

        final String agency = "3987";
        final String account = "10200-8";
        final String accountType = "1";

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(agency, account, accountType);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-stateless-open", cwsHeadersAutenticacao.getValue("x-stateless-open"));
        headerMap.put("x-stateless-closed", cwsHeadersAutenticacao.getValue("x-stateless-closed"));

        EmpfContractRequest empfContractRequest = empfContractFactory.buildEmpfContractRequest(contractNumber,
                productCode, familyContractCode, requestDate, startConsentDate, endConsentDate);

        responseEmpfContractCwsObject = fornecimentoService.postObject(ProjectType.CWS_LOANS_FINANCINGS_EMPF,
                ROOT_JSON_DATA_PATH, JSON_CWS_EMPF_DATA_NAME, getHeaders(headerMap), empfContractRequest,
                ResponseEmpfContractCwsObject.class, URL_EMPRESTIMO_CONTRATO_EMPF_CWS);

        printJsonBradescoReport(responseEmpfContractCwsObject);
        BradescoReporter.report(ReportStatus.PASSED, "Post feito com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {

        isValidSchema = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_CWS_EMPF_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_CWS_EMPF_SCHEMA_NAME);
        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = responseEmpfContractCwsObject.getHttpCode();
        BradescoReporter.report(ReportStatus.PASSED, "Validação do status code feita com sucesso");
    }

    @Then("o schema deve ser válido")
    public void o_schema_deve_ser_valido() {

        assertTrue(isValidSchema);
        BradescoReporter.report(ReportStatus.PASSED, "Schema é válido");
    }

    @Then("o status code deve ser (\\d+)")
    public void o_status_code_deve_ser(int code) {

        assertEquals(code, statusCode);
        BradescoReporter.report(ReportStatus.PASSED, "Status code é válido");
    }
}
