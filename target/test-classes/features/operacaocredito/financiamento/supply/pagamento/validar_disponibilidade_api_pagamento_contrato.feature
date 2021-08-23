@TID95044REV0.2.0
Feature: Validar disponibilidade API de Financiamento - Pagamento (Supply)

  Scenario: Validar disponibilidade API de Financiamento - Pagamento (Supply)
    Given que seja feito uma requisição GET no endpoint de Financiamento - Pagamento
    When pegar o status code da requisição
    Then  o status code deve ser 200