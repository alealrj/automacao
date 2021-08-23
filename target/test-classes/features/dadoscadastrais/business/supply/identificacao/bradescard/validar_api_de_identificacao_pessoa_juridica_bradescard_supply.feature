#Auto generated Octane revision tag
@TID91980REV0.2.0
Feature: Validar api de identificação pessoa jurídica - Bradescard Supply

	Scenario: Validar api de identificação pessoa jurídica - Bradescard Supply
		Given seja realizada uma requisição GET no endpoint de Identificação Pessoa Juridica
		When usuario deve receber os status code 200
		Then o retorno das requisicões deve estar de acordo com contrato definido
