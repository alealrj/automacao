#Auto generated Octane revision tag
@TID91987REV0.2.0
Feature: Validar api de qualificação pessoa jurídica - Ágora Core 

	Scenario: Validar api de qualificação pessoa jurídica - Ágora Core

    Given seja realizada uma requisição GET no endpoint de qualificação Pessoa Juridica
    Then o usuario deve receber o status code 200
    And o retorno das requisicões deve estar de acordo com contrato definido
		
