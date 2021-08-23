package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.preconsentimento;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.factory.authorization.TokenAuthorizationFactory;
import br.com.bradesco.coredigital.api.automation.model.request.authorization.TokenAuthorization;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseListData;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.StatusObject;
import br.com.bradesco.coredigital.api.automation.model.response.preconsent.CreditOperation;
import br.com.bradesco.coredigital.api.automation.service.CwsTokenService;
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

import static com.bradesco.core.report.Assert.assertEquals;
import static com.bradesco.core.report.Assert.assertTrue;

public class OperacaoCreditoPreConsentimentoCoreStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private CwsTokenService cwsTokenService;

    @Autowired
    private TokenAuthorizationFactory tokenAuthorizationFactory;

    @Autowired
    private Base64Utils base64Utils;

    private ResponseListData<CreditOperation> creditOperationResponse;

    private ResponseObject<StatusObject> statusObject;

    private boolean isValidSchema;

    private int statusCode;

    private String statusApi;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/preconsent/";

    private final String JSON_PRE_CONSENT_SCHEMA_NAME = "pre_consent_core_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/pre_consent/";

    private final String JSON_PRE_CONSENT_DATA_NAME = "pre_consent_core_data";

    private final String URL_PRE_CONSENTIMENTO_CORE = "/credit-operations/{0}/{1}/{2}/{3}?cpfCnpj={4}&brand={5}&requestDate={6}";

    private final String URL_PRE_CONSENTIMENTO_CORE_CPF_CNPJ = "/credit-operations?cpfCnpj={0}&brand={1}&requestDate={2}";

    private final String URL_STATUS = "/actuator/health";

    @Given("que seja feito uma requisição GET no endpoint de Pre-Consentimento")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_pre_consentimento() {

        String agency = "3995";
        String account = "1994";
        String digit = "1";
        String ownership = "1";
        String cpfCnpj = "87464512340";
        String brand = "bradesco";
        String requestDate = "19-05-2021";

        String loginAgency = "3987";
        String loginAccount = "10200-8";
        String loginAccountType = "1";

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(loginAgency, loginAccount,
                loginAccountType);

        String statelessOpen = cwsHeadersAutenticacao.getValue("x-stateless-open");
        String statelessClosed = cwsHeadersAutenticacao.getValue("x-stateless-closed");

        TokenAuthorization tokenAuthorization = tokenAuthorizationFactory
                .buildTokenAuthorization(statelessOpen, statelessClosed);

        String authorization = base64Utils.getTokenEncodedAuthorization(tokenAuthorization);

        Headers header = headerUtils.getHeader(
                new Header("Authorization", authorization));

        creditOperationResponse = fornecimentoService.getResponseListData(ProjectType.PRE_CONSENT,
                ROOT_JSON_DATA_PATH, JSON_PRE_CONSENT_DATA_NAME, header, CreditOperation.class,
                URL_PRE_CONSENTIMENTO_CORE, agency, account, digit, ownership, cpfCnpj, brand,
                requestDate);

        printJsonBradescoReport(creditOperationResponse);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Given("que seja feito uma requisição GET por cpf-cnpj no endpoint de Pre-Consentimento")
    public void que_seja_feito_uma_requisicao_get_por_cpf_cnpj_no_endpoint_de_pre_consentimento() {

        String cpfCnpj = "87464512340";
        String brand = "bradesco";
        String requestDate = "19-05-2021";

        String loginAgency = "3987";
        String loginAccount = "10200-8";
        String loginAccountType = "1";

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(loginAgency, loginAccount,
                loginAccountType);

        String statelessOpen = cwsHeadersAutenticacao.getValue("x-stateless-open");
        String statelessClosed = cwsHeadersAutenticacao.getValue("x-stateless-closed");

        TokenAuthorization tokenAuthorization = tokenAuthorizationFactory
                .buildTokenAuthorization(statelessOpen, statelessClosed);

        String authorization = base64Utils.getTokenEncodedAuthorization(tokenAuthorization);

        Headers header = headerUtils.getHeader(
                new Header("Authorization", authorization));

        creditOperationResponse = fornecimentoService.getResponseListData(ProjectType.PRE_CONSENT,
                ROOT_JSON_DATA_PATH, JSON_PRE_CONSENT_DATA_NAME, header, CreditOperation.class,
                URL_PRE_CONSENTIMENTO_CORE_CPF_CNPJ, cpfCnpj, brand, requestDate);

        printJsonBradescoReport(creditOperationResponse);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Given("que seja feito uma requisição GET no endpoint de status Pre-Consentimento")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_status_pre_consentimento() {

        Headers header = headerUtils.getHeader(
                new Header("Authorization", "test")
        );

        statusObject = fornecimentoService.getStatus(ProjectType.FINANCINGS_CONTRACT_CORE, header,
                StatusObject.class, URL_STATUS);

        printJsonBradescoReport(statusObject.getData());
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {

        isValidSchema = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_PRE_CONSENT_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_PRE_CONSENT_SCHEMA_NAME);
        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = creditOperationResponse.getHttpCode();
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
