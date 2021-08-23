@TID95162REV0.3.0
Feature: Validar status de erro para contractId inválido API Adiantamento a Depositante ADPOS - Pagamento (Supply)

  Scenario: Validar status de erro para contractId inválido API Adiantamento a Depositante ADPOS - Pagamento (Supply)
    Given que seja feito uma requisição GET no endpoint de Adiantamento a Depositante ADPOS - Pagamento sem informar contractId
    When pegar o status code da requisição
    Then o status code deve ser 503