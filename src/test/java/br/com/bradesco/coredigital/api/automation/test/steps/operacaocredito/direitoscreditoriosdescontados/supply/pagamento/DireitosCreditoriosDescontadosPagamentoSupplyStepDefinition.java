package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.direitoscreditoriosdescontados.supply.pagamento;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.HealthCheck;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.supply.invoiceFinancings.InvoiceFinancingsPaymentSupply;
import br.com.bradesco.coredigital.api.automation.service.FornecimentoService;
import br.com.bradesco.coredigital.api.automation.test.steps.AbstractStepDefinition;
import com.bradesco.core.report.BradescoReporter;
import com.bradesco.core.sdk.enums.ReportStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.springframework.beans.factory.annotation.Autowired;

import static com.bradesco.core.report.Assert.assertEquals;
import static com.bradesco.core.report.Assert.assertTrue;

public class DireitosCreditoriosDescontadosPagamentoSupplyStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/invoicefinancings/";

    private final String JSON_SUPPLY_SCHEMA_NAME = "payment_invoice_financings_supply_schema";

    private final String JSON_HEALTH_CHECK_SUPPLY_SCHEMA_NAME = "healthcheck_invoice_financings_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/invoiceFinancings/";

    private final String ROOT_HEALTH_CHECK_JSON_DATA_PATH = "src/main/resources/json_data/healthcheck/";

    private final String JSON_SUPPLY_DATA_NAME = "payment_invoice_financings_supply_data";

    private final String JSON_HEALTH_CHECK_SUPPLY_DATA_NAME = "healthcheck_invoice_financings_supply_data";

//    private final String URL_DIREITOS_CREDITORIOS_DESCONTADOS_PAGAMENTO_SUPPLY = "/invoice-financings/v1/contracts/{0}/payments";
    private final String URL_DIREITOS_CREDITORIOS_DESCONTADOS_PAGAMENTO_SUPPLY = "/invoice-financings-accounts-overdraft/v1/contracts/{0}/payments";

    private final String URL_DIREITOS_CREDITORIOS_DESCONTADOS_HEALTH_CHECK_SUPPLY = "/actuator/health";

    private ResponseObject<InvoiceFinancingsPaymentSupply> pagamentoDireitosCreditoriosDescontadosResponse;

    private ResponseObject<HealthCheck> healthCheckResponse;

    private boolean isValidSchema;

    private int statusCode;

    private String statusHealthCheck;

    private String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdGF0dXMiOiJBQ1RJVkUiLCJpc3MiOiJicmFkZXNjby1vYiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImV4cCI6MTQzMjE0MzIxNDMyLCJpYXQiOjU0MzIxNDUzMjEzNCwibmJmIjo0MzIxNDMyNDMyMTQsImtpZCI6IjQ3ODM5MjE3NDg5MjMiLCJqdGkiOjM0MjM0MzI1NDM0Mywic3ViIjoiY3BmLTR1M2kyMDI0ODkwMiIsInNjcCI6Im9wZW5pZCBhY2NvdW50cyBjcmVkaXQtY2FyZHMtYWNjb3VudHMiLCJjZXJ0aWZpY2F0ZS1kbiI6IkNOPVF1aWNrYm9va3MgUHJvLCBPVT1RdWlja2Jvb2tzIFByb2QsIE89SW50dWl0LCBDPUJSIiwiY29uc2VudC5kYXRhIjp7ImNvbnNlbnRJRCI6IjEyMyIsImNsaWVudElkIjoiSWRlbnRpZmljYWRvciBkbyBUUFAiLCJwZXJtaXNzaW9ucyI6WyJVTkFSUkFOR0VEX0FDQ09VTlRTX09WRVJEUkFGVF9QQVlNRU5UU19SRUFEIiwiQ1JFRElUX0NBUkRTX0FDQ09VTlRTX0xJTUlUU19SRUFEIl19LCJ1c2VyLmluZm8iOnsidXNlcklkIjoiMTIzMTIzMTIiLCJidXNpbmVzc0lkIjoiMTIzNCJ9fQ.C06O0pCh26qhOz8PET3cvBGbwBWXK3domnIcyGAB8oA";

    private String contractId = "20007981025038";

    @Given("^que seja feito uma requisição GET no endpoint Health Check de Direitos Creditorios Descontados DCOM - Pagamento$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_health_check_de_DCOM_pagamento() {

        Headers header = headerUtils.getHeader(
                new Header("Authorization", token)
        );

        healthCheckResponse = fornecimentoService.getResponseObject(
                ProjectType.INVOICE_FINANCINGS_PAYMENT_SUPPLY,
                ROOT_HEALTH_CHECK_JSON_DATA_PATH,
                JSON_HEALTH_CHECK_SUPPLY_SCHEMA_NAME,
                header,
                HealthCheck.class,
                URL_DIREITOS_CREDITORIOS_DESCONTADOS_HEALTH_CHECK_SUPPLY
        );

        printJsonBradescoReport(healthCheckResponse);
        BradescoReporter.report(ReportStatus.PASSED, "HEALTH CHECK feito com sucesso");
    }

    @Given("^que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Pagamento$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_Operacoes_Credito_DCOM_Pagamento() {

        Headers header = headerUtils.getHeader(
                new Header("Authorization", token)
        );

        pagamentoDireitosCreditoriosDescontadosResponse = fornecimentoService.getResponseObject(
                ProjectType.INVOICE_FINANCINGS_PAYMENT_SUPPLY,
                ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME,
                header,
                InvoiceFinancingsPaymentSupply.class,
                URL_DIREITOS_CREDITORIOS_DESCONTADOS_PAGAMENTO_SUPPLY,
                contractId
        );

        printJsonBradescoReport(pagamentoDireitosCreditoriosDescontadosResponse);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @Given("^que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Pagamento com header invalido$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_adiantamento_depositante_ADPOS_Pagamento_Com_Header_Invalido() {

        Headers header = headerUtils.getHeader(
                new Header("Authorization", null)
        );

        pagamentoDireitosCreditoriosDescontadosResponse = fornecimentoService.getResponseObject(
                ProjectType.INVOICE_FINANCINGS_PAYMENT_SUPPLY,
                ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME,
                header,
                InvoiceFinancingsPaymentSupply.class,
                URL_DIREITOS_CREDITORIOS_DESCONTADOS_PAGAMENTO_SUPPLY,
                contractId
        );

        printJsonBradescoReport(pagamentoDireitosCreditoriosDescontadosResponse);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @Given("^que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Pagamento sem informar contractId$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_antecipacao_recebiveis_DCOM_pagamento_sem_informar_contractId() {

        //TODO Ajustar valor de contractId após definições
        contractId = null;

        Headers header = headerUtils.getHeader(
                new Header("Authorization", token)
        );

        pagamentoDireitosCreditoriosDescontadosResponse = fornecimentoService.getResponseObject(
                ProjectType.INVOICE_FINANCINGS_PAYMENT_SUPPLY,
                ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME,
                header,
                InvoiceFinancingsPaymentSupply.class,
                URL_DIREITOS_CREDITORIOS_DESCONTADOS_PAGAMENTO_SUPPLY,
                contractId
        );

        printJsonBradescoReport(pagamentoDireitosCreditoriosDescontadosResponse);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @When("^pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {
        statusCode = pagamentoDireitosCreditoriosDescontadosResponse.getHttpCode();
        BradescoReporter.report(ReportStatus.PASSED, "Validação do status code feita com sucesso$");
    }

    @When("^pegar o status de saude da requisição$")
    public void pegar_o_status_de_saude_da_requisicao() {
        statusHealthCheck = healthCheckResponse.getData().getStatus();
        BradescoReporter.report(ReportStatus.PASSED, "Validação do status de saúde feita com sucesso");
    }

    @When("^pegar o schema da API")
    public void pegar_o_schema_da_API() {
        isValidSchema = fornecimentoService.validateSchema(
                ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH,
                JSON_SUPPLY_SCHEMA_NAME
        );

        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso$");
    }

    @Then("^o status de saúde da API deve ser (.*)$")
    public void o_status_code_deve_ser(String saude) {
        assertEquals(saude, statusHealthCheck);
        BradescoReporter.report(ReportStatus.PASSED, "Status code é válido");
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
    public void a_mensagem_de_erro_deve_ser (String mensagem) {
        String erro = pagamentoDireitosCreditoriosDescontadosResponse.getErrors().get(0).getTitle();
        assertEquals(mensagem, erro);
        BradescoReporter.report(ReportStatus.PASSED, "Retornado erro 503 conforme esperado - Sucesso");
    }
}
