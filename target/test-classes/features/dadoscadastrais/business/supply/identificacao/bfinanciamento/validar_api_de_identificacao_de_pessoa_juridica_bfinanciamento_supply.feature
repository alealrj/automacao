#Auto generated Octane revision tag
@TID95671REV0.3.0
Feature: Validar api de identificacao de pessoa juridica - BFinanciamentos Supply   

	Scenario: Validar api de identificacao de pessoa juridica - BFinanciamentos Supply   
		Given seja realizada uma requisição GET no endpoint de Identificacao Pessoa Juridica
        Then deve retornar status code 200 para chamada de Identificacao Pessoa Juridica
        And o retorno deve estar de acordo com contrato de Identificacao Pessoa Juridica
		
