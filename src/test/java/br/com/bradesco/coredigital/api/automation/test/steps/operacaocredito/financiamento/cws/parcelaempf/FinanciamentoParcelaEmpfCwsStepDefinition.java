package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.financiamento.cws.parcelaempf;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.factory.cws.EmpfInstallmentContractFactory;
import br.com.bradesco.coredigital.api.automation.model.request.cws.EmpfInstallmentContractRequest;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.cws.ResponseEmpfInstallmentContractCwsObject;
import br.com.bradesco.coredigital.api.automation.service.CwsTokenService;
import br.com.bradesco.coredigital.api.automation.service.FornecimentoService;
import br.com.bradesco.coredigital.api.automation.test.steps.AbstractStepDefinition;
import com.bradesco.core.report.BradescoReporter;
import com.bradesco.core.sdk.enums.ReportStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.Headers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static com.bradesco.core.report.Assert.assertEquals;
import static com.bradesco.core.report.Assert.assertTrue;

public class FinanciamentoParcelaEmpfCwsStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private CwsTokenService cwsTokenService;

    @Autowired
    private EmpfInstallmentContractFactory empfInstallmentContractFactory;

    private ResponseObject<ResponseEmpfInstallmentContractCwsObject> responseEmpfInstallmentContractCwsObject;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/financing/";

    private final String JSON_CWS_EMPF_SCHEMA_NAME = "schedule_instalment_financing_empf_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/financing/";

    private final String JSON_CWS_EMPF_DATA_NAME = "schedule_instalment_financing_empf_data";

    private final String URL_FINANCIAMENTO_PARCELA_EMPF = "/rest/cws/v1/instalments";

    @Given("que seja feito uma requisição POST no endpoint de Financiamento - Parcela EMPF")
    public void que_seja_feito_uma_requisicao_post_no_endpoint_de_financiamento_parcela_empf() {

        final long cprodtBdsco = 12;
        final long cfamlContr = 3;
        final long ccontr = 290126940;
        final String dsoltcConsDados = "20.05.2021";
        final String dinicConsent = "20.05.2020";
        final String dfnalConsent = "20.05.2021";

        final String loginAgency = "3987";
        final String loginAccount = "10200-8";
        final String loginAccountType = "1";

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(loginAgency, loginAccount, loginAccountType);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-stateless-open", cwsHeadersAutenticacao.getValue("x-stateless-open"));
        headerMap.put("x-stateless-closed", cwsHeadersAutenticacao.getValue("x-stateless-closed"));

        EmpfInstallmentContractRequest empfInstallmentContractRequest = empfInstallmentContractFactory
                .buildEmpfInstallmentContractRequest(cprodtBdsco, cfamlContr, ccontr, dsoltcConsDados, dinicConsent,
                        dfnalConsent);

        responseEmpfInstallmentContractCwsObject = fornecimentoService
                .postObject(ProjectType.CWS_LOANS_FINANCINGS_EMPF, ROOT_JSON_DATA_PATH, JSON_CWS_EMPF_DATA_NAME,
                        getHeaders(headerMap), empfInstallmentContractRequest, ResponseEmpfInstallmentContractCwsObject.class,
                        URL_FINANCIAMENTO_PARCELA_EMPF);

        printJsonBradescoReport(responseEmpfInstallmentContractCwsObject.getData());
        BradescoReporter.report(ReportStatus.PASSED, "Post feito com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {

        isValidSchema = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_CWS_EMPF_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_CWS_EMPF_SCHEMA_NAME);

        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = responseEmpfInstallmentContractCwsObject.getHttpCode();
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
