@TID95089REV0.2.0
Feature: Validar schema API de Empréstimos - Lista CHES (CWS)

  Scenario: Validar schema API de Empréstimos - Lista CHES (CWS)
    Given que seja feito uma requisição POST no endpoint de Empréstimos - Lista CHES
    When pegar o schema da API
    Then  o schema deve ser válido
