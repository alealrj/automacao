package br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.supply.identificacao.losango;

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

public class PessoaIdentificacaoLosangoStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseListData<PersonalCustomerIdentificationSupply> identificacaoPessoalLosango;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/personal/identification/";
;
    private final String JSON_SUPPLY_LOSANGO_SCHEMA_NAME = "personal_identification_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/personal/identification/";

    private final String JSON_SUPPLY_LOSANGO_DATA_NAME = "personal_identification_supply_losango_data";

    private final String URL_PESSOAL_IDENTIFICACAO_LOSANGO_SUPPLY = "/losango/customers/v1/personal/identifications";

    @Given("^seja realizada uma requisição GET no endpoint de Identificacao Pessoa Natural$")
    public void seja_realizada_uma_requisição_GET_no_endpoint_de_Identificacao_Pessoa_Natural() {

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Authorization", "los");

        identificacaoPessoalLosango = fornecimentoService.getResponseListData(ProjectType.REGISTRATION_DATA_LOSANGO_OR_BF_SUPPLY,
                ROOT_JSON_DATA_PATH, JSON_SUPPLY_LOSANGO_DATA_NAME, getHeaders(headerMap),
                PersonalCustomerIdentificationSupply.class, URL_PESSOAL_IDENTIFICACAO_LOSANGO_SUPPLY);

        printJsonBradescoReport(identificacaoPessoalLosango);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Then("^deve retornar status code (\\d+) para chamada de Identificacao Pessoa Natural$")
    public void deve_retornar_status_code_para_chamada_de_Identificacao_Pessoa_Natural(int statusCode) {

        assertEquals(statusCode, identificacaoPessoalLosango.getHttpCode());
        BradescoReporter.report(ReportStatus.PASSED, "Status code validado com sucesso");
    }

    @Then("^o retorno deve estar de acordo com contrato de Identificacao Pessoa Natural$")
    public void o_retorno_deve_estar_de_acordo_com_contrato_de_Identificacao_Pessoa_Natural() {

        boolean responseValid = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_SUPPLY_LOSANGO_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_SUPPLY_LOSANGO_SCHEMA_NAME);
        assertTrue(responseValid);
        BradescoReporter.report(ReportStatus.PASSED, "Contrato validado com sucesso");
    }
}

