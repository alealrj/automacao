package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.cws.pagamentoempf;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.factory.cws.EmpfPaymentContractFactory;
import br.com.bradesco.coredigital.api.automation.model.request.cws.EmpfPaymentContractRequest;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.cws.ResponsePaymentContractCwsObject;
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

public class FinanciamentoPagamentoEmpfCwsStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private CwsTokenService cwsTokenService;

    @Autowired
    private EmpfPaymentContractFactory empfPaymentContractFactory;

    private ResponseObject<ResponsePaymentContractCwsObject> responsePaymentContractCwsObject;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/financing/";

    private final String JSON_CWS_EMPF_SCHEMA_NAME = "payment_financing_empf_cws_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/financing/";

    private final String JSON_CWS_EMPF_DATA_NAME = "payment_financing_empf_data";

    private final String URL_FINANCIAMENTO_PAGAMENTO__EMPF = "/rest/cws/v1/payment-contract";

    @Given("que seja feito uma requisição POST no endpoint de Financiamento - Pagamento EMPF")
    public void que_seja_feito_uma_requisicao_post_no_endpoint_de_financiamento_pagamento_empf() {

        final String cprodtBdsco = "12";
        final String cfamlContr = "3";
        final String ccontr = "290127555";
        final String dsoltcConsDados = "07.06.2021";
        final String dinicConsent = "07.06.2020";
        final String dfnalConsent = "07.06.2021";

        final String loginAgency = "3987";
        final String loginAccount = "10200-8";
        final String loginAccountType = "1";

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(loginAgency, loginAccount,
                loginAccountType);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-stateless-open", cwsHeadersAutenticacao.getValue("x-stateless-open"));
        headerMap.put("x-stateless-closed", cwsHeadersAutenticacao.getValue("x-stateless-closed"));

        EmpfPaymentContractRequest empfPaymentContractRequest = empfPaymentContractFactory
                .buidEmpfPaymentContractRequest(ccontr, cprodtBdsco, cfamlContr, dsoltcConsDados,
                        dinicConsent, dfnalConsent);

        responsePaymentContractCwsObject = fornecimentoService.postObject(ProjectType.CWS_LOANS_FINANCINGS_EMPF,
                ROOT_JSON_DATA_PATH, JSON_CWS_EMPF_DATA_NAME,
                        getHeaders(headerMap), empfPaymentContractRequest, ResponsePaymentContractCwsObject.class,
                        URL_FINANCIAMENTO_PAGAMENTO__EMPF);

        printJsonBradescoReport(responsePaymentContractCwsObject.getData());
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

        statusCode = responsePaymentContractCwsObject.getHttpCode();
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
