package br.com.bradesco.coredigital.api.automation.test.steps.transacionalcartao.egrees.transacao.losango;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseListData;
import br.com.bradesco.coredigital.api.automation.model.response.egrees.card.losango.TransactionEgreesLosango;
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

public class EgreesLosangoTransacaoStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseListData<TransactionEgreesLosango> transacaoEgreesLosangoResponse;

    private boolean isValidSchema;

    private int statusCode;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/card/";

    private final String JSON_EGREES_SCHEMA_NAME = "card_transaction_egrees_losango_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/card/";

    private final String JSON_EGREES_DATA_NAME = "card_transaction_losango_egrees_data";

    private final String URL_CARTAO_TRANSACAO_LOSANGO_EGREES = "/egress-gateway/losango/v1/credit-cards-transactions";

    @Given("que seja feito uma requisição GET no endpoint de Transação de Cartões")
    public void que_seja_feito_uma_requisicao_get_no_endpoint_de_transacao_de_cartoes() {

        Headers header = headerUtils.getHeader(
                new Header("identification", "178582x8582199"),
                new Header("brand", "LOS"));

        transacaoEgreesLosangoResponse = fornecimentoService.getResponseListData(ProjectType.CARD_TRANSACTION_LOSANGO_EGREES, ROOT_JSON_DATA_PATH,
                JSON_EGREES_DATA_NAME, header, TransactionEgreesLosango.class, URL_CARTAO_TRANSACAO_LOSANGO_EGREES);


        printJsonBradescoReport(transacaoEgreesLosangoResponse);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @When("pegar o schema da API")
    public void pegar_o_schema_da_api() {

        isValidSchema = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_EGREES_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_EGREES_SCHEMA_NAME);
        BradescoReporter.report(ReportStatus.PASSED, "Validação do schema feita com sucesso");
    }

    @When("pegar o status code da requisição")
    public void pegar_o_status_code_da_requisicao() {

        statusCode = transacaoEgreesLosangoResponse.getHttpCode();
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
