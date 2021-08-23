#Auto generated Octane revision tag
@TID107887REV0.2.0
Feature: Validar api de qualificação de pessoa natural - BFinanciamentos Supply

  Scenario: Validar api de qualificação de pessoa natural - BFinanciamentos Supply
    Given  seja realizada uma requisição GET no endpoint de qualificacao Pessoa Natural
    Then deve retornar status code 200 para chamada de qualificacao Pessoa Natural
    And o retorno deve estar de acordo com contrato de qualificacao Pessoa Natural