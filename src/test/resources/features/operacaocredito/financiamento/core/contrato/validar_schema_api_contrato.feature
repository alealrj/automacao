@TID95095REV0.2.0
Feature: Validar schema API de Financiamento - Contrato (Core)

  Scenario: Validar schema API de Financiamento - Contrato (Core)
    Given que seja feito uma requisição GET no endpoint de Financiamento - Contrato
    When pegar o schema da API
    Then  o schema deve ser válido