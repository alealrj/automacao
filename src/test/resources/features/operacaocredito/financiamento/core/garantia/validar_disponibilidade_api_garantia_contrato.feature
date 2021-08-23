@TID95039REV0.2.0
Feature: Validar disponibilidade API de Financiamento - Garantia Contrato (Core)

  Scenario: Validar disponibilidade API de Financiamento - Garantia Contrato (Core)
    Given que seja feito uma requisição GET no endpoint de Financiamento - Garantia Contrato
    When pegar o status code da requisição
    Then  o status code deve ser 200