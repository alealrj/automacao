@TID95101REV0.2.0
Feature: Validar schema API de Financiamento - Lista EMPF (CWS)

  Scenario: Validar schema API de Financiamento - Lista EMPF (CWS)
    Given que seja feito uma requisição POST no endpoint de Financiamento - Lista EMPF
    When pegar o schema da API
    Then  o schema deve ser válido