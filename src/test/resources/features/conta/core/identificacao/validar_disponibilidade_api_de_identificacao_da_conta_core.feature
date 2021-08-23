@TID95048REV0.2.2.1
Feature: Validar disponibilidade API de Identificação da Conta Core

  Scenario: Validar disponibilidade API de Identificação da Conta
    Given que seja feito uma requisição GET no endpoint de Identificação da Conta
    When pegar o status code da requisição
    Then  o status code deve ser 200