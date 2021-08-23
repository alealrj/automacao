package br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.business.core.identificacao.agora;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseListData;
import br.com.bradesco.coredigital.api.automation.model.response.core.businessidentification.BusinessIdentificationCore;
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

public class BusinessIdentificationAgoraCoreStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseListData<BusinessIdentificationCore> identificacaoBusinessCore;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/business/identification/";

    private final String JSON_CORE_SCHEMA_NAME = "business_identification_core_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/business/identification/";

    private final String JSON_CORE_AGORA_DATA_NAME = "personal_identification_business_core_agora_data";

    private final String URL_PESSOAL_IDENTIFICACAO_CORE_AGORA = "/agora-egress/customers.v1.business.identifications?cpf-cnpj={0}";

    @Given("^seja realizada uma requisição GET no endpoint de Identificação Pessoa juridica$")
    public void seja_realizada_uma_requisição_GET_no_endpoint_de_Identificação_Pessoa_juridica() {

        String cpfCnpj = "49086564000188";

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Authorization", "test");

        identificacaoBusinessCore = fornecimentoService.getResponseListData(ProjectType.REGISTRATION_DATA_AGORA_CORE,
                ROOT_JSON_DATA_PATH, JSON_CORE_AGORA_DATA_NAME, getHeaders(headerMap),
                BusinessIdentificationCore.class, URL_PESSOAL_IDENTIFICACAO_CORE_AGORA, cpfCnpj);

        printJsonBradescoReport(identificacaoBusinessCore);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Then("^usuario deve receber os status code (\\d+)$")
    public void usuario_deve_receber_os_status_code(int statusCode) {

        assertEquals(statusCode,identificacaoBusinessCore.getHttpCode());
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







