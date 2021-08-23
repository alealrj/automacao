#Auto generated Octane revision tag
@TID91981REV0.2.0
Feature: Validar api de identificação pessoa juridica - Bradesco Supply

Scenario: Validar api de identificação pessoa juridica - Bradesco Supply

    Given seja realizada uma requisição GET no endpoint de Identificação Pessoa Juridica
    Then  usuario deve receber os status code 200
    And   o retorno das requisicões deve estar de acordo com contrato definido