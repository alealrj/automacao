@TID95091REV0.2.0
Feature: Validar schema API de Empréstimos - Lista Garantia Contrato GRAN (CWS)

  Scenario: Validar schema API de Empréstimos - Lista Garantia Contrato GRAN (CWS)
    Given que seja feito uma requisição POST no endpoint de Empréstimos - Lista Garantia Contrato GRAN
    When pegar o schema da API
    Then  o schema deve ser válido