@TID98797REV0.2.0
Feature: Validar status UP API de Financiamento - Parcelamento Contrato (Core)

  Scenario: Validar status UP API de Financiamento - Parcelamento Contrato (Core)
    Given que seja feito uma requisição GET no endpoint de status de Financiamento - Parcelamento Contrato
    When pegar o status da API
    Then  status deve ser "UP"