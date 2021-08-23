package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.core.garantia;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseListData;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.StatusObject;
import br.com.bradesco.coredigital.api.automation.model.response.core.financing.FinancingWarrantyCore;
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

public class FinanciamentoGarantiaCoreStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseListData<FinancingWarrantyCore> financingWarrantyCore;

    private ResponseObject<StatusObject> statusObject;

    private boolean isValidSchema;

    private int statusCode;

    private String statusApi;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/financing/";

    private final String JSON_CORE_SCHEMA_NAME = "warranty_financing_core_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/financing/";

    private final String JSON_CORE_DATA_NAME = "warranty_financing_core_data";

    private final String URL_FINANCIAMENTO_GARANTIA_CORE = "/core/financings/v1/contracts/{0}/warranties?productCode={1}&familyContractCode={2}&sourceSystem={3}";

    private final String URL_STATUS = "/actuator/health";

    @Given("que seja feito uma requisição GET no endpoint de Financiamento - Garantia Contrato")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_financiamento_garantia_contrato() {

        String contractId = "1234";
        String productCode = "5678";
        String familyContractCode = "9012";
        String sourceSystem = "EMPF";

        Headers header = headerUtils.getHeader(
                new Header("Authorization", "teste"));

        financingWarrantyCore = fornecimentoService.getResponseListData(ProjectType.FINANCINGS_WARRANTY_CORE,
                ROOT_JSON_DATA_PATH, JSON_CORE_DATA_NAME, header, FinancingWarrantyCore.class,
                URL_FINANCIAMENTO_GARANTIA_CORE, contractId, productCode, familyContractCode, sourceSystem);

        printJsonBradescoReport(financingWarrantyCore);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Given("que seja feito uma requisição GET no endpoint de status Financiamento - Garantia Contrato")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_status_financiamento_garantia_contrato() {

        Headers header = headerUtils.getHeader(
                new Header("Authorization", "test")
        );

        statusObject = fornecimentoService.getStatus(ProjectType.FINANCINGS_WARRANTY_CORE, header,
                StatusObject.class, URL_STATUS);

        printJsonBradescoReport(statusObject.getData());
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {

        isValidSchema = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_CORE_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_CORE_SCHEMA_NAME);
        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = financingWarrantyCore.getHttpCode();
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
}
