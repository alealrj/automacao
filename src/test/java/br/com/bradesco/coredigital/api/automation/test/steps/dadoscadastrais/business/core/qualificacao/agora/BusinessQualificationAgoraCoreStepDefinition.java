package br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.business.core.qualificacao.agora;

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
import static org.junit.Assert.assertTrue;

public class BusinessQualificationAgoraCoreStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseObject<BusinessQualificationCore> qualificacaoBusinessCore;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/business/qualification/";

    private final String JSON_CORE_SCHEMA_NAME = "business_qualification_core_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/business/qualification/";

    private final String JSON_CORE_AGORA_DATA_NAME = "personal_qualification_business_core_agora_data";

    private final String URL_PESSOAL_IDENTIFICACAO_CORE_AGORA = "/agora-egress/customers.v1.business.qualifications?cpf-cnpj={0}";

    @Given("^seja realizada uma requisição GET no endpoint de qualificação Pessoa Juridica$")
    public void seja_realizada_uma_requisição_GET_no_endpoint_de_qualificação_Pessoa_Juridica() {

        String cpfCnpj = "49086564000188";

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Authorization", "test");

        qualificacaoBusinessCore = fornecimentoService.getResponseObject(ProjectType.REGISTRATION_DATA_AGORA_CORE,
                ROOT_JSON_DATA_PATH, JSON_CORE_AGORA_DATA_NAME, getHeaders(headerMap),
                BusinessQualificationCore.class, URL_PESSOAL_IDENTIFICACAO_CORE_AGORA, cpfCnpj);

        printJsonBradescoReport(qualificacaoBusinessCore);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Then("^o usuario deve receber o status code (\\d+)$")
    public void o_usuario_deve_receber_o_status_code(int statusCode) {

        assertEquals(statusCode, qualificacaoBusinessCore.getHttpCode());
        BradescoReporter.report(ReportStatus.PASSED, "Status code validado com sucesso");
    }

    @Then("^o retorno das requisicões deve estar de acordo com contrato definido$")
    public void o_retorno_das_requisicões_deve_estar_de_acordo_com_contrato_definido() {

        boolean responseValid = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_CORE_AGORA_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_CORE_SCHEMA_NAME);
        assertTrue(responseValid);
        BradescoReporter.report(ReportStatus.PASSED,"Contrato validado com sucesso");
    }
}
