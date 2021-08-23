@TID95127REV0.2.2
Feature: Validar Schema API Saldo da Conta Supply

  Scenario: Validar Schema API Saldo da Conta - Supply
    Given que seja feito uma requisição GET no endpoint de Saldos da Conta
    When pegar o schema da API
    Then  o schema deve ser válido