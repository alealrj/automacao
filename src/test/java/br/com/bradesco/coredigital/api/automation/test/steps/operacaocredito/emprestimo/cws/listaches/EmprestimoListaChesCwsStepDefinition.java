package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.cws.listaches;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.factory.cws.ChesListContractFactory;
import br.com.bradesco.coredigital.api.automation.model.request.cws.ChesListContractRequest;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.cws.ResponseChesListContractCwsObject;
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

public class EmprestimoListaChesCwsStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private CwsTokenService cwsTokenService;

    @Autowired
    private ChesListContractFactory chesListContractFactory;

    private ResponseObject<ResponseChesListContractCwsObject> responseChesListContractCwsObject;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/loans/";

    private final String JSON_CWS_CHES_SCHEMA_NAME = "list_loans_ches_cws_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/loans/";

    private final String JSON_CWS_CHES_DATA_NAME = "list_ches_loans_cws_data";

    private final String URL_EMPRESTIMO_LISTA_CHES_CWS = "/rest/cws/v1/credit-operations";

    @Given("que seja feito uma requisição POST no endpoint de Empréstimos - Lista CHES")
    public void que_seja_feito_uma_requisicao_post_no_endpoint_de_emprestimo_lista_ches() {

        String agency = "3995";
        String account = "70011";
        String digit = "12";
        String ownership = "1";
        String cpfCnpj = "624203697";
        String digitCpfCnpj = "50";
        String filialCnpj = "0";
        String brand = "2269651";
        String requestDate = "07.05.2021";
        String startDate = "07.05.2021";
        String endDate = "07.05.2021";

        String agencyLogin = "3987";
        String accountLogin = "10200-8";
        String accountTypeLogin = "1";

        ChesListContractRequest chesListContractRequest = chesListContractFactory.buildChesListContractRequest(agency,
                account, digit, ownership, cpfCnpj, digitCpfCnpj, filialCnpj, brand, requestDate, startDate, endDate);

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(agencyLogin, accountLogin,
                accountTypeLogin);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-stateless-open", cwsHeadersAutenticacao.getValue("x-stateless-open"));
        headerMap.put("x-stateless-closed", cwsHeadersAutenticacao.getValue("x-stateless-closed"));

        responseChesListContractCwsObject = fornecimentoService.postObject(ProjectType.CWS_LOANS_FINANCINGS_CHES,
                ROOT_JSON_DATA_PATH, JSON_CWS_CHES_DATA_NAME, getHeaders(headerMap), chesListContractRequest,
                ResponseChesListContractCwsObject.class, URL_EMPRESTIMO_LISTA_CHES_CWS);

        printJsonBradescoReport(responseChesListContractCwsObject);
        BradescoReporter.report(ReportStatus.PASSED, "Post feito com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {

        isValidSchema = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_CWS_CHES_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_CWS_CHES_SCHEMA_NAME);
        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = responseChesListContractCwsObject.getHttpCode();
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
