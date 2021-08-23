@TID95146REV0.2.0
Feature: Validar status de erro para Authorization com permissão inválida API Fatura

  Scenario: Validar status de erro para Authorization com permissão inválida API Fatura
    Given que seja feito uma requisição GET no endpoint de Fatura Cartões com permissão inválida
    When pegar o status code da requisição
    Then  o status code deve ser 403