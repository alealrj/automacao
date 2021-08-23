#Auto generated Octane revision tag
@TID95400REV0.3.0
Feature: Validar api de identificacao de pessoa natural - Losango Supply 

	Scenario: Validar api de identificacao de pessoa natural - Losango Supply     
		Given seja realizada uma requisição GET no endpoint de Identificacao Pessoa Natural
	    Then  deve retornar status code 200 para chamada de Identificacao Pessoa Natural
		And   o retorno deve estar de acordo com contrato de Identificacao Pessoa Natural 
