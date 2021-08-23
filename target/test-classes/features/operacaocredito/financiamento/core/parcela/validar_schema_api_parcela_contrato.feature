@TID95105REV0.2.0
Feature: Validar schema API de Financiamento - Parcelamento Contrato (Core)

  Scenario: Validar schema API de Financiamento - Parcelamento Contrato (Core)
    Given que seja feito uma requisição GET no endpoint de Financiamento - Parcelamento Contrato
    When pegar o schema da API
    Then  o schema deve ser válido