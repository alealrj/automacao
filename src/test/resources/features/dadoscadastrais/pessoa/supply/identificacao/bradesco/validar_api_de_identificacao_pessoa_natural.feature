#Auto generated Octane revision tag
@TID91986REV0.2.0
Feature: Validar api de identificação pessoa natural - Bradesco Supply

  Scenario: Validar api de identificação pessoa natural - Bradesco Supply

    Given seja realizada uma requisição GET no endpoint de Identificação Pessoa Natural
    Then  usuario deve receber os status code 200
    And   o retorno das requisicões deve estar de acordo com contrato definido