@TID95149REV0.2.0
Feature: Validar status de erro para Authorization com permissão inválida API Lista

  Scenario: Validar status de erro para Authorization com permissão inválida API Lista
    Given que seja feito uma requisição GET no endpoint de Lista Cartões com permissão inválida
    When pegar o status code da requisição
    Then  o status code deve ser 403