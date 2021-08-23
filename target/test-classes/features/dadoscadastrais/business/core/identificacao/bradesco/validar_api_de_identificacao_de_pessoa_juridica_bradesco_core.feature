#Auto generated Octane revision tag
@TID99161REV0.3.0
Feature: Validar api de identificação de pessoa juridica - Bradesco Core

  Scenario: Validar api de identificação de pessoa juridica - Bradesco Core
    Given seja realizada uma requisição GET no endpoint de Identificação Pessoa Juridica
    Then deve retornar status code 200 para chamada de Identificação Pessoa Juridica
    And o retorno deve estar de acordo com contrato de Identificação Pessoa Juridica
		
