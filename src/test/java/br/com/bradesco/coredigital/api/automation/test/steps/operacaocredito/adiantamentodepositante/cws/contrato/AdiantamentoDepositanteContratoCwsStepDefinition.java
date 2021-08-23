package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.adiantamentodepositante.cws.contrato;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.cws.UnarrangedAccountsOverdraftContractCws;
import br.com.bradesco.coredigital.api.automation.service.CwsTokenService;
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

public class AdiantamentoDepositanteContratoCwsStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private CwsTokenService cwsTokenService;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/unarrangedaccountsoverdraft/";

    private final String JSON_CWS_SCHEMA_NAME = "contract_unarranged_accounts_overdraft_cws_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/unarrangedaccountsoverdraft/";

    private final String JSON_CWS_DATA_NAME = "contract_unarranged_accounts_overdraft_cws_data";

    private final String URL_ADIANTAMENTO_DEPOSITANTE_CWS = "/rest/cws/v1/contract/{0}";

    private ResponseObject<UnarrangedAccountsOverdraftContractCws> responseUnarrangedAccountsOverdraftContractCws;

    private boolean isValidSchema;

    private int statusCode;

    @Given("^que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Contrato$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_Adiantamento_Depositante_Contrato() {

        final String ncontrAdepos = "20007981025038";

        final String agency = "3987";
        final String account = "10200-8";
        final String accountType = "1";

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(agency, account, accountType);

        Headers header = headerUtils.getHeader(
                new Header("x-stateless-open", cwsHeadersAutenticacao.getValue("x-stateless-open")),
                new Header("x-stateless-closed", cwsHeadersAutenticacao.getValue("x-stateless-closed"))
        );

        responseUnarrangedAccountsOverdraftContractCws = fornecimentoService.getResponseObject (
                ProjectType.UNARRANGED_ACCOUNTS_OVERDRAFT_CONTRACT_CWS,
                ROOT_JSON_DATA_PATH,
                JSON_CWS_DATA_NAME,
                header,
                UnarrangedAccountsOverdraftContractCws.class,
                URL_ADIANTAMENTO_DEPOSITANTE_CWS,
                ncontrAdepos
        );

        printJsonBradescoReport(responseUnarrangedAccountsOverdraftContractCws);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @Given("^que seja feito uma requisição GET no endpoint de Adiantamento a Depositante - Contrato com header invalido$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_Adiantamento_Depositante_Contrato_com_header_invalido() {

        final String ncontrAdepos = "20007981025038";

                Headers header = headerUtils.getHeader(
                new Header("x-stateless-open", null),
                new Header("x-stateless-closed", null)
        );

        responseUnarrangedAccountsOverdraftContractCws = fornecimentoService.getResponseObject (
                ProjectType.UNARRANGED_ACCOUNTS_OVERDRAFT_CONTRACT_CWS,
                ROOT_JSON_DATA_PATH,
                JSON_CWS_DATA_NAME,
                header,
                UnarrangedAccountsOverdraftContractCws.class,
                URL_ADIANTAMENTO_DEPOSITANTE_CWS,
                ncontrAdepos
        );

        printJsonBradescoReport(responseUnarrangedAccountsOverdraftContractCws);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @When("^pegar o status code da requisição$")
    public void pegar_o_status_code_da_requisicao() {
        statusCode = responseUnarrangedAccountsOverdraftContractCws.getHttpCode();
        BradescoReporter.report(ReportStatus.PASSED, "Validação do status code feita com sucesso");
    }

    @When("^pegar o schema da API$")
    public void pegar_o_schema_da_API() {
        isValidSchema = fornecimentoService.validateSchema(
                ROOT_JSON_DATA_PATH,
                JSON_CWS_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH,
                JSON_CWS_SCHEMA_NAME
        );

        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @Then("^o status code deve ser (\\d+)$")
    public void o_status_code_deve_ser(int code) {
        assertEquals(code, statusCode);
        BradescoReporter.report(ReportStatus.PASSED, "Status code é válido");
    }

    @Then("^o schema deve ser válido$")
    public void o_schema_deve_ser_valido() {
        assertTrue(isValidSchema);
        BradescoReporter.report(ReportStatus.PASSED, "Schema é válido");
    }

    @Then("^a mensagem de erro deve ser \"(.*)\"$")
    public void a_Mensagem_De_Erro_Deve_Ser(String mensagem) {
        String erro = responseUnarrangedAccountsOverdraftContractCws.getErrors().get(0).getDetail();
        assertEquals(mensagem, erro);
        BradescoReporter.report(ReportStatus.PASSED, "Retornado erro " + statusCode + "conforme esperado - Sucesso");
    }
}
