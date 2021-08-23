#Auto generated Octane revision tag
@TID99162REV0.4.0
Feature: Validar api de qualificação de pessoa juridica - Bradesco Core

  Scenario: Validar api de qualificação de pessoa juridica - Bradesco Core
    Given seja realizada uma requisição GET no endpoint de qualificação Pessoa Juridica
    Then deve retornar status code 200 para chamada de qualificação Pessoa Juridica
    And o retorno deve estar de acordo com contrato de qualificação Pessoa Juridica
		
