@TID95126REV0.2.2
Feature: Validar Schema API Saldo da Conta Core

  Scenario: Validar Schema API Saldo da Conta - Core
    Given que seja feito uma requisição GET no endpoint de Saldos da Conta
    When pegar o schema da API
    Then  o schema deve ser válido