package br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.supply.identificacao;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.supply.card.IdentificationSupply;
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

public class CartaoSupplyStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseObject<IdentificationSupply> identificacaoCartaoResponse;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/card/";

    private final String JSON_SUPPLY_SCHEMA_NAME = "card_identification_supply_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/card/";

    private final String JSON_SUPPLY_DATA_NAME = "card_identification_supply_data";

    private final String URL_CARTAO_IDENTIFICACAO_SUPPLY = "/accounts/v1/credit-cards/{0}/{1}";

    @Given("que seja feito uma requisição GET no endpoint de Identificação de Cartões informando a \"([^\"]*)\" e o \"([^\"]*)\"$")
    public void que_seja_feito_uma_requisição_GET_no_endpoint_de_Identificação_de_Cartões_informando_a_e_o(String brand, String creditCardNumber) {

        String headerName = "Authorization";
        String headerValue = "Bearer eyJhbGciOiJub25lIn0.eyJ2ZXIiOiIxLjAiLCJpc3MiOiJOb21lIGRhIE1hcmNhL0NhbmFsIGNhZGFzdHJhZG8iLCJzdWIiOiJDbGllbnRfaWQgZ2VyYWRvIHBlbG8gT1BCSyIsImF1ZCI6ImJyYW5kLnRva2VuIiwiaWF0IjoxMDAxMDAxMDEsImV4cCI6NDA5NDgyMzIxOCwianRpIjoiYXNkYXMtYXNkZGFzZC1hc2RhcyIsInNjcCI6IkFDQ09VTlRTX1JFQUQgQ1JFRElUX0NBUkRTX0FDQ09VTlRTX0lERU5USUZJQ0FUSU9OX1JFQUQiLCJ1c2VyLmluZm8iOnsidXNlcklkIjoiMjU0NDczOTgwMDIiLCJidXNpbmVzc0lkIjoiIiwiYnJhbmNoIjoiMDAwMDEiLCJhY2NvdW50IjoiMTIzNDU2NyIsImFjY291bnREaWdpdCI6IjAyIiwiaG9sZGVyIjoiMDAifSwiZGF0YSI6eyJjb25zZW50SWQiOiIxMDAwIiwiY2xpZW50SWQiOiJDbGllbnRlIn19.";

        Headers header = headerUtils.getHeader(
                new Header(headerName, headerValue));

        identificacaoCartaoResponse = fornecimentoService.getResponseObject(ProjectType.CARD_IDENTIFICATION_SUPPLY, ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME, header, IdentificationSupply.class, URL_CARTAO_IDENTIFICACAO_SUPPLY, brand, creditCardNumber);

        printJsonBradescoReport(identificacaoCartaoResponse);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Given("que seja feito uma requisição GET no endpoint de Identificação Cartões com permissão inválida")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_Identificacao_Cartoes_com_permissao_invalida() {

        String brand = "bradesco";
        String creditCardNumber = "178582x8582199";
        String headerName = "Authorization";
        String headerValue = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdGF0dXMiOiJBQ1RJVkUiLCJpc3MiOiJicmFkZXNjby1vYiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImV4cCI6IjE0MzIxNDMyMTQzMiIsImlhdCI6NTQzMjE0NTMyMTM0LCJuYmYiOjQzMjE0MzI0MzIxNCwia2lkIjo0NzgzOTIxNzQ4OTIzLCJqdGkiOiIzNDIzNDMyNTQzNDMiLCJzdWIiOiJjcGYtNHUzaTIwMjQ4OTAyIiwic2NwIjoib3BlbmlkIGFjY291bnRzIGNyZWRpdC1jYXJkcy1hY2NvdW50cyIsImNlcnRpZmljYXRlLWRuIjoiQ049UXVpY2tib29rcyBQcm8sIE9VPVF1aWNrYm9va3MgUHJvZCwgTz1JbnR1aXQsIEM9QlIiLCJjb25zZW50LmRhdGEiOnsiY29uc2VudElEIjoiMTIzIiwiY2xpZW50SWQiOiJJZGVudGlmaWNhZG9yIGRvIFRQUCIsInBlcm1pc3Npb25zIjpbIkFDQ09VTlRTX1JFQUQiLCJDUkVESVRfQ0FSRFNfQUNDT1VOVFNfTElNSVRTX1JFQUQiXX0sInVzZXIuaW5mbyI6eyJ1c2VySWQiOiIxMjMxMjMxMiIsImJ1c2luZXNzSWQiOiIifSwiYWxnIjoiSFMyNTYifQ.";

        Headers header = headerUtils.getHeader(
                new Header(headerName, headerValue));

        identificacaoCartaoResponse = fornecimentoService.getResponseObject(ProjectType.CARD_IDENTIFICATION_SUPPLY, ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME, header, IdentificationSupply.class, URL_CARTAO_IDENTIFICACAO_SUPPLY, brand, creditCardNumber);

        printJsonBradescoReport(identificacaoCartaoResponse);
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

        statusCode = identificacaoCartaoResponse.getHttpCode();
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
