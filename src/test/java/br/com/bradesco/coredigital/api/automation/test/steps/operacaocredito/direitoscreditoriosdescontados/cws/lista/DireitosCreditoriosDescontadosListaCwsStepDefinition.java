package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.direitoscreditoriosdescontados.cws.lista;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.factory.cws.CwsListDcomFactory;
import br.com.bradesco.coredigital.api.automation.model.request.cws.CwsListDcomRequest;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.cws.ResponseListDcomCwsObject;
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

public class DireitosCreditoriosDescontadosListaCwsStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private CwsTokenService cwsTokenService;

    @Autowired
    private CwsListDcomFactory cwsListDcomFactory;

    private ResponseObject<ResponseListDcomCwsObject> responseListDcomCwsObject;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/invoicefinancings/";

    private final String JSON_CWS_SCHEMA_NAME = "list_invoice_financings_cws_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/invoicefinancings/";

    private final String JSON_CWS_DATA_NAME = "list_invoicefinancings_cws_data";

    private final String URL_DCOM_LISTA_CWS = "/rest/cws/v1/credit-operations";

    @Given("^que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Lista$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_direitos_creditorios_descontados_dcom_lista() {

        final String agencyGseg = "3877";
        final String accountGseg = "27603-0";
        final String accountTypeGseg = "1";

        final String requestDate = "31/05/2021";
        final String startDate = "28/05/2020";
        final String endDate = "28/05/2021";
        final String agency = "0002";
        final String account = "20700";
        final String ownership = "1";
        final String cpfCnpj = "048115038";
        final String filialCnpj = "0001";
        final String digitCpfCnpj = "36";

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(agencyGseg, accountGseg, accountTypeGseg);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-stateless-open", cwsHeadersAutenticacao.getValue("x-stateless-open"));
        headerMap.put("x-stateless-closed", cwsHeadersAutenticacao.getValue("x-stateless-closed"));

        CwsListDcomRequest cwsListDcomRequest = cwsListDcomFactory.buildCwsDcomRequest(
                requestDate,startDate,endDate,agency,account,ownership,cpfCnpj,filialCnpj,digitCpfCnpj
        );

        responseListDcomCwsObject = fornecimentoService.postObject(
                ProjectType.INVOICE_FINANCINGS_LIST_CWS,
                ROOT_JSON_DATA_PATH,
                JSON_CWS_DATA_NAME,
                getHeaders(headerMap),
                cwsListDcomRequest,
                ResponseListDcomCwsObject.class,
                URL_DCOM_LISTA_CWS
        );

        printJsonBradescoReport(responseListDcomCwsObject);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @Given("^que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Lista com header invalido$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_direitos_creditorios_descontados_dcom_lista_com_header_invalido() {

        final String agencyGseg = "3877";
        final String accountGseg = "27603-0";
        final String accountTypeGseg = "1";

        final String requestDate = "31/05/2021";
        final String startDate = "28/05/2020";
        final String endDate = "28/05/2021";
        final String agency = "0002";
        final String account = "20700";
        final String ownership = "1";
        final String cpfCnpj = "048115038";
        final String filialCnpj = "0001";
        final String digitCpfCnpj = "36";

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(agencyGseg, accountGseg, accountTypeGseg);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-stateless-open", cwsHeadersAutenticacao.getValue("x-stateless-open"));
        headerMap.put("x-stateless-closed", cwsHeadersAutenticacao.getValue("A"));

        CwsListDcomRequest cwsListDcomRequest = cwsListDcomFactory.buildCwsDcomRequest(
                requestDate,startDate,endDate,agency,account,ownership,cpfCnpj,filialCnpj,digitCpfCnpj
        );

        responseListDcomCwsObject = fornecimentoService.postObject(
                ProjectType.INVOICE_FINANCINGS_LIST_CWS,
                ROOT_JSON_DATA_PATH,
                JSON_CWS_DATA_NAME,
                getHeaders(headerMap),
                cwsListDcomRequest,
                ResponseListDcomCwsObject.class,
                URL_DCOM_LISTA_CWS
        );

        printJsonBradescoReport(responseListDcomCwsObject);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @When("^pegar o status code da requisição$")
    public void pegar_o_status_code_da_requisicao() {
        statusCode = responseListDcomCwsObject.getHttpCode();
        BradescoReporter.report(ReportStatus.PASSED, "Validação do status code feita com sucesso");
    }

    @When("^pegar o schema da API$")
    public void pegar_o_schema_da_API() {
        isValidSchema = fornecimentoService.validateSchema(
                ROOT_JSON_DATA_PATH,
                JSON_CWS_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH,
                JSON_CWS_SCHEMA_NAME
        );

        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @Then("^o status code deve ser (\\d+)$")
    public void o_status_code_deve_ser(int code) {
        assertEquals(code, statusCode);
        BradescoReporter.report(ReportStatus.PASSED, "Status code é válido");
    }

    @Then("^o schema deve ser válido$")
    public void o_schema_deve_ser_valido() {
        assertTrue(isValidSchema);
        BradescoReporter.report(ReportStatus.PASSED, "Schema é válido");
    }

    @Then("^a mensagem de erro deve ser \"(.*)\"$")
    public void a_Mensagem_De_Erro_Deve_Ser(String mensagem) {
        String erro = responseListDcomCwsObject.getErrors().get(0).getDetail();
        assertEquals(mensagem, erro);
        BradescoReporter.report(ReportStatus.PASSED, "Retornado erro " + statusCode + "conforme esperado - Sucesso");
    }
}
