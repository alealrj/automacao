#Auto generated Octane revision tag
@TID91997REV0.2.0
Feature: Validar api de relacionamento pessoa jurídica - Ágora Core

	Scenario: Validar api de relacionamento pessoa jurídica - Ágora Core
    
		Given seja realizada uma requisição GET no endpoint de relacionamento Pessoa Juridica
        Then o usuario deve receber o status code 200
        And o retorno das requisicões deve estar de acordo com contrato definido
		
