#Auto generated Octane revision tag
@TID91989REV0.2.0
Feature: Validar api de qualificação pessoa juridica - Bradescard Supply

	Scenario: Validar api de qualificação pessoa juridica - Bradescard Supply
		Given seja realizada uma requisição GET no endpoint de qualificação Pessoa Juridica
		When usuario deve receber os status code 200
		Then o retorno das requisicões deve estar de acordo com contrato definido
