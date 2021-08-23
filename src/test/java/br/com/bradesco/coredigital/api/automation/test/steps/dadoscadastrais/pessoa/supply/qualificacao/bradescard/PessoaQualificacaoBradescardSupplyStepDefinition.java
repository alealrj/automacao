package br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.supply.qualificacao.bradescard;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.supply.personalcustomerqualification.PersonalCustomerQualificationSupply;
import br.com.bradesco.coredigital.api.automation.service.FornecimentoService;
import br.com.bradesco.coredigital.api.automation.test.steps.AbstractStepDefinition;
import com.bradesco.core.report.BradescoReporter;
import com.bradesco.core.sdk.enums.ReportStatus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static com.bradesco.core.report.Assert.assertEquals;
import static com.bradesco.core.report.Assert.assertTrue;

public class PessoaQualificacaoBradescardSupplyStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseObject<PersonalCustomerQualificationSupply> qualificacaoPessoalBradescard;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/personal/qualification/";

    private final String JSON_SUPPLY_BRADESCARD_SCHEMA_NAME = "personal_qualification_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/personal/qualification/";

    private final String JSON_SUPPLY_BRADESCARD_DATA_NAME = "personal_qualification_supply_bradescard_data";

    private final String URL_PESSOAL_QUALIFICACAO_BRADESCARD_SUPPLY = "/customers/v1/personal/qualifications";

    @Given("^seja realizada uma requisição GET no endpoint de qualificação Pessoa Natural$")
    public void seja_realizada_uma_requisição_GET_no_endpoint_de_qualificação_Pessoa_Natural() {

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Authorization", "test");

        qualificacaoPessoalBradescard = fornecimentoService.getResponseObject(ProjectType.REGISTRATION_DATA_BRADESCARD_SUPPLY,
                ROOT_JSON_DATA_PATH, JSON_SUPPLY_BRADESCARD_DATA_NAME, getHeaders(headerMap),
                PersonalCustomerQualificationSupply.class, URL_PESSOAL_QUALIFICACAO_BRADESCARD_SUPPLY);

        printJsonBradescoReport(qualificacaoPessoalBradescard);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @When("^usuario deve receber os status code (\\d+)$")
    public void usuario_deve_receber_os_status_code(int statusCode) {

        assertEquals(statusCode, qualificacaoPessoalBradescard.getHttpCode());
        BradescoReporter.report(ReportStatus.PASSED, "Status code validado com sucesso");
    }

    @Then("^o retorno das requisicões deve estar de acordo com contrato definido$")
    public void o_retorno_das_requisicões_deve_estar_de_acordo_com_contrato_definido() {

        boolean responseValid = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_SUPPLY_BRADESCARD_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_SUPPLY_BRADESCARD_SCHEMA_NAME);
        assertTrue(responseValid);
        BradescoReporter.report(ReportStatus.PASSED, "Contrato validado com sucesso");
    }
}

