@TID95160REV0.5.0
Feature: Validar status de erro para contractId inválido API Adiantamento a Depositante ADPOS - Contrato (Core)

  Scenario: Validar status de erro para contractId inválido API Adiantamento a Depositante ADPOS - Contrato (Core)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Contrato sem informar contractId
    When pegar o status code da requisição
    Then o status code deve ser 503