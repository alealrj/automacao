@TID95087REV0.2.0
Feature: Validar schema API de Empréstimos - Garantia Contrato (Supply)

  Scenario: Validar schema API de Empréstimos - Garantia Contrato (Supply)
    Given que seja feito uma requisição GET no endpoint de Empréstimos - Garantia Contrato
    When pegar o schema da API
    Then  o schema deve ser válido