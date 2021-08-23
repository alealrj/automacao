package br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.supply.transacaofatura;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseListData;
import br.com.bradesco.coredigital.api.automation.model.response.supply.card.InvoiceTransactionSupply;
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

public class TransacaoFaturaSupplyStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseListData<InvoiceTransactionSupply> transacaoFaturaCartaoResponse;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/card/";

    private final String JSON_SUPPLY_SCHEMA_NAME = "card_invoice_transaction_supply_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/card/";

    private final String JSON_SUPPLY_DATA_NAME = "card_invoice_transaction_supply_data";

    private final String URL_CARTAO_TRANSACAO_FATURA_SUPPLY = "/credit-cards-accounts/v1/accounts/{0}/bills/{1}/transactions";

    @Given("que seja feito uma requisição GET no endpoint de Transação por Fatura de Cartões informando o \"([^\"]*)\" e o \"([^\"]*)\"$")
    public void que_seja_feito_uma_requisição_GET_no_endpoint_de_Transação_por_Fatura_de_Cartões_informando_o_e_o(String creditCardNumber, String billId) {

        String headerName = "Authorization";
        String headerValue = "Bearer eyJhbGciOiJub25lIn0.ewogICJzdGF0dXMiOiAiQUNUSVZFIiwKICAiaXNzIjogImJyYWRlc2NvLW9iIiwKICAiYXVkIjogImh0dHBzOi8vIG9wZW5iYW5raW5nPiIsCiAgImV4cCI6IDE0MzIxNDMyMTQzMiwKICAiaWF0IjogNTQzMjE0NTMyMTM0LAogICJuYmYiOiA0MzIxNDMyNDMyMTQsCiAgImtpZCI6ICI0NzgzOTIxNzQ4OTIzIiwKICAianRpIjogMzQyMzQzMjU0MzQzLAogICJzdWIiOiAiY3BmLTR1M2kyMDI0ODkwMiIsCiAgInNjcCI6ICJvcGVuaWQgYWNjb3VudHMgY3JlZGl0LWNhcmRzLWFjY291bnRzIiwKICAiY2VydGlmaWNhdGUtZG4iOiAiQ049UXVpY2tib29rcyBQcm8sIE9VPVF1aWNrYm9va3MgUHJvZCwgTz1JbnR1aXQsIEM9QlIiLAogICJjb25zZW50LmRhdGEiOiB7CiAgICAiY29uc2VudElkIjogIjEyMzQ1NiIsCiAgICAiY2xpZW50SWQiOiAiSWRlbnRpZmljYWRvciBkbyBUUFAiLAogICAgInBlcm1pc3Npb25zIjogWwogICAgICAiQUNDT1VOVFNfUkVBRCIsCiAgICAgICJDUkVESVRfQ0FSRFNfQUNDT1VOVFNfQklMTFNfVFJBTlNBQ1RJT05TX1JFQUQiCiAgICBdCiAgfSwKICAidXNlci5pbmZvIjogewogICAgInVzZXJJZCI6ICIxMjMxMjMxMiIsCiAgICAiYnVzaW5lc3NJZCI6ICIiCiAgfQp9.";

        Headers header = headerUtils.getHeader(
                new Header(headerName, headerValue));

        transacaoFaturaCartaoResponse = fornecimentoService.getResponseListData(ProjectType.CARD_INVOICE_TRANSACTION_SUPPLY, ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME, header, InvoiceTransactionSupply.class, URL_CARTAO_TRANSACAO_FATURA_SUPPLY, creditCardNumber, billId);

        printJsonBradescoReport(transacaoFaturaCartaoResponse);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Given("que seja feito uma requisição GET no endpoint de Transação por Fatura Cartões com permissão inválida")
    public void que_seja_feito_uma_requisição_GET_no_endpoint_de_Transação_por_Fatura_Cartões_com_permissão_inválida(){

        String creditCardNumber = "178582x8582199";
        String billId = "MTIwNTIwMjE=";
        String headerName = "Authorization";
        String headerValue = "Bearer eyJhbGciOiJub25lIn0.ewogICJzdGF0dXMiOiAiQUNUSVZFIiwKICAiaXNzIjogImJyYWRlc2NvLW9iIiwKICAiYXVkIjogImh0dHBzOi8vIG9wZW5iYW5raW5nPiIsCiAgImV4cCI6IDE0MzIxNDMyMTQzMiwKICAiaWF0IjogNTQzMjE0NTMyMTM0LAogICJuYmYiOiA0MzIxNDMyNDMyMTQsCiAgImtpZCI6ICI0NzgzOTIxNzQ4OTIzIiwKICAianRpIjogMzQyMzQzMjU0MzQzLAogICJzdWIiOiAiY3BmLTR1M2kyMDI0ODkwMiIsCiAgInNjcCI6ICJvcGVuaWQgYWNjb3VudHMgY3JlZGl0LWNhcmRzLWFjY291bnRzIiwKICAiY2VydGlmaWNhdGUtZG4iOiAiQ049UXVpY2tib29rcyBQcm8sIE9VPVF1aWNrYm9va3MgUHJvZCwgTz1JbnR1aXQsIEM9QlIiLAogICJjb25zZW50LmRhdGEiOiB7CiAgICAiY29uc2VudElkIjogIjEyMyIsCiAgICAiY2xpZW50SWQiOiAiSWRlbnRpZmljYWRvciBkbyBUUFAiLAogICAgInBlcm1pc3Npb25zIjogWwogICAgICAiQUNDT1VOVFNfUkVBRCIsCiAgICAgICJDUkVESVRfQ0FSRFNfQUNDT1VOVFNfQklMTFNfUkVBRCIKICAgIF0KICB9LAogICJ1c2VyLmluZm8iOiB7CiAgICAidXNlcklkIjogIiIsCiAgICAiYnVzaW5lc3NJZCI6ICIxMTExMTExMTExMTExMSIKICB9Cn0=.";

        Headers header = headerUtils.getHeader(
                new Header(headerName, headerValue));

        transacaoFaturaCartaoResponse = fornecimentoService.getResponseListData(ProjectType.CARD_INVOICE_TRANSACTION_SUPPLY, ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME, header, InvoiceTransactionSupply.class, URL_CARTAO_TRANSACAO_FATURA_SUPPLY, creditCardNumber, billId);

        printJsonBradescoReport(transacaoFaturaCartaoResponse);
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

        statusCode = transacaoFaturaCartaoResponse.getHttpCode();
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
