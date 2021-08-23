#Auto generated Octane revision tag
@TID100017REV0.2.0
Feature: Validar api de relacionamento de pessoa juridica - Bradesco Core

  Scenario: Validar api de relacionamento de pessoa juridica - Bradesco Core
    Given seja realizada uma requisição GET no endpoint de relacionamento Pessoa Juridica
    Then deve retornar status code 200 para chamada de relacionamento Pessoa Juridica
    And o retorno deve estar de acordo com contrato de relacionamento Pessoa Juridica
		
