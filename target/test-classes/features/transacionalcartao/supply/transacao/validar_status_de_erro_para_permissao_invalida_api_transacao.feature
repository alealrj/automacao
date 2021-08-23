@TID95150REV0.2.0
Feature: Validar status de erro para Authorization com permissão inválida API Transações

  Scenario: Validar status de erro para Authorization com permissão inválida API Transações
    Given que seja feito uma requisição GET no endpoint de Transações Cartões com permissão inválida
    When pegar o status code da requisição
    Then  o status code deve ser 403