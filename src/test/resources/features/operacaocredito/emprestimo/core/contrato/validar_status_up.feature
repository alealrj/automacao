@TID97938REV0.2.0
Feature: Validar status UP API de Empréstimos - Contrato (Core)

  Scenario: Validar status UP API de Empréstimos - Contrato (Core)
    Given que seja feito uma requisição GET no endpoint de status Empréstimos - Contrato
    When pegar o status da API
    Then  status deve ser "UP"