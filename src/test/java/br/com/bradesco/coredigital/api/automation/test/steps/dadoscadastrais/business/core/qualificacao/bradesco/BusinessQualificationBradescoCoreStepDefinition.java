package br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.business.core.qualificacao.bradesco;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.core.businessqualification.BusinessQualificationCore;
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

public class BusinessQualificationBradescoCoreStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseObject<BusinessQualificationCore> qualificacaoBusinessBradescoCore;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/business/qualification/";

    private final String JSON_CORE_SCHEMA_NAME = "business_qualification_core_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/business/qualification/";

    private final String JSON_CORE_DATA_NAME = "business_qualification_core_bradesco_data";

    private final String URL_BUSINESS_IDENTIFICACAO_CORE_BRADESCO = "/bradesco/core/registration-data/v1/business/qualifications";

    @Given("^seja realizada uma requisição GET no endpoint de qualificação Pessoa Juridica$")
    public void seja_realizada_uma_requisição_GET_no_endpoint_de_qualificação_Pessoa_Juridica() {

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("agency", "test");
        headerMap.put("accountNumber", "test");
        headerMap.put("accountDigit", "test");
        headerMap.put("ownership", "test");

        qualificacaoBusinessBradescoCore = fornecimentoService.getResponseObject(
                ProjectType.REGISTRATION_DATABRADESCO_OR_NEXT_CORE, ROOT_JSON_DATA_PATH, JSON_CORE_DATA_NAME,
                getHeaders(headerMap), BusinessQualificationCore.class, URL_BUSINESS_IDENTIFICACAO_CORE_BRADESCO);

        printJsonBradescoReport(qualificacaoBusinessBradescoCore);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Then("^deve retornar status code (\\d+) para chamada de qualificação Pessoa Juridica$")
    public void deve_retornar_status_code_para_chamada_de_qualificação_Pessoa_Juridica(int statusCode) {

        assertEquals(statusCode, qualificacaoBusinessBradescoCore.getHttpCode());
        BradescoReporter.report(ReportStatus.PASSED, "Status code validado com sucesso");
    }

    @Then("^o retorno deve estar de acordo com contrato de qualificação Pessoa Juridica$")
    public void o_retorno_deve_estar_de_acordo_com_contrato_de_qualificação_Pessoa_Juridica() {

        boolean responseValid = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_CORE_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_CORE_SCHEMA_NAME);
        assertTrue(responseValid);
        BradescoReporter.report(ReportStatus.PASSED, "Contrato validado com sucesso");
    }
}

