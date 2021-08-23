@TID95024REV0.2.0
Feature: Validar disponibilidade API de Empréstimos - Contrato (Supply)

  Scenario: Validar disponibilidade API de Empréstimos - Contrato (Supply)
    Given que seja feito uma requisição GET no endpoint de Empréstimos - Contrato
    When pegar o status code da requisição
    Then  o status code deve ser 200