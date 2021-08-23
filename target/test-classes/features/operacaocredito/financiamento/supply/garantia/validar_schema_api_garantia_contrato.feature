@TID95099REV0.2.0
Feature: Validar schema API de Financiamento - Garantia Contrato (Supply)

  Scenario: Validar schema API de Financiamento - Garantia Contrato (Supply)
    Given que seja feito uma requisição GET no endpoint de Financiamento - Garantia Contrato
    When pegar o schema da API
    Then  o schema deve ser válido