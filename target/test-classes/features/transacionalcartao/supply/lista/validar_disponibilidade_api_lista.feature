@TID95056REV0.4.0
Feature: Validar disponibilidade API de Lista de Cartões (Supply)

  Scenario: Validar disponibilidade API de Lista de Cartões (Supply)
    Given que seja feito uma requisição GET no endpoint de Lista de Cartões
    When pegar o status code da requisição
    Then  o status code deve ser 200