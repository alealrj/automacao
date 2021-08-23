@TID97941REV0.2.0
Feature: Validar status UP API de Empréstimos - Garantia Contrato (Supply)

  Scenario: Validar status UP API de Empréstimos - Garantia Contrato (Supply)
    Given que seja feito uma requisição GET no endpoint de status Empréstimos - Garantia Contrato
    When pegar o status da API
    Then  status deve ser "UP"