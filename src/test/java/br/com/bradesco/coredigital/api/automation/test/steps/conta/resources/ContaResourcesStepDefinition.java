package br.com.bradesco.coredigital.api.automation.test.steps.conta.resources;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.supply.account.Resources;
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

public class ContaResourcesStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseObject<Resources> resourcesAccountResponse;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/account/";

    private final String JSON_RESOURCES_SCHEMA_NAME = "resources_account_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/account/";

    private final String JSON_RESOURCES_DATA_NAME = "resources_account_data";

    private final String URL_CONTA_RESOURCES = "/resources/v1/resources";

    @Given("que seja feito uma requisição GET no endpoint de resources")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_resources() {

        String valueHeader = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ2ZXIiOiIxLjAiLCJpc3MiOiJodHRwczovL29wZW5iYW5raW5nPi9icmFuZC50b2tlbiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImp0aSI6Ijc5ODQ3MDcwLTY2MzYtNDc0YS1hMTg5LTY3MDcyNDZiMDhkOSIsImlhdCI6MTYyMjE1NDY4OSwiZXhwIjoxNjIyMTU4Mjg5LCJ0b2tlbklEIjoiR1VJRCBnZXJhZG8gcGFyYSBvIGFjZXNzLXRva2VuIiwic2NwIjoiQUNDT1VOVFNfUkVBRCBBQ0NPVU5UU19PVkVSRFJBRlRfTElNSVRTX1JFQUQgUkVTT1VSQ0VTX1JFQUQiLCJkYXRhIjp7ImNvbnNlbnRJRCI6IjEyMzQ1NiJ9LCJ1c2VyLmluZm8iOnsidXNlcklkIjoiMTIzMTIzMTIiLCJicmFuY2giOiIwMDAxIiwiYWNjb3VudCI6IjEyMzQ1NjciLCJhY2NvdW50RGlnaXQiOiIxIiwiaG9sZGVyIjoiMDAifSwidXNlci5hdXRoIjp7ImNoYW5uZWxTZXNzSUQiOiI8bsO6bWVybyBxdWUgaWRlbnRpZmljYSBhIHNlc3PDo28gZG8gY2FuYWw-IiwiRGV2aWNlSUQiOiI8aW5mb3JtYcOnw7VlcyBkbyBkaXNwb3NpdGl2byBkbyB1c3XDoXJpbz4iLCJzdGF0ZWxlc3Mtb3BlbiI6ImV5SndaWEpwWm1WeWFXTnZJam9pUVZWVVQwRlVSVTVFU1UxRlRsUlBJaXdpYVdScGIyMWhJam94TENKallXNWhiQ0k2TmpZc0ltVnRjSEpsYzJFaU9qSXpOeXdpZFhWcFpDSTZJakEzT1RVMU1URXdMVGt5T0RrdE5HUTFaQzFpTVRVeUxXUmlabVF5TURVMk4ySmpPU0lzSW1SbGNHVnVaR1Z1WTJsaElqb3hmUT09Iiwic3RhdGVsZXNzLWNsb3NlZCI6ImV5Sm1jbmRySWpwN0luUnBZMnRsZENJNklqbERSVVF6UlVSRk5qazFNMFkwTnpJaUxDSnBaSE5sYzNOaGJ5STZJakF3TURORE1EYzBRakEyUXpJd01sZ3dNa1ZEUXpVeFFUYzBSVEF6UVRrNElpd2lkWE4xWVhKcGJ5STZJakF6T1RnM01EQXdNREF3TURFd01qQXdPREF4SWl3aWRHbHdiMVZ6ZFdGeWFXOGlPaUpVVWxWVFZDSjlmUT09In19.yad4IPrAg2Iq7BssuL11OjwG01gP7vxlCg2kdvURZ1Y";

        Headers header = headerUtils.getHeader(
                new Header("Authorization", valueHeader)
        );
        resourcesAccountResponse = fornecimentoService.getResponseObject(ProjectType.ACCOUNT_RESOURCES, ROOT_JSON_DATA_PATH,
                JSON_RESOURCES_DATA_NAME, header, Resources.class, URL_CONTA_RESOURCES);
        printJsonBradescoReport(resourcesAccountResponse);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {
        isValidSchema = fornecimentoService.validateSchema(
                ROOT_JSON_DATA_PATH,
                JSON_RESOURCES_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH,
                JSON_RESOURCES_SCHEMA_NAME
        );
        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = resourcesAccountResponse.getHttpCode();
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
