@TID98799REV0.2.0
Feature: Validar status UP API de Financiamento - Lista (Supply)

  Scenario: Validar status UP API de Financiamento - Lista (Supply)
    Given que seja feito uma requisição GET no endpoint de status Financiamento - Lista
    When pegar o status da API
    Then  status deve ser "UP"