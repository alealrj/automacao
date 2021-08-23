@TID95041REV0.2.0
Feature: Validar disponibilidade API de Financiamento - Lista (Supply)

  Scenario: Validar disponibilidade API de Financiamento - Lista (Supply)
    Given que seja feito uma requisição GET no endpoint de Financiamento - Lista
    When pegar o status code da requisição
    Then  o status code deve ser 200