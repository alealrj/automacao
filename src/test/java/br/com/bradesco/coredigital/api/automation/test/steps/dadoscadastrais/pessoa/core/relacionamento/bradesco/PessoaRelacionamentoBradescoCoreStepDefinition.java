package br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.core.relacionamento.bradesco;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.core.personalcustomerrelation.PersonalCustomerRelationCore;
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

public class PessoaRelacionamentoBradescoCoreStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseObject<PersonalCustomerRelationCore> relacionamentoPessoalBradescoCore;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/personal/financialrelation/";

    private final String JSON_CORE_SCHEMA_NAME = "personal_relation_core_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/personal/financialrelation/";

    private final String JSON_CORE_DATA_NAME = "personal_relation_core_bradesco_data";

    private final String URL_PESSOAL_RELACIONAMENTO_CORE_BRADESCO = "/bradesco/core/registration-data/v1/personal/financial-relations";


    @Given("^seja realizada uma requisição GET no endpoint de relacionamento Pessoa Natural$")
    public void seja_realizada_uma_requisição_GET_no_endpoint_de_relacionamento_Pessoa_Natural() {

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("agency", "test");
        headerMap.put("accountNumber", "test");
        headerMap.put("accountDigit", "test");
        headerMap.put("ownership", "test");

        relacionamentoPessoalBradescoCore = fornecimentoService.getResponseObject(
                ProjectType.REGISTRATION_DATABRADESCO_OR_NEXT_CORE, ROOT_JSON_DATA_PATH, JSON_CORE_DATA_NAME,
                getHeaders(headerMap), PersonalCustomerRelationCore.class, URL_PESSOAL_RELACIONAMENTO_CORE_BRADESCO);

        printJsonBradescoReport(relacionamentoPessoalBradescoCore);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Then("^deve retornar status code (\\d+) para chamada de relacionamento Pessoa Natural$")
    public void deve_retornar_status_code_para_chamada_de_relacionamento_Pessoa_Natural(int statusCode) {

        assertEquals(statusCode, relacionamentoPessoalBradescoCore.getHttpCode());
        BradescoReporter.report(ReportStatus.PASSED, "Status code validado com sucesso");
    }

    @Then("^o retorno deve estar de acordo com contrato de relacionamento Pessoa Natural$")
    public void o_retorno_deve_estar_de_acordo_com_contrato_de_relacionamento_Pessoa_Natural() {

        boolean responseValid = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_CORE_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_CORE_SCHEMA_NAME);
        assertTrue(responseValid);
        BradescoReporter.report(ReportStatus.PASSED, "Contrato validado com sucesso");
    }
}

