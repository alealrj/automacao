package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.cws.contratoempg;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.factory.cws.EmpgContractFactory;
import br.com.bradesco.coredigital.api.automation.model.request.cws.EmpgContractRequest;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.cws.ResponseEmpgContractCwsObject;
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

public class EmprestimoContratoEmpgCwsStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private CwsTokenService cwsTokenService;

    @Autowired
    private EmpgContractFactory empgContractFactory;

    private ResponseObject<ResponseEmpgContractCwsObject> responseEmpgContractCwsObject;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/loans/";

    private final String JSON_CWS_EMPG_SCHEMA_NAME = "contract_empg_loans_cws_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/loans/";

    private final String JSON_CWS_EMPG_DATA_NAME = "contract_empg_loans_cws_data";

    private final String URL_EMPRESTIMO_CONTRATO_EMPG_CWS = "/rest/cws/v1/contract-operation";

    @Given("que seja feito uma requisição POST no endpoint de Empréstimos - Contrato EMPG")
    public void que_seja_feito_uma_requisicao_post_no_endpoint_de_emprestimos_contrato_empg() {

        final String ccontr = "390";
        final String cprodtBdsco = "5";
        final String cfamlContr = "5";
        final String dsoltcConsDados = "27.05.2021";
        final String dinicConsent = "27.05.2021";
        final String dfnalConsent = "27.05.2021";

        final String agency = "3987";
        final String account = "10200-8";
        final String accountType = "1";

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(agency, account, accountType);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-stateless-open", cwsHeadersAutenticacao.getValue("x-stateless-open"));
        headerMap.put("x-stateless-closed", cwsHeadersAutenticacao.getValue("x-stateless-closed"));

        EmpgContractRequest empgContractRequest = empgContractFactory.buildEmpgContractRequest(ccontr, cprodtBdsco,
                cfamlContr, dsoltcConsDados, dinicConsent, dfnalConsent);

        responseEmpgContractCwsObject = fornecimentoService.postObject(ProjectType.CWS_LOANS_FINANCINGS_EMPG,
                ROOT_JSON_DATA_PATH, JSON_CWS_EMPG_DATA_NAME, getHeaders(headerMap), empgContractRequest,
                ResponseEmpgContractCwsObject.class, URL_EMPRESTIMO_CONTRATO_EMPG_CWS);

        printJsonBradescoReport(responseEmpgContractCwsObject);
        BradescoReporter.report(ReportStatus.PASSED, "Post feito com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {

        isValidSchema = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_CWS_EMPG_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_CWS_EMPG_SCHEMA_NAME);
        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = responseEmpgContractCwsObject.getHttpCode();
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
