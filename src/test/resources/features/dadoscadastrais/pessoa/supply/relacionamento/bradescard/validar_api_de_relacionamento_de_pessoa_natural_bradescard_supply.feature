#Auto generated Octane revision tag
@TID95002REV0.2.0
Feature: Validar api de relacionamento pessoa natural - Bradescard Supply

  Scenario: Validar api de relacionamento pessoa natural - Bradescard Supply
    Given seja realizada uma requisição GET no endpoint de relacionamento Pessoa Natural
    When usuario deve receber os status code 200
    Then o retorno das requisicões deve estar de acordo com contrato definido