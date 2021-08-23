package br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.supply.identificacao.bradesco;

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

public class PessoaIdentificacaoSupplyStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseListData<PersonalCustomerIdentificationSupply> identificacaoPessoal;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/personal/identification/";

    private final String JSON_SUPPLY_SCHEMA_NAME = "personal_identification_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/personal/identification/";

    private final String JSON_SUPPLY_DATA_NAME = "personal_identification_bradesco_supply_data";

    private final String URL_PESSOAL_IDENTIFICACAO_SUPPLY = "/bradesco/customers/v1/personal/identifications";

    @Given("seja realizada uma requisição GET no endpoint de Identificação Pessoa Natural")
    public void seja_realizada_uma_requisição_GET_no_endpoint_de_Identificação_Pessoa_Natural() {

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6IjEyMzQ1Njc4OTAifQ.na71ipK8ASvggoM6C5vMjBKgJlZLxV-m6ElgHBrNtlU");

        identificacaoPessoal = fornecimentoService.getResponseListData(ProjectType.REGISTRATION_DATA_BRADESCO_OR_NEXT_SUPPLY,
                ROOT_JSON_DATA_PATH, JSON_SUPPLY_DATA_NAME, getHeaders(headerMap), PersonalCustomerIdentificationSupply.class,
                URL_PESSOAL_IDENTIFICACAO_SUPPLY);

        printJsonBradescoReport(identificacaoPessoal);
        BradescoReporter.report(ReportStatus.PASSED, "Get feito com sucesso");
    }

    @Then("usuario deve receber os status code (\\d+)$")
    public void usuario_deve_receber_os_status_code(int statusCode) {
        assertEquals(statusCode, identificacaoPessoal.getHttpCode());
        BradescoReporter.report(ReportStatus.PASSED, "Status code validado com sucesso");
    }

    @Then("o retorno das requisicões deve estar de acordo com contrato definido")
    public void o_retorno_das_requisicões_deve_estar_de_acordo_com_contrato_definido() {
        boolean responseValid = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_SUPPLY_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_SUPPLY_SCHEMA_NAME);
        assertTrue(responseValid);
        BradescoReporter.report(ReportStatus.PASSED, "Contrato validado com sucesso");
    }
}