@TID98525REV0.2.0
Feature: Validar status UP API de Empréstimos - Lista (Supply)

  Scenario: Validar status UP API de Empréstimos - Lista (Supply)
    Given que seja feito uma requisição GET no endpoint de status Empréstimos - Lista
    When pegar o status da API
    Then  status deve ser "UP"