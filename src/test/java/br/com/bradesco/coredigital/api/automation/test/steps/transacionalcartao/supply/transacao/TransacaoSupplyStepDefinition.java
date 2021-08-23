package br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.supply.transacao;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseListData;
import br.com.bradesco.coredigital.api.automation.model.response.supply.card.TransactionSupply;
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

public class TransacaoSupplyStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseListData<TransactionSupply> transacaoCartaoResponse;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/card/";

    private final String JSON_SUPPLY_SCHEMA_NAME = "card_transaction_supply_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/card/";

    private final String JSON_SUPPLY_DATA_NAME = "card_transaction_supply_data";

    private final String URL_CARTAO_TRANSACAO_SUPPLY = "/accounts/v1/credit-cards/{0}/{1}/transactions?fromTransactionDate={2}&toTransactionDate={3}&page={4}&page-size={5}";

    @Given("que seja feito uma requisição GET no endpoint de Transação de Cartões informando a \"([^\"]*)\" e o \"([^\"]*)\"$")
    public void que_seja_feito_uma_requisição_GET_no_endpoint_de_Transação_de_Cartões_informando_a_e_o(String brand, String creditCardNumber) {

        String fromTransactionDate = "2021-01-01";
        String toTransactionDate = "2021-06-30";
        long page = 1 ;
        long pageSize = 50;

        String headerName = "Authorization";
        String headerValue = "Bearer eyJhbGciOiJub25lIn0.ewogICJzdGF0dXMiOiAiQUNUSVZFIiwKICAiaXNzIjogImJyYWRlc2NvLW9iIiwKICAiYXVkIjogImh0dHBzOi8vIG9wZW5iYW5raW5nPiIsCiAgImV4cCI6IDE0MzIxNDMyMTQzMiwKICAiaWF0IjogNTQzMjE0NTMyMTM0LAogICJuYmYiOiA0MzIxNDMyNDMyMTQsCiAgImtpZCI6ICI0NzgzOTIxNzQ4OTIzIiwKICAianRpIjogMzQyMzQzMjU0MzQzLAogICJzdWIiOiAiY3BmLTR1M2kyMDI0ODkwMiIsCiAgInNjcCI6ICJvcGVuaWQgYWNjb3VudHMgY3JlZGl0LWNhcmRzLWFjY291bnRzIiwKICAiY2VydGlmaWNhdGUtZG4iOiAiQ049UXVpY2tib29rcyBQcm8sIE9VPVF1aWNrYm9va3MgUHJvZCwgTz1JbnR1aXQsIEM9QlIiLAogICJjb25zZW50LmRhdGEiOiB7CiAgICAiY29uc2VudElkIjogIjEyMyIsCiAgICAiY2xpZW50SWQiOiAiSWRlbnRpZmljYWRvciBkbyBUUFAiLAogICAgInBlcm1pc3Npb25zIjogWwogICAgICAiQUNDT1VOVFNfUkVBRCIsCiAgICAgICJDUkVESVRfQ0FSRFNfQUNDT1VOVFNfVFJBTlNBQ1RJT05TX1JFQUQiCiAgICBdCiAgfSwKICAidXNlci5pbmZvIjogewogICAgInVzZXJJZCI6ICIxMjMxMjMxMiIsCiAgICAiYnVzaW5lc3NJZCI6ICIiCiAgfQp9.";

        Headers header = headerUtils.getHeader(
                new Header(headerName, headerValue));

        transacaoCartaoResponse = fornecimentoService.getResponseListData(ProjectType.CARD_TRANSACTION_SUPPLY, ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME, header, TransactionSupply.class, URL_CARTAO_TRANSACAO_SUPPLY, brand, creditCardNumber,
                fromTransactionDate,toTransactionDate,page,pageSize);

        printJsonBradescoReport(transacaoCartaoResponse);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Given("que seja feito uma requisição GET no endpoint de Transações Cartões com permissão inválida")
    public void que_seja_feito_uma_requisição_GET_no_endpoint_de_Transações_Cartões_com_permissão_inválida() {

        String fromTransactionDate = "2021-01-01";
        String toTransactionDate = "2021-06-30";
        long page = 1 ;
        long pageSize = 50;

        String brand = "bradesco";
        String creditCardNumber = "178582x8582199";

        String headerName = "Authorization";
        String headerValue = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdGF0dXMiOiJBQ1RJVkUiLCJpc3MiOiJicmFkZXNjby1vYiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImV4cCI6MTQzMjE0MzIxNDMyLCJpYXQiOjU0MzIxNDUzMjEzNCwibmJmIjo0MzIxNDMyNDMyMTQsImtpZCI6IjQ3ODM5MjE3NDg5MjMiLCJqdGkiOjM0MjM0MzI1NDM0Mywic3ViIjoiY3BmLTR1M2kyMDI0ODkwMiIsInNjcCI6Im9wZW5pZCBhY2NvdW50cyBjcmVkaXQtY2FyZHMtYWNjb3VudHMiLCJjZXJ0aWZpY2F0ZS1kbiI6IkNOPVF1aWNrYm9va3MgUHJvLCBPVT1RdWlja2Jvb2tzIFByb2QsIE89SW50dWl0LCBDPUJSIiwiY29uc2VudC5kYXRhIjp7ImNvbnNlbnRJZCI6IjEyMyIsImNsaWVudElkIjoiSWRlbnRpZmljYWRvciBkbyBUUFAiLCJwZXJtaXNzaW9ucyI6WyJBQ0NPVU5UU19SRUFEIiwiQ1JFRElUX0NBUkRTX0FDQ09VTlRTX0xJTUlUU19SRUFEIl19LCJ1c2VyLmluZm8iOnsidXNlcklkIjoiMTIzMTIzMTIiLCJidXNpbmVzc0lkIjoiIn19.";

        Headers header = headerUtils.getHeader(
                new Header(headerName, headerValue));

        transacaoCartaoResponse = fornecimentoService.getResponseListData(ProjectType.CARD_TRANSACTION_SUPPLY, ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME, header, TransactionSupply.class, URL_CARTAO_TRANSACAO_SUPPLY, brand, creditCardNumber,
                fromTransactionDate, toTransactionDate, page, pageSize);

        printJsonBradescoReport(transacaoCartaoResponse);
        BradescoReporter.report(ReportStatus.PASSED, "Get com permissão inválida feito com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {

        isValidSchema = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_SUPPLY_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_SUPPLY_SCHEMA_NAME);
        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = transacaoCartaoResponse.getHttpCode();
        BradescoReporter.report(ReportStatus.PASSED, "Validação do status feito com sucesso");
    }

    @Then("o schema deve ser válido")
    public void o_schema_deve_ser_valido() {

        assertTrue(isValidSchema);
        BradescoReporter.report(ReportStatus.PASSED, "Schema é válido");
    }

    @Then("o status code deve ser (\\d+)")
    public void o_status_code_deve_ser(int code) {

        assertEquals(code, statusCode);
        BradescoReporter.report(ReportStatus.PASSED, "Status é válido");
    }
}
