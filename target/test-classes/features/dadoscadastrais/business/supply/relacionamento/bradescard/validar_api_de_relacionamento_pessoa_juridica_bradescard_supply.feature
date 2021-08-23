#Auto generated Octane revision tag
@TID91999REV0.2.0
Feature: Validar api de relacionamento pessoa jurídica - Bradescard Supply

	Scenario: Validar api de relacionamento pessoa jurídica - Bradescard Supply
		Given seja realizada uma requisição GET no endpoint de relacionamento Pessoa Juridica
		When usuario deve receber os status code 200
		Then o retorno das requisicões deve estar de acordo com contrato definido
