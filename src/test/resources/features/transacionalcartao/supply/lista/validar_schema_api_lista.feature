@TID95109REV0.4.0
Feature: Validar schema API de Lista de Cartões (Supply)

  Scenario: Validar schema API de Lista de Cartões (Supply)
    Given que seja feito uma requisição GET no endpoint de Lista de Cartões
    When pegar o schema da API
    Then  o schema deve ser válido