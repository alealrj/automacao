#Auto generated Octane revision tag
@TID106968REV0.2.0
Feature: Validar api de qualificação pessoa natural - Next Supply

	Scenario: Validar api de qualificação pessoa natural - Next Supply

		Given seja realizada uma requisição GET no endpoint de Qualificação Pessoa Natural
		Then  deve retornar status code 200 para chamada de Qualificação Pessoa Natural
		And   o retorno deve estar de acordo com contrato de Qualificação Pessoa Natural
		