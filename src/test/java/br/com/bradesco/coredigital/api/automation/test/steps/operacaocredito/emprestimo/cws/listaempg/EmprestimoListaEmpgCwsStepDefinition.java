package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.cws.listaempg;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.factory.cws.EmpgListContractFactory;
import br.com.bradesco.coredigital.api.automation.model.request.cws.EmpgListContractRequest;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.cws.ResponseEmpgListContractCwsObject;
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

public class EmprestimoListaEmpgCwsStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private CwsTokenService cwsTokenService;

    @Autowired
    private EmpgListContractFactory empgListContractFactory;

    private ResponseObject<ResponseEmpgListContractCwsObject> listaEmprestimoResponse;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/loans/";

    private final String JSON_CWS_EMPG_SCHEMA_NAME = "list_loans_empg_cws_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/loans/";

    private final String JSON_CWS_EMPG_DATA_NAME = "list_empg_loans_cws_data";

    private final String URL_EMPRESTIMO_LISTA_EMPG_CWS = "/rest/cws/v1/credit-operations";

    @Given("que seja feito uma requisição POST no endpoint de Empréstimos - Lista EMPG")
    public void que_seja_feito_uma_requisicao_post_no_endpoint_de_emprestimo_lista_empg() {

        String agency = "3995";
        String account = "4028";
        String ownership = "1";
        String cpfCnpj = "28021186";
        String digitCpfCnpj = "84";
        String filialCnpj = "0001";
        String brand = "2269651";
        String requestDate = "27.05.2021";
        String startDate = "27.05.2021";
        String endDate = "27.05.2021";

        String agencyLogin = "3987";
        String accountLogin = "10200-8";
        String accountTypeLogin = "1";

        EmpgListContractRequest empgListContractRequest = empgListContractFactory
                .buildEmpgListContractRequest(agency, account, ownership, cpfCnpj, digitCpfCnpj, filialCnpj,
                        brand, requestDate, startDate, endDate);

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(agencyLogin, accountLogin,
                accountTypeLogin);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-stateless-open", cwsHeadersAutenticacao.getValue("x-stateless-open"));
        headerMap.put("x-stateless-closed", cwsHeadersAutenticacao.getValue("x-stateless-closed"));


        listaEmprestimoResponse = fornecimentoService.postObject(ProjectType.CWS_LOANS_FINANCINGS_EMPG,
                ROOT_JSON_DATA_PATH, JSON_CWS_EMPG_DATA_NAME, getHeaders(headerMap), empgListContractRequest,
                ResponseEmpgListContractCwsObject.class, URL_EMPRESTIMO_LISTA_EMPG_CWS);

        printJsonBradescoReport(listaEmprestimoResponse);
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

        statusCode = listaEmprestimoResponse.getHttpCode();
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
