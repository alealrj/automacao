@TID98800REV0.1.0
Feature: Validar status UP API de Financiamento - Parcelamento Contrato (Supply)

  Scenario: Validar status UP API de Financiamento - Parcelamento Contrato (Supply)
    Given que seja feito uma requisição GET no endpoint de status Financiamento - Parcelamento Contrato
    When pegar o status da API
    Then  status deve ser "UP"