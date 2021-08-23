@TID95098REV0.2.0
Feature: Validar schema API de Financiamento - Garantia Contrato (Core)

  Scenario: Validar schema API de Financiamento - Garantia Contrato (Core)
    Given que seja feito uma requisição GET no endpoint de Financiamento - Garantia Contrato
    When pegar o schema da API
    Then  o schema deve ser válido