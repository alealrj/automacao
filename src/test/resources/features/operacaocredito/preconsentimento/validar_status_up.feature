@TID100422REV0.2.0
Feature: Validar status UP API de Pre-Consentimento

  Scenario: Validar status UP API de Pre-Consentimento
    Given que seja feito uma requisição GET no endpoint de status Pre-Consentimento
    When pegar o status da API
    Then  status deve ser "UP"