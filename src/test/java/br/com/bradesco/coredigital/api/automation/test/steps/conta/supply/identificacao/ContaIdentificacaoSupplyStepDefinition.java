package br.com.bradesco.coredigital.api.automation.test.steps.conta.supply.identificacao;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.supply.account.IdentificationSupply;
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

public class ContaIdentificacaoSupplyStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseObject<IdentificationSupply> identificacaoContaResponse;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/account/";

    private final String JSON_SUPPLY_SCHEMA_NAME = "identification_account_supply_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/account/";

    private final String JSON_SUPPLY_DATA_NAME = "identification_account_supply_data";

    private final String URL_CONTA_IDENTIFICACAO_SUPPLY = "/{0}/open-banking/accounts/v1/accounts/{1}";

    @Given("que seja feito uma requisição GET no endpoint de Identificação da Conta")
    public void que_seja_feito_uma_requisição_get_no_endpoint_de_identificacao_da_conta() {

        String brand = "bradesco";
        String resourceId = "c008afe9fecec77c4c0bf9d0953ed51093dfe89120c0035b01a4b5edb1457320edba0bb44d0b9914c46bcd2b339fb113";
        String valueHeader = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ2ZXIiOiIxLjAiLCJpc3MiOiJodHRwczovL29wZW5iYW5raW5nPi9icmFuZC50b2tlbiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImp0aSI6Ijc5ODQ3MDcwLTY2MzYtNDc0YS1hMTg5LTY3MDcyNDZiMDhkOSIsImlhdCI6MTYyMjE1NDY4OSwidG9rZW5JRCI6IkdVSUQgZ2VyYWRvIHBhcmEgbyBhY2Vzcy10b2tlbiIsInNjcCI6IkFDQ09VTlRTX1JFQUQgQUNDT1VOVFNfQkFMQU5DRVNfUkVBRCBBQ0NPVU5UU19UUkFOU0FDVElPTlNfUkVBRCBBQ0NPVU5UU19PVkVSRFJBRlRfTElNSVRTX1JFQUQiLCJjb25zZW50LmRhdGEiOnsiY29uc2VudElkIjoiMDI5MzBhZDUtYzYxMy00NzNhLWI3MDItYTgwYTlmMGNlZjQ2IiwiY2xpZW50SWQiOiJJZGVudGlmaWNhZG9yIGRvIFRQUCIsInBlcm1pc3Npb25zIjpbIkFDQ09VTlRTX1JFQUQiLCJBQ0NPVU5UU19CQUxBTkNFU19SRUFEIiwiQUNDT1VOVFNfVFJBTlNBQ1RJT05TX1JFQUQiLCJBQ0NPVU5UU19PVkVSRFJBRlRfTElNSVRTX1JFQUQiXX0sInVzZXIuaW5mbyI6eyJ1c2VySWQiOiI1MjI1NzYwNjQzNCJ9LCJ1c2VyLmF1dGgiOnsiY2hhbm5lbFNlc3NJRCI6IiIsIkRldmljZUlEIjoiIn19.RrpO--zevNdXOIbjI8NzVYyY-VuvbRdtA3vSP_dDD1o";

        Headers header = headerUtils.getHeader(
                new Header("Authorization", valueHeader)
        );
        identificacaoContaResponse = fornecimentoService.getResponseObject(ProjectType.ACCOUNT_IDENTIFICATION_SUPPLY, ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME, header, IdentificationSupply.class, URL_CONTA_IDENTIFICACAO_SUPPLY, brand, resourceId);
        printJsonBradescoReport(identificacaoContaResponse);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = identificacaoContaResponse.getHttpCode();
        BradescoReporter.report(ReportStatus.PASSED, "Validação do status code feita com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {

        isValidSchema = fornecimentoService.validateSchema(
                ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH,
                JSON_SUPPLY_SCHEMA_NAME
        );
        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @Then("o status code deve ser (\\d+)")
    public void o_status_code_deve_ser(int code) {

        assertEquals(code, statusCode);
        BradescoReporter.report(ReportStatus.PASSED, "Status code é válido");
    }

    @Then("o schema deve ser válido")
    public void o_schema_deve_ser_valido() {

        assertTrue(isValidSchema);
        BradescoReporter.report(ReportStatus.PASSED, "Schema é válido");
    }
}
