@TID95104REV0.2.0
Feature: Validar schema API de Financiamento - Pagamento EMPF (CWS)

  Scenario: Validar schema API de Financiamento - Pagamento EMPF (CWS)
    Given que seja feito uma requisição POST no endpoint de Financiamento - Pagamento EMPF
    When pegar o schema da API
    Then  o schema deve ser válido