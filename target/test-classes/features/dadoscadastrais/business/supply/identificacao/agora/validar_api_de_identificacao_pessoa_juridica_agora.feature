#Auto generated Octane revision tag
@TID91982REV0.2.0
Feature: Validar Api de identificação Pessoa Jurídica Ágora Supply

Scenario: Validar Api de identificação Pessoa Jurídica Ágora Supply

    Given seja realizada uma requisição GET no endpoint de Identificação Pessoa juridica
    Then  usuario deve receber os status code 200
    And   o retorno das requisicões deve estar de acordo com contrato definido