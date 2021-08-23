@TID98521REV0.2.0
Feature: Validar status UP API de Empréstimos - Garantia Contrato (Core)

  Scenario: Validar status UP API de Empréstimos - Garantia Contrato (Core)
    Given que seja feito uma requisição GET no endpoint de status Empréstimos - Garantia Contrato
    When pegar o status da API
    Then  status deve ser "UP"