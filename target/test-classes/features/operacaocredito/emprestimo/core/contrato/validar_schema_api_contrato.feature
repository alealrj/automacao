@TID95082REV0.2.0
Feature: Validar schema API de Empréstimos - Contrato (Core)

  Scenario: Validar schema API de Empréstimos - Contrato (Core)
    Given que seja feito uma requisição GET no endpoint de Empréstimos - Contrato
    When pegar o schema da API
    Then  o schema deve ser válido