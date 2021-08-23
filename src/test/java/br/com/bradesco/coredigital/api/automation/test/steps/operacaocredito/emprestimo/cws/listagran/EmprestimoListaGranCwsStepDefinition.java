package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.emprestimo.cws.listagran;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.factory.cws.GranWarrantyListContractFactory;
import br.com.bradesco.coredigital.api.automation.model.request.cws.GranWarrantyContractRequest;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.cws.ResponseListWarrantyContractCwsObject;
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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.bradesco.core.report.Assert.assertEquals;
import static com.bradesco.core.report.Assert.assertTrue;

public class EmprestimoListaGranCwsStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    @Autowired
    private CwsTokenService cwsTokenService;

    @Autowired
    private GranWarrantyListContractFactory granWarrantyListContractFactory;

    private ResponseObject<ResponseListWarrantyContractCwsObject> responseListWarrantyContractCwsObject;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/loans/";

    private final String JSON_CWS_GRAN_SCHEMA_NAME = "warranty_list_gran_loans_cws_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/loans/";

    private final String JSON_CWS_GRAN_DATA_NAME = "warranty_list_gran_loans_cws_data";

    private final String URL_EMPRESTIMO_GARANTIA_CONTRATO_GRAN_CWS = "/rest/cws/v1/warranties";

    @Given("que seja feito uma requisição POST no endpoint de Empréstimos - Lista Garantia Contrato GRAN")
    public void que_seja_feito_uma_requisicao_post_no_endpoint_de_emprestimo_lista_garantia_contrato_gran() {

        BigDecimal eCpssoaJuridContr = new BigDecimal(0);
        int eCtpoContrNego = 0;
        BigDecimal eNseqContrNego = new BigDecimal(0);
        int eCbco = 237;
        int eCagBcria = 2;
        BigDecimal eCctaBcriaCli = new BigDecimal(6244);
        String eCcart = "694";
        BigDecimal eCcontrFincd = new BigDecimal(18);

        String agencyLogin = "3987";
        String accountLogin = "10200-8";
        String accountTypeLogin = "1";

        GranWarrantyContractRequest granWarrantyContractRequest = granWarrantyListContractFactory.buildGranWarrantyContractRequest(
                eCpssoaJuridContr, eCtpoContrNego, eNseqContrNego, eCbco, eCagBcria, eCctaBcriaCli, eCcart, eCcontrFincd);

        final Headers cwsHeadersAutenticacao = cwsTokenService.getCwsHeadersAutenticacao(agencyLogin, accountLogin,
                accountTypeLogin);

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("x-stateless-open", cwsHeadersAutenticacao.getValue("x-stateless-open"));
        headerMap.put("x-stateless-closed", cwsHeadersAutenticacao.getValue("x-stateless-closed"));

        responseListWarrantyContractCwsObject = fornecimentoService.postObject(ProjectType.CWS_LOANS_FINANCINGS_GRAN,
                ROOT_JSON_DATA_PATH, JSON_CWS_GRAN_DATA_NAME, getHeaders(headerMap), granWarrantyContractRequest,
                ResponseListWarrantyContractCwsObject.class, URL_EMPRESTIMO_GARANTIA_CONTRATO_GRAN_CWS);

        printJsonBradescoReport(responseListWarrantyContractCwsObject);
        BradescoReporter.report(ReportStatus.PASSED, "Post feito com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {

        isValidSchema = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_CWS_GRAN_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_CWS_GRAN_SCHEMA_NAME);
        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = responseListWarrantyContractCwsObject.getHttpCode();
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
