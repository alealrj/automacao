#Auto generated Octane revision tag
@TID91978REV0.4.0
Feature: Validar api de identificação de pessoa natural - Bradesco Core

  Scenario: Validar api de identificação de pessoa natural - Bradesco Core

    Given seja realizada uma requisição GET no endpoint de Identificação Pessoa Natural
    Then deve retornar status code 200 para chamada de Identificação Pessoa Natural
    And o retorno deve estar de acordo com contrato de Identificação Pessoa Natural
	
