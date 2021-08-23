package br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.supply.limite;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseListData;
import br.com.bradesco.coredigital.api.automation.model.response.supply.card.LimitSupply;
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

public class LimiteSupplyStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseListData<LimitSupply> limiteCartaoResponse;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/card/";

    private final String JSON_SUPPLY_SCHEMA_NAME = "card_limit_supply_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/card/";

    private final String JSON_SUPPLY_DATA_NAME = "card_limit_supply_data";

    private final String URL_CARTAO_LIMITE_SUPPLY = "/opbk-supply-credit-card-limit/{0}/accounts/{1}/limits";

    @Given("que seja feito uma requisição GET no endpoint de Limite de Cartões informando a \"([^\"]*)\" e o \"([^\"]*)\"$")
    public void que_seja_feito_uma_requisição_GET_no_endpoint_de_Limite_de_Cartoes_informando_a_e_o(String brand, String creditCardNumber) {

        if (creditCardNumber == "HdcmcXa19UDAHAd_8KE3sbYrj36XZ1lWsg6BDJIOWitDX7Gq0TEgDuqI-ITKx71-weKUDOb3WMQtsxmMz-S3Eg") {

            String Name = "Authorization";
            String Value = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ2ZXIiOiIxLjAiLCJpc3MiOiJodHRwczovL29wZW5iYW5raW5nPi9icmFuZC50b2tlbiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImp0aSI6Ijc5ODQ3MDcwLTY2MzYtNDc0YS1hMTg5LTY3MDcyNDZiMDhkOSIsImlhdCI6MTYyMjE1NDY4OSwidG9rZW5JRCI6IkdVSUQgZ2VyYWRvIHBhcmEgbyBhY2Vzcy10b2tlbiIsInNjcCI6ImNyZWRpdC1jYXJkIiwiY29uc2VudC5kYXRhIjp7ImNvbnNlbnRJZCI6IjcwOGY0MDY0LWI1MTctNDYwNC04NTNlLTQyM2E2OTQ3MjAyOSIsImNsaWVudElkIjoiSWRlbnRpZmljYWRvciBkbyBUUFAiLCJwZXJtaXNzaW9ucyI6WyJDUkVESVRfQ0FSRFNfQUNDT1VOVFNfTElNSVRTX1JFQUQiXX0sInVzZXIuaW5mbyI6eyJ1c2VySWQiOiIzMjQwNDM0NDA3MiIsImJ1c2luZXNzSWQiOiIifX0.tVcdyy2AXbWqyeY33rkqQS2bdN20Nuzt9fU3_yspReg";

            Headers header = headerUtils.getHeader(
                    new Header(Name, Value));

            limiteCartaoResponse = fornecimentoService.getResponseListData(ProjectType.CARD_LIMIT_SUPPLY, ROOT_JSON_DATA_PATH,
                    JSON_SUPPLY_DATA_NAME, header, LimitSupply.class, URL_CARTAO_LIMITE_SUPPLY, brand, creditCardNumber);
        }

        else if (creditCardNumber == "U4mFA8o-Xsc-_-rnaQZBvbCDK8h-0Lv5-MPyIFgvBSgw_ROr5R12XVzqUsPEPr1gVeBL1n2pvPxQEgCZFKJDNA"){

            String Name = "Authorization";
            String Value = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ2ZXIiOiIxLjAiLCJpc3MiOiJodHRwczovL29wZW5iYW5raW5nPi9icmFuZC50b2tlbiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImp0aSI6Ijc5ODQ3MDcwLTY2MzYtNDc0YS1hMTg5LTY3MDcyNDZiMDhkOSIsImlhdCI6MTYyMjE1NDY4OSwidG9rZW5JRCI6IkdVSUQgZ2VyYWRvIHBhcmEgbyBhY2Vzcy10b2tlbiIsInNjcCI6ImNyZWRpdC1jYXJkIiwiY29uc2VudC5kYXRhIjp7ImNvbnNlbnRJZCI6ImM5OGUwMmE3LTYwYmItNGVjMi1hNjg0LWFlYmE5MmIxMWZkZSIsImNsaWVudElkIjoiSWRlbnRpZmljYWRvciBkbyBUUFAiLCJwZXJtaXNzaW9ucyI6WyJDUkVESVRfQ0FSRFNfQUNDT1VOVFNfTElNSVRTX1JFQUQiXX0sInVzZXIuaW5mbyI6eyJ1c2VySWQiOiIiLCJidXNpbmVzc0lkIjoiNTMyMTAyMzIwMDAxMzAifX0.KbGWjJsJBKjhDUX5EIJtS0BmDx5AWfWyqSWTGEfOY18";

            Headers header = headerUtils.getHeader(
                    new Header(Name, Value));

            limiteCartaoResponse = fornecimentoService.getResponseListData(ProjectType.CARD_LIMIT_SUPPLY, ROOT_JSON_DATA_PATH,
                    JSON_SUPPLY_DATA_NAME, header, LimitSupply.class, URL_CARTAO_LIMITE_SUPPLY, brand, creditCardNumber);
            }

        else if (creditCardNumber == "C_Bhth48W7Y5RYLjgi8W4xrAn61vPKo_prtmzWRUcTk2ocUwhchHHF8dquT380mM3FFpS12hwR_PXLqHreQG6w"){

            String Name = "Authorization";
            String Value = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ2ZXIiOiIxLjAiLCJpc3MiOiJodHRwczovL29wZW5iYW5raW5nPi9icmFuZC50b2tlbiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImp0aSI6Ijc5ODQ3MDcwLTY2MzYtNDc0YS1hMTg5LTY3MDcyNDZiMDhkOSIsImlhdCI6MTYyMjE1NDY4OSwidG9rZW5JRCI6IkdVSUQgZ2VyYWRvIHBhcmEgbyBhY2Vzcy10b2tlbiIsInNjcCI6ImNyZWRpdC1jYXJkIiwiY29uc2VudC5kYXRhIjp7ImNvbnNlbnRJZCI6IjI2YWQ2MmMzLTQ1MTItNDNjMi05MDUwLWMxOThhYjgwYzIwOSIsImNsaWVudElkIjoiSWRlbnRpZmljYWRvciBkbyBUUFAiLCJwZXJtaXNzaW9ucyI6WyJDUkVESVRfQ0FSRFNfQUNDT1VOVFNfTElNSVRTX1JFQUQiXX0sInVzZXIuaW5mbyI6eyJ1c2VySWQiOiI0MDc0MjIyNTA3MCIsImJ1c2luZXNzSWQiOiIifX0.29N_rESMn1yuMtsAn8Kc_GHEDFwJG1SVodeXYQRNrBQ";

            Headers header = headerUtils.getHeader(
                    new Header(Name, Value));

            limiteCartaoResponse = fornecimentoService.getResponseListData(ProjectType.CARD_LIMIT_SUPPLY, ROOT_JSON_DATA_PATH,
                    JSON_SUPPLY_DATA_NAME, header, LimitSupply.class, URL_CARTAO_LIMITE_SUPPLY, brand, creditCardNumber);
        }

        else if (creditCardNumber == "dCzr9e9_CpTC7BYbxA8jVUqufC1CFjxuUnCA204IldDXKNU7sg7FA_AEh25GBU9VYeuu5a-G9cfSvGVdtN3ASQ"){

            String Name = "Authorization";
            String Value = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ2ZXIiOiIxLjAiLCJpc3MiOiJodHRwczovL29wZW5iYW5raW5nPi9icmFuZC50b2tlbiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImp0aSI6Ijc5ODQ3MDcwLTY2MzYtNDc0YS1hMTg5LTY3MDcyNDZiMDhkOSIsImlhdCI6MTYyMjE1NDY4OSwidG9rZW5JRCI6IkdVSUQgZ2VyYWRvIHBhcmEgbyBhY2Vzcy10b2tlbiIsInNjcCI6ImNyZWRpdC1jYXJkIiwiY29uc2VudC5kYXRhIjp7ImNvbnNlbnRJZCI6ImE3NWU2NDUwLTkyYjAtNDRjNy05YjViLWI0ODUxYzcwODU0OCIsImNsaWVudElkIjoiSWRlbnRpZmljYWRvciBkbyBUUFAiLCJwZXJtaXNzaW9ucyI6WyJDUkVESVRfQ0FSRFNfQUNDT1VOVFNfTElNSVRTX1JFQUQiXX0sInVzZXIuaW5mbyI6eyJ1c2VySWQiOiI2ODIzOTI0NzgwNiIsImJ1c2luZXNzSWQiOiIifX0.Uvj01z-Ma1RH84IQECfcaEcFBY1Qe4QU_KL9N-dg8AU";

            Headers header = headerUtils.getHeader(
                    new Header(Name, Value));

            limiteCartaoResponse = fornecimentoService.getResponseListData(ProjectType.CARD_LIMIT_SUPPLY, ROOT_JSON_DATA_PATH,
                    JSON_SUPPLY_DATA_NAME, header, LimitSupply.class, URL_CARTAO_LIMITE_SUPPLY, brand, creditCardNumber);
        }

        printJsonBradescoReport(limiteCartaoResponse);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Given("que seja feito uma requisição GET no endpoint de Limites Cartões com permissão inválida")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_Limites_Cartoes_com_permissao_invalida() {

        String brand = "bradesco";
        String creditCardNumber = "HdcmcXa19UDAHAd_8KE3sbYrj36XZ1lWsg6BDJIOWitDX7Gq0TEgDuqI-ITKx71-weKUDOb3WMQtsxmMz-S3Eg";
        String Name = "Authorization";
        String Value = "Bearer eyJhbGciOiJub25lIn0.ewogICAgInN0YXR1cyI6ICJBQ1RJVkUiLAogICAgImlzcyI6ICJicmFkZXNjby1vYiIsCiAgICAiYXVkIjogImh0dHBzOi8vIG9wZW5iYW5raW5nPiIsCiAgICAiZXhwIjogMTQzMjE0MzIxNDMyLAogICAgImlhdCI6IDU0MzIxNDUzMjEzNCwKICAgICJuYmYiOiA0MzIxNDMyNDMyMTQsCiAgICAia2lkIjogIjQ3ODM5MjE3NDg5MjMiLAogICAgImp0aSI6IDM0MjM0MzI1NDM0MywKICAgICJzdWIiOiAiY3BmLTR1M2kyMDI0ODkwMiIsCiAgICAic2NwIjogIm9wZW5pZCBhY2NvdW50cyBjcmVkaXQtY2FyZHMtYWNjb3VudHMiLAogICAgImNlcnRpZmljYXRlLWRuIjogIkNOPVF1aWNrYm9va3MgUHJvLCBPVT1RdWlja2Jvb2tzIFByb2QsIE89SW50dWl0LCBDPUJSIiwKICAgICJjb25zZW50LmRhdGEiOiB7CiAgICAgICAgImNvbnNlbnRJZCI6ICIxMjMiLAogICAgICAgICJjbGllbnRJZCI6ICJJZGVudGlmaWNhZG9yIGRvIFRQUCIsCiAgICAgICAgInBlcm1pc3Npb25zIjogWwogICAgICAgICAgICAiQUNDT1VOVFNfUkVBRCIsCiAgICAgICAgICAgICJDUkVESVRfQ0FSRFNfQUNDT1VOVFNfQklMTFNfUkVBRCIKICAgICAgICBdCiAgICB9LCAgCiAgICAidXNlci5pbmZvIjogewogICAgICAgICJ1c2VySWQiOiAiMTIzMTIzMTIiLAogICAgICAgICJidXNpbmVzc0lkIjogIiIKICAgICAgfQp9.";

        Headers header = headerUtils.getHeader(
                new Header(Name, Value));

        limiteCartaoResponse = fornecimentoService.getResponseListData(ProjectType.CARD_LIMIT_SUPPLY, ROOT_JSON_DATA_PATH,
                JSON_SUPPLY_DATA_NAME, header, LimitSupply.class, URL_CARTAO_LIMITE_SUPPLY, brand, creditCardNumber);

        printJsonBradescoReport(limiteCartaoResponse);
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

        statusCode = limiteCartaoResponse.getHttpCode();
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
