@TID95088REV0.2.0
Feature: Validar schema API de Empréstimos - Lista (Supply)

  Scenario: Validar schema API de Empréstimos - Lista (Supply)
    Given que seja feito uma requisição GET no endpoint de Empréstimos - Lista
    When pegar o schema da API
    Then  o schema deve ser válido