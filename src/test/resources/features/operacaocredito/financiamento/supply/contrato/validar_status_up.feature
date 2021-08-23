@TID98798REV0.3.0
Feature: Validar status UP API de Financiamento - Contrato (Supply)

  Scenario: Validar status UP API de Financiamento - Contrato (Supply)
    Given que seja feito uma requisição GET no endpoint de status Financiamento - Contrato
    When pegar o status da API
    Then  status deve ser "UP"