package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.cws.pagamentoches;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.factory.cws.ChesPaymentContractFactory;
import br.com.bradesco.coredigital.api.automation.model.request.cws.ChesPaymentContractRequest;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.cws.ResponseChesPaymentContractCwsObject;
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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.bradesco.core.report.Assert.assertEquals;
import static com.bradesco.core.report.Assert.assertTrue;

public class EmprestimoPagamentoChesCwsStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private CwsTokenService cwsTokenService;

    @Autowired
    private ChesPaymentContractFactory chesPaymentContractFactory;

    private ResponseObject<ResponseChesPaymentContractCwsObject> responseChesPaymentContractCwsObject;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/loans/";

    private final String JSON_CWS_CHES_PAYMENT_SCHEMA_NAME = "contract_ches_payment_loans_cws_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/loans/";

    private final String JSON_CWS_CHES_PAYMENT_DATA_NAME = "contract_ches_payment_loans_cws_data";

    private final String URL_EMPRESTIMO_PAGAMENTO_CHES_CWS = "/cws/v1/payment-operations";

    @Given("que seja feito uma requisição POST no endpoint de Empréstimos - Pagamento CHES")
    public void que_seja_feito_uma_requisicao_post_no_endpoint_de_emprestimos_pagamento_ches() {

        final BigDecimal ccontr = new BigDecimal(16962);
        final String dsoltcConsDados = "30.05.2021";
        final String dinicConsent = "30.05.2021";
        final String dfnalConsent = "27.04.2021";

        final String agency = "3987";
        final String account = "10200-8";
        final String accountType = "1";

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(agency, account, accountType);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-stateless-open", cwsHeadersAutenticacao.getValue("x-stateless-open"));
        headerMap.put("x-stateless-closed", cwsHeadersAutenticacao.getValue("x-stateless-closed"));

        ChesPaymentContractRequest chesPaymentContractRequest = chesPaymentContractFactory.buildChesPaymentContractRequest(ccontr, dsoltcConsDados,
                dinicConsent, dfnalConsent);

        responseChesPaymentContractCwsObject = fornecimentoService.postObject(ProjectType.CWS_LOANS_FINANCINGS_CHES,
                ROOT_JSON_DATA_PATH, JSON_CWS_CHES_PAYMENT_DATA_NAME, getHeaders(headerMap), chesPaymentContractRequest,
                ResponseChesPaymentContractCwsObject.class, URL_EMPRESTIMO_PAGAMENTO_CHES_CWS);

        printJsonBradescoReport(responseChesPaymentContractCwsObject);
        BradescoReporter.report(ReportStatus.PASSED, "Post feito com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {

        isValidSchema = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_CWS_CHES_PAYMENT_SCHEMA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_CWS_CHES_PAYMENT_DATA_NAME);
        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = responseChesPaymentContractCwsObject.getHttpCode();
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
