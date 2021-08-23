package br.com.bradesco.coredigital.api.automation.test.steps.conta.core.limites;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.core.account.LimitCore;
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

public class ContaLimitesCoreStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseObject<LimitCore> limitesContaResponse;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/account/";

    private final String JSON_CORE_SCHEMA_NAME = "limits_account_core_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/account/";

    private final String JSON_CORE_DATA_NAME = "limits_account_core_data";

    private final String URL_CONTA_LIMITES_CORE = "/accounts/overdraft-limits/{0}/{1}/{2}?accountType={3}";

    @Given("que seja feito uma requisição GET no endpoint de Limites da Conta")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_limites_da_conta() {

        String agency = "3987";
        String account = "0011658";
        String accountDigit = "0";
        String accountType = "cc";
        String valueHeader = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ2ZXIiOiIxLjAiLCJpc3MiOiJodHRwczovL29wZW5iYW5raW5nPi9icmFuZC50b2tlbiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImp0aSI6Ijc5ODQ3MDcwLTY2MzYtNDc0YS1hMTg5LTY3MDcyNDZiMDhkOSIsImlhdCI6MTYyMjE1NDY4OSwidG9rZW5JRCI6IkdVSUQgZ2VyYWRvIHBhcmEgbyBhY2Vzcy10b2tlbiIsInNjcCI6IkFDQ09VTlRTX1JFQUQgQUNDT1VOVFNfQkFMQU5DRVNfUkVBRCBBQ0NPVU5UU19UUkFOU0FDVElPTlNfUkVBRCBBQ0NPVU5UU19PVkVSRFJBRlRfTElNSVRTX1JFQUQiLCJjb25zZW50LmRhdGEiOnsiY29uc2VudElkIjoiZTk5ZWJjNTQtYzcxZS00NjAxLWE0OWUtYWJjYWVhNTI4MjQ5IiwiY2xpZW50SWQiOiJJZGVudGlmaWNhZG9yIGRvIFRQUCIsInBlcm1pc3Npb25zIjpbIkFDQ09VTlRTX1JFQUQiLCJBQ0NPVU5UU19CQUxBTkNFU19SRUFEIiwiQUNDT1VOVFNfVFJBTlNBQ1RJT05TX1JFQUQiLCJBQ0NPVU5UU19PVkVSRFJBRlRfTElNSVRTX1JFQUQiXX0sInVzZXIuaW5mbyI6eyJ1c2VySWQiOiI1Mjc1NTY3ODQ3MCJ9LCJ1c2VyLmF1dGgiOnsiY2hhbm5lbFNlc3NJRCI6IiIsIkRldmljZUlEIjoiIn19.RrpO--zevNdXOIbjI8NzVYyY-VuvbRdtA3vSP_dDD1o";

        Headers header = headerUtils.getHeader(
                new Header("Authorization", valueHeader)
        );

        limitesContaResponse = fornecimentoService.getResponseObject(ProjectType.ACCOUNT_LIMIT_CORE, ROOT_JSON_DATA_PATH,
                JSON_CORE_DATA_NAME, header, LimitCore.class, URL_CONTA_LIMITES_CORE, agency, account, accountDigit, accountType);
        printJsonBradescoReport(limitesContaResponse);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {
        isValidSchema = fornecimentoService.validateSchema(
                ROOT_JSON_DATA_PATH,
                JSON_CORE_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH,
                JSON_CORE_SCHEMA_NAME
        );
        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = limitesContaResponse.getHttpCode();
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
