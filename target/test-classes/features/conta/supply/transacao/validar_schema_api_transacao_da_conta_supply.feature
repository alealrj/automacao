@TID95128REV0.2.1
Feature: Validar Schema API Transações da Conta Supply

  Scenario: Validar Schema API Transações da Conta
    Given que seja feito uma requisicao GET no endpoint de Transacoes da Conta
    When pegar o schema da API
    Then  o schema deve ser válido