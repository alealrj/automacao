#Auto generated Octane revision tag
@TID106962REV0.6.0
Feature: Validar api de qualificação de pessoa natural - Bradesco Core

  Scenario: Validar api de qualificação de pessoa natural - Bradesco Core
    Given seja realizada uma requisição GET no endpoint de qualificacao Pessoa Natural
    Then deve retornar status code 200 para chamada de qualificacao Pessoa Natural
    And o retorno deve estar de acordo com contrato de qualificacao Pessoa Natural
		
