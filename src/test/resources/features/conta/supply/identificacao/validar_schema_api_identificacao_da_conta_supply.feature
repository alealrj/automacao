@TID95119REV0.3.1
Feature: Validar Schema API Identificação da Conta Supply

  Scenario: Validar Schema API Identificação da Conta
    Given que seja feito uma requisição GET no endpoint de Identificação da Conta
    When pegar o schema da API
    Then  o schema deve ser válido