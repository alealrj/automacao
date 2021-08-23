package br.com.bradesco.coredigital.api.automation.test.steps.conta.cws.transacao;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseListData;
import br.com.bradesco.coredigital.api.automation.model.response.cws.AccountTransactionTypeCws;
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


public class ContaTransacaoTipoCwsStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private CwsTokenService cwsTokenService;

    private ResponseListData<AccountTransactionTypeCws> transactionCwsResponse;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/account/";

    private final String JSON_CWS_SCHEMA_NAME = "transaction_type_account_cws_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/account/";

    private final String JSON_CWS_DATA_NAME = "transaction_type_account_cws_data";

    private final String URL_CONTA_TRANSACAO_TIPO_CWS = "/transaction/types";


    @Given("que seja feito uma requisição GET no endpoint do CWS de TransactionType da Conta")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_do_cws_de_transactiontype_da_conta() {

        String Agency = "3995";
        String Account = "4419";
        String Checkdigit = "9";
        String Holder = "1";

        final String agency = "3987";
        final String account = "10200-8";
        final String accountType = "1";

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(agency, account, accountType);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-stateless-open", cwsHeadersAutenticacao.getValue("x-stateless-open"));
        headerMap.put("x-stateless-closed", cwsHeadersAutenticacao.getValue("x-stateless-closed"));


        transactionCwsResponse = fornecimentoService.getResponseListData(ProjectType.ACCOUNT_TRANSACTION_TYPE_CWS, ROOT_JSON_DATA_PATH,
                JSON_CWS_DATA_NAME, getHeaders(headerMap), AccountTransactionTypeCws.class, URL_CONTA_TRANSACAO_TIPO_CWS, Agency, Account, Checkdigit, Holder);
        printJsonBradescoReport(transactionCwsResponse);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {
        isValidSchema = fornecimentoService.validateSchema(
                ROOT_JSON_DATA_PATH,
                JSON_CWS_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH,
                JSON_CWS_SCHEMA_NAME
        );
        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = transactionCwsResponse.getHttpCode();
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
