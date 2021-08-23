#Auto generated Octane revision tag
@TID91992REV0.2.0
Feature:  Validar Api de qualificação Pessoa natural Ágora Supply

  Scenario: Validar Api de qualificação Pessoa natural Ágora Supply

    Given seja realizada uma requisição GET no endpoint de qualificação Pessoa natural
    Then  usuario deve receber os status code 200
    And   o retorno das requisicões deve estar de acordo com contrato definido