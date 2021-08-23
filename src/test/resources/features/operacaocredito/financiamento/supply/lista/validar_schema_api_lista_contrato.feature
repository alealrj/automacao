@TID95100REV0.2.0
Feature: Validar schema API de Financiamento - Lista (Supply)

  Scenario: Validar schema API de Financiamento - Lista (Supply)
    Given que seja feito uma requisição GET no endpoint de Financiamento - Lista
    When pegar o schema da API
    Then  o schema deve ser válido