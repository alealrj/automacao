@TID95050REV0.4.0
Feature: Validar disponibilidade API de Identificação da Conta Supply

  Scenario: Validar disponibilidade API de Identificação da Conta
    Given que seja feito uma requisição GET no endpoint de Identificação da Conta
    When pegar o status code da requisição
    Then  o status code deve ser 200