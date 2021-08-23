@TID95059REV0.2.0
Feature: Validar disponibilidade API de Pre-Consentimento

  Scenario: Validar disponibilidade API de Pre-Consentimento
    Given que seja feito uma requisição GET no endpoint de Pre-Consentimento
    When pegar o status code da requisição
    Then  o status code deve ser 200