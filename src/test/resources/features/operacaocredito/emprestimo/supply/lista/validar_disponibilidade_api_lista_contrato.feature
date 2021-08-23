@TID95029REV0.2.0
Feature: Validar disponibilidade API de Empréstimos - Lista (Supply)

  Scenario: Validar disponibilidade API de Empréstimos - Lista (Supply)
    Given que seja feito uma requisição GET no endpoint de Empréstimos - Lista
    When pegar o status code da requisição
    Then  o status code deve ser 200