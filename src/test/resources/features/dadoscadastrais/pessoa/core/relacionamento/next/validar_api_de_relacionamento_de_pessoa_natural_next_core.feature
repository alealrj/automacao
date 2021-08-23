#Auto generated Octane revision tag
@TID106963REV0.2.0
Feature: Validar api de relacionamento de pessoa natural - Next Core

  Scenario: Validar api de relacionamento de pessoa natural - Next Core
    Given seja realizada uma requisição GET no endpoint de relacionamento Pessoa Natural
    Then deve retornar status code 200 para chamada de relacionamento Pessoa Natural
    And o retorno deve estar de acordo com contrato de relacionamento Pessoa Natural
		
