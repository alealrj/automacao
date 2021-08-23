@TID95061REV0.2.1
Feature: Validar disponibilidade API de Saldo da Conta Supply

  Scenario: Validar disponibilidade API de Saldo da Conta
    Given que seja feito uma requisição GET no endpoint de Saldos da Conta
    When pegar o status code da requisição
    Then  o status code deve ser 200