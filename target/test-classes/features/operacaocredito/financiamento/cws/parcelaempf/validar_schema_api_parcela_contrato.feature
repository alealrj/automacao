@TID97476REV0.2.0
Feature: Validar schema API de Financiamento - Parcela EMPF (CWS)

  Scenario: Validar schema API de Financiamento - Parcela EMPF (CWS)
    Given que seja feito uma requisição POST no endpoint de Financiamento - Parcela EMPF
    When pegar o schema da API
    Then  o schema deve ser válido