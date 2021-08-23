package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.supply.parcela;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.factory.authorization.PermissionAuthorizationFactory;
import br.com.bradesco.coredigital.api.automation.model.request.authorization.PermissionAuthorization;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.StatusObject;
import br.com.bradesco.coredigital.api.automation.model.response.supply.financing.FinancingScheduleInstalmentSupply;
import br.com.bradesco.coredigital.api.automation.service.FornecimentoService;
import br.com.bradesco.coredigital.api.automation.test.steps.AbstractStepDefinition;
import br.com.bradesco.coredigital.api.automation.utils.Base64Utils;
import com.bradesco.core.report.BradescoReporter;
import com.bradesco.core.sdk.enums.ReportStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.bradesco.core.report.Assert.assertEquals;
import static com.bradesco.core.report.Assert.assertTrue;

public class FinanciamentoParcelaSupplyStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private PermissionAuthorizationFactory permissionAuthorizationFactory;

    @Autowired
    private Base64Utils base64Utils;

    private ResponseObject<FinancingScheduleInstalmentSupply> financingScheduleInstalmentSupply;

    private ResponseObject<StatusObject> statusObject;

    private boolean isValidSchema;

    private int statusCode;

    private String statusApi;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/financing/";

    private final String JSON_SUPPLY_SCHEMA_NAME = "schedule_instalment_financing_supply_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/financing/";

    private final String JSON_SUPPLY_DATA_NAME = "schedule_instalment_financing_supply_data";

    private final String URL_FINANCIAMENTO_PARCELA_SUPPLY = "{0}/financings/v1/contracts/{1}/scheduled-instalments";

    private final String URL_STATUS = "/actuator/health";

    @Given("que seja feito uma requisição GET no endpoint de Financiamento - Parcelamento Contrato")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_financiamento_parcelamento_contrato() {

        String brandName = "bradesco";
        String contractId = "E-R6TaUjWljwfv_JegKMn450oD1VPV6h1bRgKDUNk7ciz2DZqnziRD48nranJ_KA7QcVEilk8iGWA5_zeRwT5A";

//        List<String> permission = Collections.singletonList("FINANCINGS_SCHEDULED_INSTALMENTS_READ");
//        PermissionAuthorization permissionAuthorization = permissionAuthorizationFactory
//                .buildPermissionAuthorization(permission);
//
//        String permissionEncodedAuthorization = base64Utils.getPermissionEncodedAuthorization(permissionAuthorization);

        String bearer = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdGF0dXMiOiJBQ1RJVkUiLCJpc3MiOiJicmFkZXNjby1vYiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImV4cCI6MTQzMjE0MzIxNDMyLCJpYXQiOjU0MzIxNDUzMjEzNCwibmJmIjo0MzIxNDMyNDMyMTQsImtpZCI6IjQ3ODM5MjE3NDg5MjMiLCJqdGkiOjM0MjM0MzI1NDM0Mywic3ViIjoiY3BmLTR1M2kyMDI0ODkwMiIsInNjcCI6Im9wZW5pZCBhY2NvdW50cyBjcmVkaXQtY2FyZHMtYWNjb3VudHMiLCJjZXJ0aWZpY2F0ZS1kbiI6IkNOPVF1aWNrYm9va3MgUHJvLCBPVT1RdWlja2Jvb2tzIFByb2QsIE89SW50dWl0LCBDPUJSIiwiY29uc2VudC5kYXRhIjp7ImNvbnNlbnRJRCI6Ijc3NzAwNyIsImNsaWVudElkIjoiSWRlbnRpZmljYWRvciBkbyBUUFAiLCJwZXJtaXNzaW9ucyI6WyJMT0FOU19SRUFEIiwiTE9BTlNfV0FSUkFOVElFU19SRUFEIiwiTE9BTlNfUEFZTUVOVFNfUkVBRCIsIkxPQU5TX1NDSEVEVUxFRF9JTlNUQUxNRU5UU19SRUFEIiwiQ1JFRElUX0NBUkRTX0FDQ09VTlRTX0xJTUlUU19SRUFEIiwiRklOQU5DSU5HU19SRUFEIiwiRklOQU5DSU5HU19XQVJSQU5USUVTX1JFQUQiLCJGSU5BTkNJTkdTX1BBWU1FTlRTX1JFQUQiLCJGSU5BTkNJTkdTX1NDSEVEVUxFRF9JTlNUQUxNRU5UU19SRUFEIl19LCJ1c2VyLmluZm8iOnsidXNlcklkIjoiOTIwMDg5NDk2ODAiLCJidXNpbmVzc0lkIjoiIn19.PBU6DKpN7lF1_ZaQiESl_H6SUhkFhE9y8m5kpadn58I";
        Headers header = headerUtils.getHeader(
                new Header("Authorization", bearer)
        );

        financingScheduleInstalmentSupply = fornecimentoService.getResponseObject(ProjectType.FINANCINGS_INSTALLMENT_SUPPLY,
                ROOT_JSON_DATA_PATH, JSON_SUPPLY_DATA_NAME, header, FinancingScheduleInstalmentSupply.class,
                URL_FINANCIAMENTO_PARCELA_SUPPLY, brandName, contractId);

        printJsonBradescoReport(financingScheduleInstalmentSupply);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Given("que seja feito uma requisição GET no endpoint de status Financiamento - Parcelamento Contrato")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_status_financiamento_parcelamento() {

        List<String> permission = Collections.singletonList("FINANCINGS_SCHEDULED_INSTALMENTS_READ");
        PermissionAuthorization permissionAuthorization = permissionAuthorizationFactory
                .buildPermissionAuthorization(permission);

        String permissionEncodedAuthorization = base64Utils.getPermissionEncodedAuthorization(permissionAuthorization);

        Headers header = headerUtils.getHeader(
                new Header("Authorization", permissionEncodedAuthorization)
        );

        statusObject = fornecimentoService.getStatus(ProjectType.FINANCINGS_INSTALLMENT_SUPPLY, header,
                StatusObject.class, URL_STATUS);

        printJsonBradescoReport(statusObject.getData());
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Given("que seja feito uma requisição GET sem permissão no endpoint de Financiamento - Parcelamento Contrato")
    public void que_seja_feito_uma_requisicao_get_sem_permissao_no_endpoint_de_financiamento_parcelamento_contrato() {

        String brandName = "bradesco";
        String contractId = "E-R6TaUjWljwfv_JegKMn450oD1VPV6h1bRgKDUNk7ciz2DZqnziRD48nranJ_KA7QcVEilk8iGWA5_zeRwT5A";

        PermissionAuthorization permissionAuthorization = permissionAuthorizationFactory
                .buildPermissionAuthorization(new ArrayList<>());

        String permissionEncodedAuthorization = base64Utils.getPermissionEncodedAuthorization(permissionAuthorization);

        Headers header = headerUtils.getHeader(
                new Header("Authorization", permissionEncodedAuthorization)
        );

        financingScheduleInstalmentSupply = fornecimentoService.getResponseObject(ProjectType.FINANCINGS_INSTALLMENT_SUPPLY,
                ROOT_JSON_DATA_PATH, JSON_SUPPLY_DATA_NAME, header, FinancingScheduleInstalmentSupply.class,
                URL_FINANCIAMENTO_PARCELA_SUPPLY, brandName, contractId);

        printJsonBradescoReport(financingScheduleInstalmentSupply);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {

        isValidSchema = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_SUPPLY_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_SUPPLY_SCHEMA_NAME);
        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = financingScheduleInstalmentSupply.getHttpCode();
        BradescoReporter.report(ReportStatus.PASSED, "Validação do status code feita com sucesso");
    }

    @When("pegar o status da API")
    public void pegar_o_status_da_api() {

        statusApi = statusObject.getData().getStatus();
        BradescoReporter.report(ReportStatus.PASSED, "Validação do status da API feita com sucesso");
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

    @Then("status deve ser \"([^\"]*)\"")
    public void status_deve_ser(String status) {

        assertEquals(status.toUpperCase(), statusApi.toUpperCase());
        BradescoReporter.report(ReportStatus.PASSED, "Status da API é válido");
    }

    @Then("detalhe deve ser \"([^\"]*)\"")
    public void detalhe_deve_ser(String detalhe) {

        assertEquals(detalhe.toUpperCase(), financingScheduleInstalmentSupply.getErrors().get(0).getDetail().toUpperCase());
        BradescoReporter.report(ReportStatus.PASSED, "Detalhe da API é válido");
    }
}
