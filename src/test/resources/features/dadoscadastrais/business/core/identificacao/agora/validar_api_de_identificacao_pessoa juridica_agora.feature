#Auto generated Octane revision tag
@TID91979REV0.2.0
Feature: Validar api de identificação pessoa jurídica - Ágora Core

Scenario: Validar api de identificação pessoa jurídica - Ágora Core

    Given seja realizada uma requisição GET no endpoint de Identificação Pessoa juridica
    Then  usuario deve receber os status code 200
    And   o retorno das requisicões deve estar de acordo com contrato definido