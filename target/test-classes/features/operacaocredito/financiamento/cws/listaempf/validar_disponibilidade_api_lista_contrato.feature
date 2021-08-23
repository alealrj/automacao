@TID95042REV0.2.0
Feature: Validar disponibilidade API de Financiamento - Lista EMPF (CWS)

  Scenario: Validar disponibilidade API de Financiamento - Lista EMPF (CWS)
    Given que seja feito uma requisição POST no endpoint de Financiamento - Lista EMPF
    When pegar o status code da requisição
    Then  o status code deve ser 200