package br.com.bradesco.coredigital.api.automation.test.steps.dadoscadastrais.pessoa.supply.relacionamento.bradesco;

import br.com.bradesco.coredigital.api.automation.enums.ProjectType;
import br.com.bradesco.coredigital.api.automation.model.response.ResponseObject;
import br.com.bradesco.coredigital.api.automation.model.response.supply.personalcustomerrelation.PersonalCustomerRelationSupply;
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

public class PessoaRelacionamentoSupplyStepDefinition extends AbstractStepDefinition {

    @Autowired
    private FornecimentoService fornecimentoService;

    private ResponseObject<PersonalCustomerRelationSupply> relacionamentoPessoal;

    private final String ROOT_JSON_SCHEMA_PATH = "src/main/resources/schema/personal/financialrelation/";

    private final String JSON_SUPPLY_SCHEMA_NAME = "personal_relation_schema";

    private final String ROOT_JSON_DATA_PATH = "src/main/resources/json_data/personal/financialrelation/";

    private final String JSON_SUPPLY_DATA_NAME = "personal_relation_bradesco_supply_data";

    private final String URL_PESSOAL_RELACIONAMENTO_SUPPLY = "/bradesco/customers/v1/personal/financial-relations";

    @Given("seja realizada uma requisição GET no endpoint de Relacionamento Pessoa Natural")
    public void seja_realizada_uma_requisição_GET_no_endpoint_de_Relacionamento_Pessoa_Natural() {

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbiI6IjEyMzQ1Njc4OTAifQ.na71ipK8ASvggoM6C5vMjBKgJlZLxV-m6ElgHBrNtlU");

        relacionamentoPessoal = fornecimentoService.getResponseObject(ProjectType.REGISTRATION_DATA_BRADESCO_OR_NEXT_SUPPLY,
                ROOT_JSON_DATA_PATH, JSON_SUPPLY_DATA_NAME, getHeaders(headerMap),
                PersonalCustomerRelationSupply.class, URL_PESSOAL_RELACIONAMENTO_SUPPLY);

        printJsonBradescoReport(relacionamentoPessoal);
        BradescoReporter.report(ReportStatus.PASSED, "Get realizado com sucesso");
    }

    @Then("deve retornar status code (\\d+) para chamada de Relacionamento Pessoa Natural")
    public void deve_retornar_status_code_para_chamada_de_Relacionamento_Pessoa_Natural(int statusCode) {

        assertEquals(statusCode, relacionamentoPessoal.getHttpCode());
        BradescoReporter.report(ReportStatus.PASSED, "Status code validado com sucesso");
    }

    @Then("o retorno deve estar de acordo com contrato de Relacionamento Pessoa Natural")
    public void o_retorno_deve_estar_de_acordo_com_contrato_de_Relacionamento_Pessoa_Natural() {

        boolean responseValid = fornecimentoService.validateSchema(ROOT_JSON_DATA_PATH, JSON_SUPPLY_DATA_NAME,
                ROOT_JSON_SCHEMA_PATH, JSON_SUPPLY_SCHEMA_NAME);
        assertTrue(responseValid);
        BradescoReporter.report(ReportStatus.PASSED, "Contrato validado com sucesso");
    }
}
