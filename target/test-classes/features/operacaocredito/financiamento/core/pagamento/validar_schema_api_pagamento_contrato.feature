@TID95102REV0.2.0
Feature: Validar schema API de Financiamento - Pagamento (Core)

  Scenario: Validar schema API de Financiamento - Pagamento (Core)
    Given que seja feito uma requisição GET no endpoint de Financiamento - Pagamento
    When pegar o schema da API
    Then  o schema deve ser válido