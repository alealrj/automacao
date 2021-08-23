@TID98289REV0.3.0
Feature: Validar schema API de Empréstimos - Pagamento (core)

  Scenario: Validar schema API de Empréstimos - Pagamento (core)
    Given que seja feito uma requisição GET no endpoint de Empréstimos - Pagamento
    When pegar o schema da API
    Then  o schema deve ser válido