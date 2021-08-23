@TID95085REV0.2.0
Feature: Validar schema API de Empréstimos - Contrato EMPG (CWS)

  Scenario: Validar schema API de Empréstimos - Contrato (CWS)
    Given que seja feito uma requisição POST no endpoint de Empréstimos - Contrato EMPG
    When pegar o schema da API
    Then o schema deve ser válido