#Auto generated Octane revision tag
@TID91998REV0.2.0
Feature: Validar api de relacionamento pessoa jurídica - Ágora Supply

  Scenario: Validar api de relacionamento pessoa jurídica - Ágora Supply

    Given seja realizada uma requisição GET no endpoint de relacionamento Pessoa Jurídica
    Then usuario deve receber os status code 200
    And o retorno das requisicões deve estar de acordo com contrato definido