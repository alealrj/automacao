#Auto generated Octane revision tag
@TID106969REV0.2.0
Feature: Validar api de relacionamento de pessoa natural - Next Supply

	Scenario: Validar api de relacionamento de pessoa natural - Next Supply

		Given seja realizada uma requisição GET no endpoint de Relacionamento Pessoa Natural
		Then  deve retornar status code 200 para chamada de Relacionamento Pessoa Natural
		And   o retorno deve estar de acordo com contrato de Relacionamento Pessoa Natural

	