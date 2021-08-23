@TID95085REV0.2.0
Feature: Validar schema API de Empréstimos - Contrato EMPF (CWS)

  Scenario: Validar schema API de Empréstimos - Contrato EMPF (CWS)
    Given que seja feito uma requisição POST no endpoint de Empréstimos - Contrato EMPF
    When pegar o schema da API
    Then o schema deve ser válido