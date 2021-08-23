@TID95092REV0.2.0
Feature: Validar schema API de Empréstimos - Pagamento (Supply)

  Scenario: Validar schema API de Empréstimos - Pagamento (Supply)
    Given que seja feito uma requisição GET no endpoint de Empréstimos - Pagamento
    When pegar o schema da API
    Then  o schema deve ser válido