package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.adiantamentodepositante.supply.contrato;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.HealthCheck;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.supply.unarrangedaccountsoverdraft.UnarrangedAccountsOverdraftContractSupply;
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

public class AdiantamentoDepositanteContratoSupplyStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/unarrangedaccountsoverdraft/";

    private final String JSON_SUPPLY_SCHEMA_NAME = "contract_unarranged_accounts_overdraft_supply_schema";

    private final String JSON_HEALTH_CHECK_SUPPLY_SCHEMA_NAME = "healthcheck_unarranged_accounts_overdraft_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/unarrangedaccountsoverdraft/";

    private final String ROOT_HEALTH_CHECK_JSON_DATA_PATH = "src/main/resources/json_data/healthcheck/";

    private final String JSON_SUPPLY_DATA_NAME = "contract_unarranged_accounts_overdraft_supply_data";

    private final String JSON_HEALTH_CHECK_SUPPLY_DATA_NAME = "healthcheck_unarranged_accounts_overdraft_supply_data";

    private final String URL_ADIANTAMENTO_DEPOSITANTE_CONTRATO_SUPPLY = "/unarranged-accounts-overdraft/v1/contracts/{0}";

    private final String URL_ADIANTAMENTO_DEPOSITANTE_HEALTH_CHECK_SUPPLY = "/actuator/health";

    private ResponseObject<UnarrangedAccountsOverdraftContractSupply> contratoAdiantamentoDepositanteResponse;

    private ResponseObject<HealthCheck> healthCheckResponse;

    private boolean isValidSchema;

    private int statusCode;

    private String statusHealthCheck;

    private String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdGF0dXMiOiJBQ1RJVkUiLCJpc3MiOiJicmFkZXNjby1vYiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImV4cCI6MTQzMjE0MzIxNDMyLCJpYXQiOjU0MzIxNDUzMjEzNCwibmJmIjo0MzIxNDMyNDMyMTQsImtpZCI6IjQ3ODM5MjE3NDg5MjMiLCJqdGkiOjM0MjM0MzI1NDM0Mywic3ViIjoiY3BmLTR1M2kyMDI0ODkwMiIsInNjcCI6Im9wZW5pZCBhY2NvdW50cyBjcmVkaXQtY2FyZHMtYWNjb3VudHMiLCJjZXJ0aWZpY2F0ZS1kbiI6IkNOPVF1aWNrYm9va3MgUHJvLCBPVT1RdWlja2Jvb2tzIFByb2QsIE89SW50dWl0LCBDPUJSIiwiY29uc2VudC5kYXRhIjp7ImNvbnNlbnRJRCI6IjEyMyIsImNsaWVudElkIjoiSWRlbnRpZmljYWRvciBkbyBUUFAiLCJwZXJtaXNzaW9ucyI6WyJVTkFSUkFOR0VEX0FDQ09VTlRTX09WRVJEUkFGVF9SRUFEIiwiQ1JFRElUX0NBUkRTX0FDQ09VTlRTX0xJTUlUU19SRUFEIl19LCJ1c2VyLmluZm8iOnsidXNlcklkIjoiMTIzMTIzMTIiLCJidXNpbmVzc0lkIjoiMTIzNCJ9fQ.A7m4FhKYt8yBnd6Rs3MynOiaY63l9fytXkdxMqpy3HY";
    
    @Given("^que seja feito uma requisição GET no endpoint Health Check de Adiantamento a Depositante ADPOS - Contrato$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_health_check_de_adiantamento_a_depositante_ADPOS_Contrato() {

        Headers header = headerUtils.getHeader(
                new Header("Authorization", token)
        );

        healthCheckResponse = fornecimentoService.getResponseObject(
                ProjectType.UNARRANGED_ACCOUNTS_OVERDRAFT_CONTRACT_SUPPLY,
                ROOT_HEALTH_CHECK_JSON_DATA_PATH,
                JSON_HEALTH_CHECK_SUPPLY_SCHEMA_NAME,
                header,
                HealthCheck.class,
                URL_ADIANTAMENTO_DEPOSITANTE_HEALTH_CHECK_SUPPLY
        );

        printJsonBradescoReport(healthCheckResponse);
        BradescoReporter.report(ReportStatus.PASSED, "HEALTH CHECK feito com sucesso");
    }

    @Given("^que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Contrato$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_Adiantamento_a_Depositante_ADPOS_Contrato() {

        //TODO Ajustar valor de contractId após definições
        String contractId = "20007981025038";

        Headers header = headerUtils.getHeader(
                new Header("Authorization", token)
        );

        contratoAdiantamentoDepositanteResponse = fornecimentoService.getResponseObject(
                ProjectType.UNARRANGED_ACCOUNTS_OVERDRAFT_CONTRACT_SUPPLY,
                ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME,
                header,
                UnarrangedAccountsOverdraftContractSupply.class,
                URL_ADIANTAMENTO_DEPOSITANTE_CONTRATO_SUPPLY,
                contractId
                );

        printJsonBradescoReport(contratoAdiantamentoDepositanteResponse);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @Given("^que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Contrato sem informar contractId$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_adiantamento_depositante_contrato_com_contract_id_invalido() {

        //TODO Ajustar valor de contractId após definições
        String contractId = null;

        Headers header = headerUtils.getHeader(
                new Header("Authorization", token)
        );

        contratoAdiantamentoDepositanteResponse = fornecimentoService.getResponseObject(
                ProjectType.UNARRANGED_ACCOUNTS_OVERDRAFT_CONTRACT_SUPPLY,
                ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME,
                header,
                UnarrangedAccountsOverdraftContractSupply.class,
                URL_ADIANTAMENTO_DEPOSITANTE_CONTRATO_SUPPLY,
                contractId
        );

        printJsonBradescoReport(contratoAdiantamentoDepositanteResponse);
        BradescoReporter.report(ReportStatus.PASSED, "GET realizado com contractId inválido - sucesso");
    }

    @Given("^que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Contrato com header invalido$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_adiantamento_depositante_contrato_com_header_invalido() {

        //TODO Ajustar valor de contractId após definições
        String contractId = "20007981025038";

        Headers header = headerUtils.getHeader(
                new Header("Authorization", null)
        );

        contratoAdiantamentoDepositanteResponse = fornecimentoService.getResponseObject(
                ProjectType.UNARRANGED_ACCOUNTS_OVERDRAFT_CONTRACT_SUPPLY,
                ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME,
                header,
                UnarrangedAccountsOverdraftContractSupply.class,
                URL_ADIANTAMENTO_DEPOSITANTE_CONTRATO_SUPPLY,
                contractId
        );

        printJsonBradescoReport(contratoAdiantamentoDepositanteResponse);
        BradescoReporter.report(ReportStatus.PASSED, "GET realizado com contractId inválido - sucesso");
    }

    @When("^pegar o status code da requisição$")
    public void pegar_o_status_code_da_requisicao() {
        statusCode = contratoAdiantamentoDepositanteResponse.getHttpCode();
        BradescoReporter.report(ReportStatus.PASSED, "Validação do status code feita com sucesso");
    }

    @When("^pegar o status de saude da requisição$")
    public void pegar_o_status_de_saude_da_requisicao() {
        statusHealthCheck = healthCheckResponse.getData().getStatus();
        BradescoReporter.report(ReportStatus.PASSED, "Validação do status de saúde feita com sucesso");
    }

    @When("^pegar o schema da API$")
    public void pegar_o_schema_da_API() {
        isValidSchema = fornecimentoService.validateSchema(
                ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH,
                JSON_SUPPLY_SCHEMA_NAME
        );

        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @Then("^o status code deve ser (\\d+)$")
    public void o_status_code_deve_ser(int code) {
        assertEquals(code, statusCode);
        BradescoReporter.report(ReportStatus.PASSED, "Status code é válido");
    }

    @Then("^o status de saúde da API deve ser (.*)$")
    public void o_status_code_deve_ser(String saude) {
        assertEquals(saude, statusHealthCheck);
        BradescoReporter.report(ReportStatus.PASSED, "Status code é válido");
    }

    @Then("^o schema deve ser válido$")
    public void o_schema_deve_ser_valido() {
        assertTrue(isValidSchema);
        BradescoReporter.report(ReportStatus.PASSED, "Schema é válido");
    }

    @Then("^a mensagem de erro deve ser \"(.*)\"$")
    public void a_Mensagem_De_Erro_Deve_Ser(String mensagem) {
        String erro = contratoAdiantamentoDepositanteResponse.getErrors().get(0).getDetail();
        assertEquals(mensagem, erro);
        BradescoReporter.report(ReportStatus.PASSED, "Retornado erro " + statusCode + "conforme esperado - Sucesso");
    }
}
