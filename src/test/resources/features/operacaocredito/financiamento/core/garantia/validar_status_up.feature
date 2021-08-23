@TID98795REV0.2.0
Feature: Validar status UP API de Financiamento - Garantia Contrato

  Scenario: Validar status UP API de Financiamento - Garantia Contrato
    Given que seja feito uma requisição GET no endpoint de status Financiamento - Garantia Contrato
    When pegar o status da API
    Then  status deve ser "UP"