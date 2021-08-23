@TID95093REV0.2.0
Feature: Validar schema API de Empréstimos - Parcelamento Contrato (Supply)

  Scenario: Validar schema API de Empréstimos - Parcelamento Contrato (Supply)
    Given que seja feito uma requisição GET no endpoint de Empréstimos - Parcelamento Contrato
    When pegar o schema da API
    Then  o schema deve ser válido