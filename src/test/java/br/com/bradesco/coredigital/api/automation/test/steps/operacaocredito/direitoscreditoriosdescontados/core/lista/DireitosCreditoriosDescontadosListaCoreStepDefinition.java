package br.com.bradesco.coredigital.api.automation.test.steps.operacaocredito.direitoscreditoriosdescontados.core.lista;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseListData;
import br.com.bradesco.coredigital.api.automation.model.response.core.invoicefinancings.InvoiceFinancingsListCore;
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

public class DireitosCreditoriosDescontadosListaCoreStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/invoicefinancings/";

    private final String JSON_CORE_SCHEMA_NAME = "list_invoice_financings_core_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/invoicefinancings/";

    private final String JSON_CORE_DATA_NAME = "list_invoicefinancings_core_data";

    private final String URL_DCOM_LISTA_CORE = "/credit-operations/{0}/{1}/{2}/{3}";

    private ResponseListData<InvoiceFinancingsListCore> listaAdiantamentoDepositanteResponse;

    private boolean isValidSchema;

    private int statusCode;

    private String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJ2ZXIiOiIxLjAiLCJpc3MiOiJodHRwczovL29wZW5iYW5raW5nPi9icmFuZC50b2tlbiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImp0aSI6Ijc5ODQ3MDcwLTY2MzYtNDc0YS1hMTg5LTY3MDcyNDZiMDhkOSIsImlhdCI6MTYyMjE1NDY4OSwidG9rZW5JRCI6IkdVSUQgZ2VyYWRvIHBhcmEgbyBhY2Vzcy10b2tlbiIsInNjcCI6IjxwZXJtaXNzw7VlcyBzb2xpY2l0YWRhcyBwZWxhIG1hcmNhL2NhbmFsIGUgdmFsaWRhZGFzIG5vIE9QQks-IiwidXNlci5pbmZvIjp7InVzZXJJZCI6IjEyMzEyMzEyIiwiYWdlbmN5IjoiMDAwMSIsImFjY291bnQiOiIxMjM0NTY3IiwiYWNjb3VudERpZ2l0IjoiMSIsImhvbGRlciI6IjAwIn0sInVzZXIuYXV0aCI6eyJjaGFubmVsU2Vzc0lEIjoiPG7Dum1lcm8gcXVlIGlkZW50aWZpY2EgYSBzZXNzw6NvIGRvIGNhbmFsPiIsIkRldmljZUlEIjoiPGluZm9ybWHDp8O1ZXMgZG8gZGlzcG9zaXRpdm8gZG8gdXN1w6FyaW8-In19.TdXcPNgS0cC5g5hSS8JkCh2ymbC1_clOWxUMUsRLbu0";

    @Given("^que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Lista$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_direitos_creditorios_descontados_dcom_lista() {

        //TODO Ajustar valor de agency, account, digit e ownership após definições
        String agency = "1234";
        String account = "22222";
        String digit = "3";
        String ownership = "4";

        Headers header = headerUtils.getHeader(
                new Header("Authorization", token),
                new Header("cpfCnpj", "11122233344"),
                new Header("brand", "bradesco"),
                new Header("requestDate", "28/05/2021"),
                new Header("period", "1")
        );

        listaAdiantamentoDepositanteResponse = fornecimentoService.getResponseListData(
                ProjectType.INVOICE_FINANCINGS_LIST_CORE,
                ROOT_JSON_DATA_PATH,
                JSON_CORE_DATA_NAME,
                header,
                InvoiceFinancingsListCore.class,
                URL_DCOM_LISTA_CORE,
                agency,
                account,
                digit,
                ownership
        );

        printJsonBradescoReport(listaAdiantamentoDepositanteResponse);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @Given("^que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Lista com header invalido$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_direitos_creditorios_descontados_dcom_lista_com_header_invalido() {

        //TODO Ajustar valor de agency, account, digit e ownership após definições
        String agency = "1234";
        String account = "22222";
        String digit = "3";
        String ownership = "4";

        Headers header = headerUtils.getHeader(
                new Header("Authorization", token),
                new Header("cpfCnpj", "A"),
                new Header("brand", "bradesco"),
                new Header("requestDate", "28/05/2021"),
                new Header("period", "1")
        );

        listaAdiantamentoDepositanteResponse = fornecimentoService.getResponseListData(
                ProjectType.INVOICE_FINANCINGS_LIST_CORE,
                ROOT_JSON_DATA_PATH,
                JSON_CORE_DATA_NAME,
                header,
                InvoiceFinancingsListCore.class,
                URL_DCOM_LISTA_CORE,
                agency,
                account,
                digit,
                ownership
        );

        printJsonBradescoReport(listaAdiantamentoDepositanteResponse);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @Given("^que seja feito uma requisição GET no endpoint de Direitos Creditorios Descontados DCOM - Lista com token invalido$")
    public void que_seja_feito_uma_requisicao_GET_no_endpoint_de_direitos_creditorios_descontados_dcom_lista_com_token_invalido() {

        //TODO Ajustar valor de agency, account, digit e ownership após definições
        String agency = "1234";
        String account = "22222";
        String digit = "3";
        String ownership = "4";

        Headers header = headerUtils.getHeader(
                new Header("Authorization", "A"),
                new Header("cpfCnpj", "11122233344"),
                new Header("brand", "bradesco"),
                new Header("requestDate", "28/05/2021"),
                new Header("period", "1")
        );

        listaAdiantamentoDepositanteResponse = fornecimentoService.getResponseListData(
                ProjectType.INVOICE_FINANCINGS_LIST_CORE,
                ROOT_JSON_DATA_PATH,
                JSON_CORE_DATA_NAME,
                header,
                InvoiceFinancingsListCore.class,
                URL_DCOM_LISTA_CORE,
                agency,
                account,
                digit,
                ownership
        );

        printJsonBradescoReport(listaAdiantamentoDepositanteResponse);
        BradescoReporter.report(ReportStatus.PASSED, "GET feito com sucesso");
    }

    @When("^pegar o status code da requisição$")
    public void pegar_o_status_code_da_requisicao() {
        statusCode = listaAdiantamentoDepositanteResponse.getHttpCode();
        BradescoReporter.report(ReportStatus.PASSED, "Validação do status code feita com sucesso");
    }

    @When("^pegar o schema da API$")
    public void pegar_o_schema_da_API() {
        isValidSchema = fornecimentoService.validateSchema(
                ROOT_JSON_DATA_PATH,
                JSON_CORE_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH,
                JSON_CORE_SCHEMA_NAME
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
        String erro = listaAdiantamentoDepositanteResponse.getErrors().get(0).getDetail();
        assertEquals(mensagem, erro);
        BradescoReporter.report(ReportStatus.PASSED, "Retornado erro " + statusCode + "conforme esperado - Sucesso");
    }
}
