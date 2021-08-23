@TID95161REV0.2.0
Feature: Validar status de erro para contractId inválido API Adiantamento a Depositante ADPOS - Contrato (Supply)

  Scenario: Validar status de erro para contractId inválido API Adiantamento a Depositante ADPOS - Contrato (Supply)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Contrato sem informar contractId
    When pegar o status code da requisição
    Then o status code deve ser 503
    And a mensagem de erro deve ser "Error when trying to get unarranged contract on consent client "