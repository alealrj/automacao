package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.adiantamentodepositante.core.contrato;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.HealthCheck;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.core.unarrangedaccountsoverdraft.UnarrangedAccountsOverdraftContractCore;
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

public class AdiantamentoDepositanteContratoCoreStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/unarrangedaccountsoverdraft/";

    private final String JSON_CORE_SCHEMA_NAME = "contract_unarranged_accounts_overdraft_core_schema";

    private final String JSON_HEALTH_CHECK_CORE_SCHEMA_NAME = "healthcheck_unarranged_accounts_overdraft_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/unarrangedaccountsoverdraft/";

    private final String ROOT_HEALTH_CHECK_JSON_DATA_PATH = "src/main/resources/json_data/healthcheck/";

    private final String JSON_CORE_DATA_NAME = "contract_unarranged_accounts_overdraft_core_data";

    private final String JSON_HEALTH_CHECK_CORE_DATA_NAME = "healthcheck_unarranged_accounts_overdraft_core_data";

    private final String URL_ADIANTAMENTO_DEPOSITANTE_CONTRATO_CORE = "/core/unarranged-accounts-overdraft/v1/contracts/{0}?sourceSystem={1}&requestDate={2}";

    private final String URL_ADIANTAMENTO_DEPOSITANTE_HEALTH_CHECK = "/actuator/health";

    private ResponseObject<UnarrangedAccountsOverdraftContractCore> contratoAdiantamentoDepositanteResponse;

    private ResponseObject<HealthCheck> healthCheckResponse;

    private boolean isValidSchema;

    private int statusCode;

    private String statusHealthCheck;

    private String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJ2ZXIiOiIxLjAiLCJpc3MiOiJodHRwczovL29wZW5iYW5raW5nPi9icmFuZC50b2tlbiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImp0aSI6Ijc5ODQ3MDcwLTY2MzYtNDc0YS1hMTg5LTY3MDcyNDZiMDhkOSIsImlhdCI6MTYyMjE1NDY4OSwidG9rZW5JRCI6IkdVSUQgZ2VyYWRvIHBhcmEgbyBhY2Vzcy10b2tlbiIsInNjcCI6IjxwZXJtaXNzw7VlcyBzb2xpY2l0YWRhcyBwZWxhIG1hcmNhL2NhbmFsIGUgdmFsaWRhZGFzIG5vIE9QQks-IiwidXNlci5pbmZvIjp7InVzZXJJZCI6IjEyMzEyMzEyIiwiYWdlbmN5IjoiMDAwMSIsImFjY291bnQiOiIxMjM0NTY3IiwiYWNjb3VudERpZ2l0IjoiMSIsImhvbGRlciI6IjAwIn0sInVzZXIuYXV0aCI6eyJjaGFubmVsU2Vzc0lEIjoiPG7Dum1lcm8gcXVlIGlkZW50aWZpY2EgYSBzZXNzw6NvIGRvIGNhbmFsPiIsIkRldmljZUlEIjoiPGluZm9ybWHDp8O1ZXMgZG8gZGlzcG9zaXRpdm8gZG8gdXN1w6FyaW8-In19.TdXcPNgS0cC5g5hSS8JkCh2ymbC1_clOWxUMUsRLbu0";

    @Given("^que seja feito uma requisição GET no endpoint Health Check de Adiantamento a Depositante ADPOS - Contrato$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_health_check_de_adiantamento_a_depositante_ADPOS_Contrato() {

        Headers header = headerUtils.getHeader(
                new Header("Authorization", token)
        );

        healthCheckResponse = fornecimentoService.getResponseObject(
                ProjectType.UNARRANGED_ACCOUNTS_OVERDRAFT_CONTRACT_CORE,
                ROOT_HEALTH_CHECK_JSON_DATA_PATH,
                JSON_HEALTH_CHECK_CORE_SCHEMA_NAME,
                header,
                HealthCheck.class,
                URL_ADIANTAMENTO_DEPOSITANTE_HEALTH_CHECK
        );

        printJsonBradescoReport(healthCheckResponse);
        BradescoReporter.report(ReportStatus.PASSED, "HEALTH CHECK feito com sucesso");
    }

    @Given("^que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Contrato$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_Adiantamento_a_Depositante_ADPOS_Contrato() {

        //TODO Ajustar valor de contractId, sourceSystem e requestDate após definições
        String contractId = "20007981025038";
        String sourceSystem = "ceri";
        String requestDate = "25/05/2021";

        Headers header = headerUtils.getHeader(
                new Header("Authorization", token)
        );

        contratoAdiantamentoDepositanteResponse = fornecimentoService.getResponseObject(
                ProjectType.UNARRANGED_ACCOUNTS_OVERDRAFT_CONTRACT_CORE,
                ROOT_JSON_DATA_PATH,
                JSON_CORE_DATA_NAME,
                header,
                UnarrangedAccountsOverdraftContractCore.class,
                URL_ADIANTAMENTO_DEPOSITANTE_CONTRATO_CORE,
                contractId,
                sourceSystem,
                requestDate
        );

        printJsonBradescoReport(contratoAdiantamentoDepositanteResponse);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @Given("^que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Contrato sem informar contractId$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_adiantamento_depositante_contrato_com_contract_id_invalido() {

        //TODO Ajustar valor de contractId, sourceSystem e requestDate após definições
        String contractId = null;
        String sourceSystem = "ceri";
        String requestDate = "25/05/2021";

        Headers header = headerUtils.getHeader(
                new Header("Authorization", token)
        );

        contratoAdiantamentoDepositanteResponse = fornecimentoService.getResponseObject(
                ProjectType.UNARRANGED_ACCOUNTS_OVERDRAFT_CONTRACT_CORE,
                ROOT_JSON_DATA_PATH,
                JSON_CORE_DATA_NAME,
                header,
                UnarrangedAccountsOverdraftContractCore.class,
                URL_ADIANTAMENTO_DEPOSITANTE_CONTRATO_CORE,
                contractId,
                sourceSystem,
                requestDate
        );

        printJsonBradescoReport(contratoAdiantamentoDepositanteResponse);
        BradescoReporter.report(ReportStatus.PASSED, "GET realizado com contractId inválido - sucesso");
    }

    @Given("^que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Contrato com header invalido$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_adiantamento_depositante_contrato_com_header_invalido() {
        //TODO Ajustar valor de contractId, sourceSystem e requestDate após definições
        String contractId = "20007981025038";
        String sourceSystem = "ceri";
        String requestDate = null;

        Headers header = headerUtils.getHeader(
                new Header("Authorization", null)
        );

        contratoAdiantamentoDepositanteResponse = fornecimentoService.getResponseObject(
                ProjectType.UNARRANGED_ACCOUNTS_OVERDRAFT_CONTRACT_CORE,
                ROOT_JSON_DATA_PATH,
                JSON_CORE_DATA_NAME,
                header,
                UnarrangedAccountsOverdraftContractCore.class,
                URL_ADIANTAMENTO_DEPOSITANTE_CONTRATO_CORE,
                contractId,
                sourceSystem,
                requestDate
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
                JSON_CORE_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH,
                JSON_CORE_SCHEMA_NAME
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