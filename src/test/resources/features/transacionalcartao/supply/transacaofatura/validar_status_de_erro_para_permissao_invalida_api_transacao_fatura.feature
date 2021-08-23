@TID95150REV0.2.0
Feature: Validar status de erro para Authorization com permissão inválida API Transação por Fatura

  Scenario: Validar status de erro para Authorization com permissão inválida API Transação por Fatura
    Given que seja feito uma requisição GET no endpoint de Transação por Fatura Cartões com permissão inválida
    When pegar o status code da requisição
    Then  o status code deve ser 403