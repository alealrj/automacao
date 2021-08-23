@TID95047REV0.2.0
Feature: Validar disponibilidade API de Financiamento - Parcelamento Contrato (Supply)

  Scenario: Validar disponibilidade API de Financiamento - Parcelamento Contrato (Supply)
    Given que seja feito uma requisição GET no endpoint de Financiamento - Parcelamento Contrato
    When pegar o status code da requisição
    Then  o status code deve ser 200