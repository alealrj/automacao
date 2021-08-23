package br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.supply.fatura;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseListData;
import br.com.bradesco.coredigital.api.automation.model.response.supply.card.BillSupply;
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

public class FaturaSupplyStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseListData<BillSupply> faturaCartaoResponse;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/card/";

    private final String JSON_SUPPLY_SCHEMA_NAME = "card_bill_supply_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/card/";

    private final String JSON_SUPPLY_DATA_NAME = "card_bill_supply_data";

    private final String URL_CARTAO_FATURA_SUPPLY = "/accounts/v1/credit-cards/{0}/{1}/bills";

    @Given("que seja feito uma requisição GET no endpoint de Fatura de Cartões informando a \"([^\"]*)\" e o \"([^\"]*)\"$")
    public void que_seja_feito_uma_requisição_GET_no_endpoint_de_Fatura_de_Cartões_informando_a_e_o(String brand, String creditCardNumber){

        String headerName = "Authorization";
        String headerValue = "Bearer eyJhbGciOiJub25lIn0.ewogICJzdGF0dXMiOiAiQUNUSVZFIiwKICAiaXNzIjogImJyYWRlc2NvLW9iIiwKICAiYXVkIjogImh0dHBzOi8vIG9wZW5iYW5raW5nPiIsCiAgImV4cCI6IDE0MzIxNDMyMTQzMiwKICAiaWF0IjogNTQzMjE0NTMyMTM0LAogICJuYmYiOiA0MzIxNDMyNDMyMTQsCiAgImtpZCI6ICI0NzgzOTIxNzQ4OTIzIiwKICAianRpIjogMzQyMzQzMjU0MzQzLAogICJzdWIiOiAiY3BmLTR1M2kyMDI0ODkwMiIsCiAgInNjcCI6ICJvcGVuaWQgYWNjb3VudHMgY3JlZGl0LWNhcmRzLWFjY291bnRzIiwKICAiY2VydGlmaWNhdGUtZG4iOiAiQ049UXVpY2tib29rcyBQcm8sIE9VPVF1aWNrYm9va3MgUHJvZCwgTz1JbnR1aXQsIEM9QlIiLAogICJjb25zZW50LmRhdGEiOiB7CiAgICAiY29uc2VudElkIjogIjEyMyIsCiAgICAiY2xpZW50SWQiOiAiSWRlbnRpZmljYWRvciBkbyBUUFAiLAogICAgInBlcm1pc3Npb25zIjogWwogICAgICAiQUNDT1VOVFNfUkVBRCIsCiAgICAgICJDUkVESVRfQ0FSRFNfQUNDT1VOVFNfQklMTFNfUkVBRCIKICAgIF0KICB9LAogICJ1c2VyLmluZm8iOiB7CiAgICAidXNlcklkIjogIjEyMzEyMzEyIiwKICAgICJidXNpbmVzc0lkIjogIiIKICB9Cn0=.";

        Headers header = headerUtils.getHeader(
                new Header(headerName, headerValue));

        faturaCartaoResponse = fornecimentoService.getResponseListData(ProjectType.CARD_LIMIT_SUPPLY, ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME, header, BillSupply.class, URL_CARTAO_FATURA_SUPPLY, brand, creditCardNumber);

        printJsonBradescoReport(faturaCartaoResponse);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Given("que seja feito uma requisição GET no endpoint de Fatura Cartões com permissão inválida")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_Fatura_Cartoes_com_permissao_invalida() {

        String brand = "bradesco";
        String creditCardNumber = "178582x8582199";
        String headerName = "Authorization";
        String headerValue = "Bearer eyJhbGciOiJub25lIn0.ewogICJzdGF0dXMiOiAiQUNUSVZFIiwKICAiaXNzIjogImJyYWRlc2NvLW9iIiwKICAiYXVkIjogImh0dHBzOi8vIG9wZW5iYW5raW5nPiIsCiAgImV4cCI6IDE0MzIxNDMyMTQzMiwKICAiaWF0IjogNTQzMjE0NTMyMTM0LAogICJuYmYiOiA0MzIxNDMyNDMyMTQsCiAgImtpZCI6ICI0NzgzOTIxNzQ4OTIzIiwKICAianRpIjogMzQyMzQzMjU0MzQzLAogICJzdWIiOiAiY3BmLTR1M2kyMDI0ODkwMiIsCiAgInNjcCI6ICJvcGVuaWQgYWNjb3VudHMgY3JlZGl0LWNhcmRzLWFjY291bnRzIiwKICAiY2VydGlmaWNhdGUtZG4iOiAiQ049UXVpY2tib29rcyBQcm8sIE9VPVF1aWNrYm9va3MgUHJvZCwgTz1JbnR1aXQsIEM9QlIiLAogICJjb25zZW50LmRhdGEiOiB7CiAgICAiY29uc2VudElkIjogIjEyMyIsCiAgICAiY2xpZW50SWQiOiAiSWRlbnRpZmljYWRvciBkbyBUUFAiLAogICAgInBlcm1pc3Npb25zIjogWwogICAgICAiQUNDT1VOVFNfUkVBRCIsCiAgICAgICJDUkVESVRfQ0FSRFNfQUNDT1VOVFNfUkVBRCIKICAgIF0KICB9LAogICJ1c2VyLmluZm8iOiB7CiAgICAidXNlcklkIjogIjEyMzEyMzEyIiwKICAgICJidXNpbmVzc0lkIjogIiIKICB9Cn0=.";

        Headers header = headerUtils.getHeader(
                new Header(headerName, headerValue));

        faturaCartaoResponse = fornecimentoService.getResponseListData(ProjectType.CARD_BILL_SUPPLY, ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME, header, BillSupply.class, URL_CARTAO_FATURA_SUPPLY, brand, creditCardNumber);

        printJsonBradescoReport(faturaCartaoResponse);
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

        statusCode = faturaCartaoResponse.getHttpCode();
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
