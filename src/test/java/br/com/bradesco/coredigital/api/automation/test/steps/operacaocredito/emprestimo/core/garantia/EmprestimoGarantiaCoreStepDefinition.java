package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.core.garantia;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseListData;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.StatusObject;
import br.com.bradesco.coredigital.api.automation.model.response.core.loans.LoansWarrantyCore;
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

public class EmprestimoGarantiaCoreStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseListData<LoansWarrantyCore> garantiaEmprestimoResponse;

    private ResponseObject<StatusObject> statusObject;

    private boolean isValidSchema;

    private int statusCode;

    private String statusApi;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/loans/";

    private final String JSON_CORE_SCHEMA_NAME = "warranty_loans_core_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/loans/";

    private final String JSON_CORE_DATA_NAME = "warranty_loans_core_data";

    private final String URL_EMPRESTIMO_GARANTIA_CONTRATO_CORE = "/core/loans/v1/contracts/{0}/warranties";

    private final String URL_STATUS = "/actuator/health";

    @Given("que seja feito uma requisição GET no endpoint de Empréstimos - Garantia Contrato")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_emprestimos_garantia_contrato() {

        //TODO ajustar contractId para pegar o valor correto
        String contractId = "1234";

        Headers header = headerUtils.getHeader(
                new Header("Authorization", "test")
        );

        garantiaEmprestimoResponse = fornecimentoService.getResponseListData(ProjectType.LOANS_WARRANTY_CORE,
                ROOT_JSON_DATA_PATH, JSON_CORE_DATA_NAME, header, LoansWarrantyCore.class,
                URL_EMPRESTIMO_GARANTIA_CONTRATO_CORE, contractId);

        printJsonBradescoReport(garantiaEmprestimoResponse);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Given("que seja feito uma requisição GET no endpoint de status Empréstimos - Garantia Contrato")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_status_emprestimos_garantia_contrato() {

        Headers header = headerUtils.getHeader(
                new Header("Authorization", "test")
        );

        statusObject = fornecimentoService.getStatus(ProjectType.LOANS_WARRANTY_CORE, header,
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

        statusCode = garantiaEmprestimoResponse.getHttpCode();
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
