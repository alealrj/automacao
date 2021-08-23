#Auto generated Octane revision tag
@TID106960REV0.5.0
Feature: Validar api de identificação de pessoa natural - Next Core

  Scenario: Validar api de identificação de pessoa natural - Next Core
    Given seja realizada uma requisição GET no endpoint de Identificação Pessoa Natural
    Then deve retornar status code 200 para chamada de Identificação Pessoa Natural
    And o retorno deve estar de acordo com contrato de Identificação Pessoa Natural
	
