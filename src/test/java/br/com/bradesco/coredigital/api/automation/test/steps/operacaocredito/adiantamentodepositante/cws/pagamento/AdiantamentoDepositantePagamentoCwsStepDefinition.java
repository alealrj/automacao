package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.adiantamentodepositante.cws.pagamento;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.factory.cws.CwsPaymentAdposFactory;
import br.com.bradesco.coredigital.api.automation.model.request.cws.CwsPaymentAdposRequest;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.cws.ResponsePaymentAdposCwsObject;
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

public class AdiantamentoDepositantePagamentoCwsStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private CwsTokenService cwsTokenService;

    @Autowired
    private CwsPaymentAdposFactory cwsPaymentAdposFactory;

    private ResponseObject<ResponsePaymentAdposCwsObject> responsePaymentAdposCwsObject;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/unarrangedaccountsoverdraft/";

    private final String JSON_CWS_SCHEMA_NAME = "payment_unarranged_accounts_overdraft_cws_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/unarrangedaccountsoverdraft/";

    private final String JSON_CWS_DATA_NAME = "payment_unarranged_accounts_overdraft_cws_data";

    private final String URL_ADPOS_PAGAMENTO_CWS = "/rest/cws/v1/payments";

    @Given("^que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Pagamento$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_adiantamento_depositante_Pagamento() {

        final String agencyGseg = "3987";
        final String accountGseg = "10200-8";
        final String accountTypeGseg = "1";

        final String contractId = "20024415007005";
        final String startDate = "01/05/2020";
        final String endDate = "30/06/2021";

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(agencyGseg, accountGseg, accountTypeGseg);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-stateless-open", cwsHeadersAutenticacao.getValue("x-stateless-open"));
        headerMap.put("x-stateless-closed", cwsHeadersAutenticacao.getValue("x-stateless-closed"));

        CwsPaymentAdposRequest cwsPaymentAdposRequest = cwsPaymentAdposFactory.buildCwsPaymentAdposRequest(
                contractId, startDate, endDate);

        responsePaymentAdposCwsObject = fornecimentoService.postObject(
                ProjectType.UNARRANGED_ACCOUNTS_OVERDRAFT_PAYMENT_CWS,
                ROOT_JSON_DATA_PATH,
                JSON_CWS_DATA_NAME,
                getHeaders(headerMap),
                cwsPaymentAdposRequest,
                ResponsePaymentAdposCwsObject.class,
                URL_ADPOS_PAGAMENTO_CWS
        );

        printJsonBradescoReport(responsePaymentAdposCwsObject);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @Given("^que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Pagamento com body request invalido$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_Adiantamento_Depositante_Pagamento_com_body_request_invalido() {

        final String agencyGseg = "3987";
        final String accountGseg = "10200-8";
        final String accountTypeGseg = "1";

        final String contractId = null;
        final String startDate = "01/05/2020";
        final String endDate = "30/06/2021";

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(agencyGseg, accountGseg, accountTypeGseg);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-stateless-open", cwsHeadersAutenticacao.getValue("x-stateless-open"));
        headerMap.put("x-stateless-closed", cwsHeadersAutenticacao.getValue("x-stateless-closed"));

        CwsPaymentAdposRequest cwsPaymentAdposRequest = cwsPaymentAdposFactory.buildCwsPaymentAdposRequest(
                contractId, startDate, endDate);

        responsePaymentAdposCwsObject = fornecimentoService.postObject(
                ProjectType.UNARRANGED_ACCOUNTS_OVERDRAFT_PAYMENT_CWS,
                ROOT_JSON_DATA_PATH,
                JSON_CWS_DATA_NAME,
                getHeaders(headerMap),
                cwsPaymentAdposRequest,
                ResponsePaymentAdposCwsObject.class,
                URL_ADPOS_PAGAMENTO_CWS
        );

        printJsonBradescoReport(responsePaymentAdposCwsObject);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @When("^pegar o status code da requisição$")
    public void pegar_o_status_code_da_requisicao() {
        statusCode = responsePaymentAdposCwsObject.getHttpCode();
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
        String erro = responsePaymentAdposCwsObject.getErrors().get(0).getDetail();
        assertEquals(mensagem, erro);
        BradescoReporter.report(ReportStatus.PASSED, "Retornado erro " + statusCode + "conforme esperado - Sucesso");
    }
}
