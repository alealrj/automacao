@TID95110REV0.2.0
Feature: Validar schema API de Pre-Consentimento

  Scenario: Validar schema API de Pre-Consentimento
    Given que seja feito uma requisição GET no endpoint de Pre-Consentimento
    When pegar o schema da API
    Then  o schema deve ser válido