package br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.core.qualificacao.bradesco;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.core.personalcustomerqualification.PersonalCustomerQualificationCore;
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

public class PessoaQualificacaoBradescoCoreStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseObject<PersonalCustomerQualificationCore> qualificacaoPessoalBradescoCore;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/personal/qualification/";

    private final String JSON_CORE_SCHEMA_NAME = "personal_qualification_core_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/personal/qualification/";

    private final String JSON_CORE_DATA_NAME = "personal_qualification_bradesco_core_data";

    private final String URL_PESSOAL_QUALIFICACAO_BRADESCO_CORE = "/bradesco/core/registration-data/v1/personal/qualifications";

    @Given("^seja realizada uma requisição GET no endpoint de qualificacao Pessoa Natural$")
    public void seja_realizada_uma_requisição_GET_no_endpoint_de_qualificacao_Pessoa_Natural() {

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("agency", "test");
        headerMap.put("accountNumber", "test");
        headerMap.put("accountDigit", "test");
        headerMap.put("ownership", "test");

        qualificacaoPessoalBradescoCore = fornecimentoService.getResponseObject(
                ProjectType.REGISTRATION_DATABRADESCO_OR_NEXT_CORE, ROOT_JSON_DATA_PATH, JSON_CORE_DATA_NAME,
                getHeaders(headerMap), PersonalCustomerQualificationCore.class, URL_PESSOAL_QUALIFICACAO_BRADESCO_CORE);

        printJsonBradescoReport(qualificacaoPessoalBradescoCore);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Then("^deve retornar status code (\\d+) para chamada de qualificacao Pessoa Natural$")
    public void deve_retornar_status_code_para_chamada_de_qualificacao_Pessoa_Natural(int statusCode) {

        assertEquals(statusCode, qualificacaoPessoalBradescoCore.getHttpCode());
        BradescoReporter.report(ReportStatus.PASSED, "Status code validado com sucesso");
    }

    @Then("^o retorno deve estar de acordo com contrato de qualificacao Pessoa Natural$")
    public void o_retorno_deve_estar_de_acordo_com_contrato_de_qualificacao_Pessoa_Natural() {

        boolean responseValid = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_CORE_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_CORE_SCHEMA_NAME);
        assertTrue(responseValid);
        BradescoReporter.report(ReportStatus.PASSED, "Contrato validado com sucesso");
    }
}
