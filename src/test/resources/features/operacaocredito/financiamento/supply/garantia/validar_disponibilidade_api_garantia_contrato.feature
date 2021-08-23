@TID95040REV0.2.0
Feature: Validar disponibilidade API de Financiamento - Garantia Contrato (Supply)

  Scenario: Validar disponibilidade API de Financiamento - Garantia Contrato (Supply)
    Given que seja feito uma requisição GET no endpoint de Financiamento - Garantia Contrato
    When pegar o status code da requisição
    Then  o status code deve ser 200