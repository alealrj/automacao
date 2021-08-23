package br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.egrees.limite;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.factory.egrees.EgreesLimitFactory;
import br.com.bradesco.coredigital.api.automation.model.request.egrees.EgreesLimitRequest;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.egrees.card.LimitEgrees;
import br.com.bradesco.coredigital.api.automation.model.response.egrees.card.TokenEgrees;
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

public class CartaoEgreesLimiteStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseObject<LimitEgrees> limiteEgreesCartaoResponse;

    @Autowired
    private EgreesLimitFactory egreesLimitFactory;

    private ResponseObject<TokenEgrees> tokenEgreesCartaoResponse;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/card/";

    private final String JSON_EGREES_SCHEMA_NAME = "card_limit_egrees_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/card/";

    private final String JSON_EGREES_DATA_NAME = "card_limit_egrees_data";

    private final String JSON_TOKEN_EGREES_DATA_NAME = "card_token_egrees_data";

    private final String URL_CARTAO_LIMITE_EGREES = "/egress-gateway/bradescard/v1/limits";

    private final String URL_CARTAO_TOKEN_EGREES = "/authorization-internal/v1/credit-cards/generate-token";

    @Given("que seja feito uma requisição POST no endpoint de Limites de Cartões")
    public void que_seja_feito_uma_requisicao_post_no_endpoint_de_limites_de_cartoes() {

        String nameToken = "uriApi";
        String valueToken = "limite";

        Headers headerToken = headerUtils.getHeader(
                new Header(nameToken, valueToken));

        tokenEgreesCartaoResponse = fornecimentoService.getResponseObject(ProjectType.CARD_TOKEN_EGREES, ROOT_JSON_DATA_PATH,
                JSON_TOKEN_EGREES_DATA_NAME, headerToken, TokenEgrees.class, URL_CARTAO_TOKEN_EGREES);

        String origens = "b2k";

        String marca = "BRADESCO";
        String numeroCartao = "5149119999997181";
        String contaFaturamento = "";
        String canal = "502";
        String usuario = "UAPOPCD";

        EgreesLimitRequest egreesLimitRequest = egreesLimitFactory.buildEgreesLimitRequest(
                origens, marca, numeroCartao, contaFaturamento, canal, usuario);

        Headers header = headerUtils.getHeader(
                new Header("Authorization", "test"));

        limiteEgreesCartaoResponse = fornecimentoService.postObject(ProjectType.CARD_LIMITS_EGREES, ROOT_JSON_DATA_PATH,
                JSON_EGREES_DATA_NAME, header, egreesLimitRequest, LimitEgrees.class, URL_CARTAO_LIMITE_EGREES);


        printJsonBradescoReport(limiteEgreesCartaoResponse);
        BradescoReporter.report(ReportStatus.PASSED, "Post feito com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {

        isValidSchema = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_EGREES_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_EGREES_SCHEMA_NAME);
        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = limiteEgreesCartaoResponse.getHttpCode();
        BradescoReporter.report(ReportStatus.PASSED, "Validação do status feito com sucesso");
    }

    @Then("o schema deve ser válido")
    public void o_schema_deve_ser_válido() {

        assertTrue(isValidSchema);
        BradescoReporter.report(ReportStatus.PASSED, "Schema é válido");
    }

    @Then("o status code deve ser (\\d+)")
    public void o_status_code_deve_ser(int code) {

        assertEquals(code, statusCode);
        BradescoReporter.report(ReportStatus.PASSED, "Status é válido");
    }
}
