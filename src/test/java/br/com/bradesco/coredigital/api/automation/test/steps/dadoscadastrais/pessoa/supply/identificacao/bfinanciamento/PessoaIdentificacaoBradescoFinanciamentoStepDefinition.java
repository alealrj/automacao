package br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.supply.identificacao.bfinanciamento;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseListData;
import br.com.bradesco.coredigital.api.automation.model.response.supply.personalcustomeridentification.PersonalCustomerIdentificationSupply;
import br.com.bradesco.coredigital.api.automation.service.FornecimentoService;
import br.com.bradesco.coredigital.api.automation.test.steps.AbstractStepDefinition;
import com.bradesco.core.report.BradescoReporter;
import com.bradesco.core.sdk.enums.ReportStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static com.bradesco.core.report.Assert.assertEquals;
import static com.bradesco.core.report.Assert.assertTrue;

public class PessoaIdentificacaoBradescoFinanciamentoStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseListData<PersonalCustomerIdentificationSupply> identificacaoPessoalBradescoFinanciamento;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/personal/identification/";

    private final String JSON_SUPPLY_BRADESCOFINANCIAMENTO_SCHEMA_NAME = "personal_identification_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/personal/identification/";

    private final String JSON_SUPPLY_BRADESCOFINANCIAMENTO_DATA_NAME = "personal_identification_supply_bradescofinanciamento_data";

    private final String URL_PESSOAL_IDENTIFICACAO_BRADESCOFINANCIAMENTO_SUPPLY = "/bradescofinanciamento/customers/v1/personal/identifications";

    @Given("^seja realizada uma requisição GET no endpoint de Identificação Pessoa Natural$")
    public void seja_realizada_uma_requisição_GET_no_endpoint_de_Identificação_Pessoa_Natural() {

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdGF0dXMiOiJBQ1RJVkUiLCJpc3MiOiJicmFkZXNjby1vYiIsImF1ZCI6Imh0dHBzOi8vIG9wZW5iYW5raW5nPiIsImV4cCI6MTQzMjE0MzIxNDMyLCJpYXQiOjU0MzIxNDUzMjEzNCwibmJmIjo0MzIxNDMyNDMyMTQsImtpZCI6IjQ3ODM5MjE3NDg5MjMiLCJqdGkiOjM0MjM0MzI1NDM0Mywic3ViIjoiY3BmLTR1M2kyMDI0ODkwMiIsInNjcCI6Im9wZW5pZCBhY2NvdW50cyBjcmVkaXQtY2FyZHMtYWNjb3VudHMiLCJjZXJ0aWZpY2F0ZS1kbiI6IkNOPVF1aWNrYm9va3MgUHJvLCBPVT1RdWlja2Jvb2tzIFByb2QsIE89SW50dWl0LCBDPUJSIiwiY29uc2VudC5kYXRhIjp7ImNvbnNlbnRJRCI6Ijk5OTk5NyIsImNsaWVudElkIjoiSXRhdSIsInBlcm1pc3Npb25zIjpbIkNVU1RPTUVSU19QRVJTT05BTF9JREVOVElGSUNBVElPTlNfUkVBRCJdfSwidXNlci5pbmZvIjp7InVzZXJJZCI6IjEwNDI4MTk5OTg0IiwiYnVzaW5lc3NJZCI6IiJ9fQ.J5YKOXTg6sgfo6FHMyBnLaodGeViDLTnG7UCFTNL1TM");

        identificacaoPessoalBradescoFinanciamento = fornecimentoService.getResponseListData(ProjectType.REGISTRATION_DATA_LOSANGO_OR_BF_SUPPLY,
                ROOT_JSON_DATA_PATH, JSON_SUPPLY_BRADESCOFINANCIAMENTO_DATA_NAME, getHeaders(headerMap),
                PersonalCustomerIdentificationSupply.class, URL_PESSOAL_IDENTIFICACAO_BRADESCOFINANCIAMENTO_SUPPLY);

        printJsonBradescoReport(identificacaoPessoalBradescoFinanciamento);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Then("^usuario deve receber os status code (\\d+)$")
    public void usuario_deve_receber_os_status_code(int statusCode) {

        assertEquals(statusCode, identificacaoPessoalBradescoFinanciamento.getHttpCode());
        BradescoReporter.report(ReportStatus.PASSED, "Status code validado com sucesso");
    }

    @Then("^o retorno das requisicões deve estar de acordo com contrato definido$")
    public void o_retorno_das_requisicões_deve_estar_de_acordo_com_contrato_definido() {

        boolean responseValid = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_SUPPLY_BRADESCOFINANCIAMENTO_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_SUPPLY_BRADESCOFINANCIAMENTO_SCHEMA_NAME);
        assertTrue(responseValid);
        BradescoReporter.report(ReportStatus.PASSED, "Contrato validado com sucesso");
    }
}
