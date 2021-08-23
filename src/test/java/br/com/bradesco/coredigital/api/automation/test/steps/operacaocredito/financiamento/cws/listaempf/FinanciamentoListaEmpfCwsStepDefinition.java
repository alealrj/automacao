package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.cws.listaempf;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.factory.cws.EmpfListContractFactory;
import br.com.bradesco.coredigital.api.automation.model.request.cws.EmpfListContractRequest;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.cws.ResponseEmpfListContractCwsObject;
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

public class FinanciamentoListaEmpfCwsStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private CwsTokenService cwsTokenService;

    @Autowired
    private EmpfListContractFactory empfListContractFactory;

    private ResponseObject<ResponseEmpfListContractCwsObject> listaFinanciamentoResponse;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/financing/";

    private final String JSON_CWS_EMPF_SCHEMA_NAME = "list_financing_empf_cws_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/financing/";

    private final String JSON_CWS_EMPF_DATA_NAME = "list_empf_financing_cws_data";

    private final String URL_FINANCIAMENTO_LISTA_EMPF_CWS = "/rest/cws/v1/credit-operations";

    @Given("que seja feito uma requisição POST no endpoint de Financiamento - Lista EMPF")
    public void que_seja_feito_uma_requisicao_post_no_endpoint_de_financiamento_lista_empf() {

        String agency = "3995";
        String account = "1994";
        String digit = "1";
        String ownership = "1";
        String cpfCnpj = "874645123";
        String digitCpfCnpj = "40";
        String filialCnpj = "0";
        String brand = "2269651";
        String requestDate = "19.05.2021";
        String startDate = "19.05.2020";
        String endDate = "19.05.2021";

        final String loginAgency = "3987";
        final String loginAccount = "10200-8";
        final String loginAccountType = "1";

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(loginAgency, loginAccount,
                loginAccountType);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-stateless-open", cwsHeadersAutenticacao.getValue("x-stateless-open"));
        headerMap.put("x-stateless-closed", cwsHeadersAutenticacao.getValue("x-stateless-closed"));


        EmpfListContractRequest empfListContractRequest = empfListContractFactory.buildEmpfListContractRequest(agency,
                account, digit, ownership, cpfCnpj, digitCpfCnpj, filialCnpj, brand, requestDate, startDate, endDate);

        listaFinanciamentoResponse = fornecimentoService.postObject(ProjectType.CWS_LOANS_FINANCINGS_EMPF,
                ROOT_JSON_DATA_PATH, JSON_CWS_EMPF_DATA_NAME, getHeaders(headerMap), empfListContractRequest,
                ResponseEmpfListContractCwsObject.class, URL_FINANCIAMENTO_LISTA_EMPF_CWS);

        printJsonBradescoReport(listaFinanciamentoResponse);
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

        statusCode = listaFinanciamentoResponse.getHttpCode();
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
