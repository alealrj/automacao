@TID99084REV0.2.0
Feature: Validar status UP API de Financiamento - Contrato (Core)

  Scenario: Validar status UP API de Financiamento - Contrato (Core)
    Given que seja feito uma requisição GET no endpoint de status Financiamento - Contrato
    When pegar o status da API
    Then  status deve ser "UP"