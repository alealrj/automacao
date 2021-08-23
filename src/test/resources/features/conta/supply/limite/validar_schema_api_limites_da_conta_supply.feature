@TID95121REV0.2.2
Feature: Validar Schema API Limites da Conta Supply

  Scenario: Validar Schema API Limites da Conta
    Given que seja feito uma requisição GET no endpoint de Limites da Conta
    When pegar o schema da API
    Then  o schema deve ser válido