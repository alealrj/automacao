@TID95023REV0.2.0
Feature: Validar disponibilidade API de Empréstimos - Contrato (Core)

  Scenario: Validar disponibilidade API de Empréstimos - Contrato (Core)
    Given que seja feito uma requisição GET no endpoint de Empréstimos - Contrato
    When pegar o status code da requisição
    Then  o status code deve ser 200