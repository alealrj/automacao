package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.supply.contrato;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.factory.authorization.PermissionAuthorizationFactory;
import br.com.bradesco.coredigital.api.automation.model.request.authorization.PermissionAuthorization;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.StatusObject;
import br.com.bradesco.coredigital.api.automation.model.response.supply.loans.LoansContractSupply;
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

public class EmprestimoContratoSupplyStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private PermissionAuthorizationFactory permissionAuthorizationFactory;

    @Autowired
    private Base64Utils base64Utils;

    private ResponseObject<LoansContractSupply> contratoEmprestimoResponse;

    private ResponseObject<StatusObject> statusObject;

    private boolean isValidSchema;

    private int statusCode;

    private String statusApi;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/loans/";

    private final String JSON_SUPPLY_SCHEMA_NAME = "contract_loans_supply_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/loans/";

    private final String JSON_SUPPLY_DATA_NAME = "contract_loans_supply_data";

    private final String URL_EMPRESTIMO_CONTRATO_SUPPLY = "/{0}/loans/v1/contracts/{1}";

    private final String URL_STATUS = "/actuator/health";

    @Given("que seja feito uma requisição GET no endpoint de Empréstimos - Contrato")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_emprestimos_contrato() {

        //TODO ajustar contractId para pegar o valor correto
        String contractId = "12345";
        String brandName = "bradesco";

        List<String> permission = Collections.singletonList("LOANS_READ");
        PermissionAuthorization permissionAuthorization = permissionAuthorizationFactory
                .buildPermissionAuthorization(permission);

        String permissionEncodedAuthorization = base64Utils.getPermissionEncodedAuthorization(permissionAuthorization);

        Headers header = headerUtils.getHeader(
                new Header("Authorization", permissionEncodedAuthorization)
        );

        contratoEmprestimoResponse = fornecimentoService.getResponseObject(ProjectType.LOANS_CONTRACT_SUPPLY,
                ROOT_JSON_DATA_PATH, JSON_SUPPLY_DATA_NAME, header, LoansContractSupply.class,
                URL_EMPRESTIMO_CONTRATO_SUPPLY, brandName, contractId);

        printJsonBradescoReport(contratoEmprestimoResponse);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Given("que seja feito uma requisição GET no endpoint de status Empréstimos - Contrato")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_status_emprestimos_contrato() {

        List<String> permission = Collections.singletonList("LOANS_READ");
        PermissionAuthorization permissionAuthorization = permissionAuthorizationFactory
                .buildPermissionAuthorization(permission);

        String permissionEncodedAuthorization = base64Utils.getPermissionEncodedAuthorization(permissionAuthorization);

        Headers header = headerUtils.getHeader(
                new Header("Authorization", permissionEncodedAuthorization)
        );

        statusObject = fornecimentoService.getStatus(ProjectType.LOANS_CONTRACT_SUPPLY, header,
                StatusObject.class, URL_STATUS);

        printJsonBradescoReport(statusObject.getData());
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Given("que seja feito uma requisição GET sem permissão no endpoint de Empréstimos - Contrato")
    public void que_seja_feito_uma_requisicao_get_sem_permissao_no_endpoint_de_emprestimos_contrato() {

        //TODO ajustar contractId para pegar o valor correto
        String contractId = "12345";
        String brandName = "bradesco";

        PermissionAuthorization permissionAuthorization = permissionAuthorizationFactory
                .buildPermissionAuthorization(new ArrayList<>());

        String permissionEncodedAuthorization = base64Utils.getPermissionEncodedAuthorization(permissionAuthorization);

        Headers header = headerUtils.getHeader(
                new Header("Authorization", permissionEncodedAuthorization)
        );

        contratoEmprestimoResponse = fornecimentoService.getResponseObject(ProjectType.LOANS_CONTRACT_SUPPLY,
                ROOT_JSON_DATA_PATH, JSON_SUPPLY_DATA_NAME, header, LoansContractSupply.class,
                URL_EMPRESTIMO_CONTRATO_SUPPLY, brandName, contractId);

        printJsonBradescoReport(contratoEmprestimoResponse);
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

        statusCode = contratoEmprestimoResponse.getHttpCode();
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

    @Then("^status deve ser \"([^\"]*)\"$")
    public void status_deve_ser(String status) {

        assertEquals(status.toUpperCase(), statusApi.toUpperCase());
        BradescoReporter.report(ReportStatus.PASSED, "Status da API é válido");
    }

    @Then("detalhe deve ser \"([^\"]*)\"")
    public void detalhe_deve_ser(String detalhe) {

        assertEquals(detalhe.toUpperCase(), contratoEmprestimoResponse.getErrors().get(0).getDetail().toUpperCase());
        BradescoReporter.report(ReportStatus.PASSED, "Detalhe da API é válido");
    }
}
