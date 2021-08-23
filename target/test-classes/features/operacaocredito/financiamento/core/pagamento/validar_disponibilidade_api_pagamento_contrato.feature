@TID95043REV0.2.0
Feature: Validar disponibilidade API de Financiamento - Pagamento (Core)

  Scenario: Validar disponibilidade API de Financiamento - Pagamento (Core)
    Given que seja feito uma requisição GET no endpoint de Financiamento - Pagamento
    When pegar o status code da requisição
    Then  o status code deve ser 200